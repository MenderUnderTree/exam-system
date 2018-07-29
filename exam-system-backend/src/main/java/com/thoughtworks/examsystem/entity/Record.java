package com.thoughtworks.examsystem.entity;

import com.thoughtworks.examsystem.entity.enums.Option;
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
    private Long paperUserId;

    @Column(name = "item_id")
    private Long itemId;

    @Column
    private Option answer;

    @Column(name = "is_correct")
    private Boolean isCorrect;
}
