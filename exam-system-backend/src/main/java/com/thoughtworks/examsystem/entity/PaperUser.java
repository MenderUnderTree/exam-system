package com.thoughtworks.examsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: Realks
 * @Date: 2018/7/29 02:06
 * @Description:
 */
@Entity
@Getter
@Setter
@Table(name = "tb_paper_user")
public class PaperUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "paper_id")
    private Long paperId;

    @Column
    private Long point;
}
