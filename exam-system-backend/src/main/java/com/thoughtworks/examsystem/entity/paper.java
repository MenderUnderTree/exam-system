package com.thoughtworks.examsystem.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: Realks
 * @Date: 2018/7/28 22:44
 * @Description:
 */
@Entity
@Table(name = "tb_paper")
@Getter
@Setter
public class Paper {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer price;

}
