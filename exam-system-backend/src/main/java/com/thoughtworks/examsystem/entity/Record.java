package com.thoughtworks.examsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: Realks
 * @Date: 2018/7/28 23:23
 * @Description:
 */
@Entity
@Table(name = "tb_record")
@Getter
@Setter
public class Record {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paper_user_id")
    private Integer paperUserId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column
    private String answer;

    @Column(name = "is_correct")
    private Boolean isCorrect;
}
