package com.cognitive.health.toolshed.domain.surveys;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "flow")
public class Flow {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String surveyName;

    @Column
    private String userName;

    @Column
    private int fss1;

    @Column
    private int fss2;

    @Column
    private int fss3;

    @Column
    private int fss4;

    @Column
    private int fss5;

    @Column
    private int fss6;

    @Column
    private int fss7;

    @Column
    private int fss8;

    @Column
    private int fss9;

    @Column
    private int fss10;

    @Column
    private int fss11;

    @Column
    private int fss12;

    @Column
    private int fss13;

    @Column
    private int fssA;

    @Column
    private int fssB;

    @Column
    private int fssC;

    @Column
    private Timestamp dateRecorded;

}
