package com.example.demo.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * description
 *
 * @author : jkkim
 */
@Entity
@Getter
@Setter
@ToString
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long surveyId;

    private String surveyName;
    @Temporal(TemporalType.DATE)
    private Date surveyStartDate;
    @Temporal(TemporalType.DATE)
    private Date surveyEndDate;
    private String useYn;
    private String delYn;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    private Collection<Page> pageList;

}
