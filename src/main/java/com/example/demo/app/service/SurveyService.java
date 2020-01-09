package com.example.demo.app.service;

import com.example.demo.app.entity.Survey;
import com.example.demo.app.repository.SurveyRepository;
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
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;


    public Survey createSurvey(Survey survey) {

        return surveyRepository.save(survey);
    }
}
