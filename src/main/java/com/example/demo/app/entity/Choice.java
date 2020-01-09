package com.example.demo.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * description
 *
 * @author : jkkim
 */
@Entity
@Getter
@Setter
public class Choice {

    @Id
    private String choiceId;

}
