package com.thoughtworks.examsystem.entity;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Set;

/**
 * @author : luoweiyao
 * @created : 2018/7/28
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.entity
 */
@Entity
@Table(name = "tb_papar")
public class paper {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @ManyToMany(mappedBy = "papers")
    public Set<Item> items;

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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
