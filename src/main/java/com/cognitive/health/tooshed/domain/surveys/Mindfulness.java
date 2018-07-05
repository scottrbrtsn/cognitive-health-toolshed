package com.cognitive.health.tooshed.domain.surveys;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "mindfulness")
public class Mindfulness {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String surveyName;

    @Column
    private String userName;

    @Column
    private int opened;

    @Column
    private int body;

    @Column
    private int returned;

    @Column
    private int appreciate;

    @Column
    private int intentions;

    @Column
    private int nonjudgement;

    @Column
    private int connected;

    @Column
    private int acceptance;

    @Column
    private int friendly;

    @Column
    private int watchful;

    @Column
    private int pause;

    @Column
    private int peace;

    @Column
    private int patient;

    @Column
    private int smile;

    @Column
    private Timestamp dateRecorded;
}
