package com.example.demo.app.controller;

import com.example.demo.app.entity.AuthDto;
import com.example.demo.app.service.AuthService;
import com.example.demo.app.common.constant.UserType;
import com.example.demo.config.security.CustomUserDetails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;

/**
 * description
 *
 * @author : jkkim
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * 로그인 화면 이동
     *
     * @return
     */
    @GetMapping("/login")
    public String goToLoginPage(HttpServletRequest request) {
        SecurityContextHolder.clearContext();
        return "/auth/login";
    }

    /**
     * 로그인
     *
     * @param authDto
     * @return
     */
    @PostMapping("/loginProcess")
    public String loginProcess(HttpServletRequest request, AuthDto authDto) {
        //
        String forwardUrl = "/login?error";
        //사용자 조회
        AuthDto findUserEntity = authService.findUserById(authDto);
        //사용자 null 체크
        if (findUserEntity == null) {
            return "redirect:/login?error";
        }

        //비밀번호 비교
        if (passwordEncoder.matches(authDto.getPassword(), findUserEntity.getPassword())) {
            //사용자유형
            UserType userType = findUserEntity.getUserType();
            //인증여부
            boolean isAuthentication = false;

            switch (userType) {
                case USER:
                    //인증키 체크
                    if (StringUtils.equals(authDto.getAuthKey(), findUserEntity.getAuthKey())) {
                        isAuthentication = true;
                    }
                    break;
                case ADMIN:
                    //IP체크
                    if(new IpAddressMatcher(findUserEntity.getAuthKey()).matches(request)) {
                        isAuthentication = true;
                    }
                    break;
            }

            //인증된 경우
            if (isAuthentication) {
                forwardUrl = "/main";
                Collection<? extends GrantedAuthority> authorities =
                        Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority(userType.getCode())});
                CustomUserDetails customUserDetails = new CustomUserDetails(findUserEntity.getUserId(), findUserEntity.getPassword(), authorities, findUserEntity.getUserNm());
                //set security context
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(customUserDetails, findUserEntity.getPassword(), authorities);
                Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(authentication);
            }
        }

        return "redirect:" + forwardUrl;
    }

}
