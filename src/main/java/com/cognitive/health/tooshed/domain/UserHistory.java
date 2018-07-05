package com.cognitive.health.tooshed.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "user_history")
public class UserHistory {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    @Column
    String userName;

    @Column
    Timestamp loginTime;

    @Column
    Timestamp logoutTime;

    @Column
    Boolean surveyCompleted;

}
