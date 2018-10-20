package com.cognitive.health.toolshed.domain.surveys;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "anxiety")
public class Anxiety {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String surveyName;

    @Column
    private String userName;

    @Column
    private int gad1;

    @Column
    private int gad2;

    @Column
    private int gad3;

    @Column
    private int gad4;

    @Column
    private int gad5;

    @Column
    private int gad6;

    @Column
    private int gad7;

    @Column
    private int gad8;

    @Column
    private int total;

    @Column
    private Timestamp dateRecorded;
    
}
