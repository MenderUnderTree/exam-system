package com.thoughtworks.examsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_name", length = 25, nullable = false, unique = true)
    private String userName;

    @Column(length = 25, nullable = false)
    private String pwd;
}
