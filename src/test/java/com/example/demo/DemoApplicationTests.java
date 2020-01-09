package com.example.demo;

import com.example.demo.app.entity.Survey;
import com.example.demo.app.repository.SurveyRepository;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    SurveyRepository surveyRepository;


    @Test
    void contextLoads() {
        /*PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String enc = passwordEncoder.encode("$2a$10$WKlYiipGgrN4FJ.l0CtX6e3BWRulOtrbERBpynDtl5U6APuBtydaG");
        System.out.println(enc);
        System.out.println(passwordEncoder.matches("1234", "$2a$10$WKlYiipGgrN4FJ.l0CtX6e3BWRulOtrbERBpynDtl5U6APuBtydaG"));
        System.out.println(passwordEncoder.matches("1234", enc));*/
        EnvironmentStringPBEConfig environmentStringPBEConfig = new EnvironmentStringPBEConfig();
        environmentStringPBEConfig.setAlgorithm("PBEWithMD5AndDES");
        environmentStringPBEConfig.setPasswordEnvName("APP_ENCRYPTION_PASSWORD");
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setConfig(environmentStringPBEConfig);
        standardPBEStringEncryptor.setPassword("ON]ptM)kaYEQ");
        System.out.println(standardPBEStringEncryptor.encrypt("19wnsghqlxl10#)"));
        System.out.println(standardPBEStringEncryptor.decrypt(standardPBEStringEncryptor.encrypt("19wnsghqlxl10#)")));
    }

    @Test
    @Transactional
    @Rollback(false)
    void insertUser() throws Exception {
        Survey survey = new Survey();
        survey.setUseYn("Y");
        survey.setDelYn("N");
        survey.setSurveyName("신규설문");
        survey = surveyRepository.save(survey);
    }

}
