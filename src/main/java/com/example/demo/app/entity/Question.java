package com.example.demo.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * description
 *
 * @author : jkkim
 */
@Entity
@Getter
@Setter
public class Question {

    @Id
    private String questionId;


}
