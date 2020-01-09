package com.example.demo.app.service;

import com.example.demo.app.entity.AuthDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description
 *
 * @author : jkkim
 */
@Service
@Transactional
public class AuthService {

    @Autowired
    private ModelMapper modelMapper;


    /**
     * 로그인
     *
     * @param authDto
     * @return
     */
    public AuthDto findUserById(AuthDto authDto) {
        /*User findUser = authRepository.findOne(Example.of(
                User.builder()
                    .userId(authDto.getUserId())
                    .useYn("Y")
                    .build())).orElse(null);
        return modelMapper.map(findUser, AuthDto.class);*/
        return null;
    }


}
