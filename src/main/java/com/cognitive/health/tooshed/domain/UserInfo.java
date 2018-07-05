package com.cognitive.health.tooshed.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String ip;

    @Column
    private String host;

    @Column
    private String user;

}
