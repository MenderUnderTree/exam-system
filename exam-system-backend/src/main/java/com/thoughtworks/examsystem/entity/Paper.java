package com.thoughtworks.examsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: Realks
 * @Date: 2018/7/29 04:04
 * @Description:
 */
@Entity
@Table(name = "tb_paper")
@Getter
@Setter
public class Paper {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @ManyToMany
    @JoinTable(
            name = "tb_paper_item",
            joinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "paper_id",referencedColumnName = "id",nullable = false)}
    )
    private List<Item> items;
}

