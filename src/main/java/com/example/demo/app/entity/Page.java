package com.example.demo.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * description
 *
 * @author : jkkim
 */
@Entity
@Getter
@Setter
public class Page {

    @Id
    @GeneratedValue
    private String pageId;

    @ManyToOne
    @JoinColumn(name = "SURVEY_ID")
    private Survey survey;

}
