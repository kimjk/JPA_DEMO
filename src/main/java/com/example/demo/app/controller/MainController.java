package com.example.demo.app.controller;

import com.example.demo.app.common.constant.UserType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description
 *
 * @author : jkkim
 */
@Controller
public class MainController {

    /**
     * 권한별 메인화면 이동
     *
     * @return
     */
    @GetMapping("/main")
    public String goToMainViewByRole() {
        String returnUrl = "/mobile/main";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals(UserType.ADMIN.getCode()));
        if (hasAdmin) {
            returnUrl = "/sysmng/adminMain";
        }
        return returnUrl;
    }
}
