package com.cognitive.health.toolshed.domain.surveys;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "personality")
public class Personality {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String surveyName;

    @Column
    private String userName;

    @Column
    private int bfi1;

    @Column
    private int bfi2;

    @Column
    private int bfi3;

    @Column
    private int bfi4;

    @Column
    private int bfi5;

    @Column
    private int bfi6;

    @Column
    private int bfi7;

    @Column
    private int bfi8;

    @Column
    private int bfi9;

    @Column
    private int bfi10;

    @Column
    private Timestamp dateRecorded;

}
