package com.example.demo.app.repository;

import com.example.demo.app.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * description
 *
 * @author : jkkim
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
