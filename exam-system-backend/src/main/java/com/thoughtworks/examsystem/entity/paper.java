package com.thoughtworks.examsystem.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: Realks
 * @Date: 2018/7/28 22:44
 * @Description:
 */
@Entity
@Table(name = "tb_paper")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
