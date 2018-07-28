package com.thoughtworks.examsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: Realks
 * @Date: 2018/7/28 23:14
 * @Description:
 */
@Entity
@Table(name = "tb_item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String description;

    @Column
    private String optionA;

    @Column
    private Integer count;

    @Column
    private String optionB;

    @Column
    private String optionCA;

    @Column
    private String optionD;

    @Column
    private String correct;
}
