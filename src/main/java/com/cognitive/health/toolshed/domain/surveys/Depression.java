package com.cognitive.health.toolshed.domain.surveys;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "depression")
public class Depression {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String surveyName;

    @Column
    private String userName;

    @Column
    private int phq1;

    @Column
    private int phq2;

    @Column
    private int phq3;

    @Column
    private int phq4;

    @Column
    private int phq5;

    @Column
    private int phq6;

    @Column
    private int phq7;

    @Column
    private int phq8;

    @Column
    private int phq9;

    @Column
    private int phq10;

    @Column
    private int total;

    @Column
    private Timestamp dateRecorded;
}
