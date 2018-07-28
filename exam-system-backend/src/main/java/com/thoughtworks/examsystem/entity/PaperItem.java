package com.thoughtworks.examsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @Auther: Realks
 * @Date: 2018/7/28 23:18
 * @Description:
 */
@Entity
@Table(name = "tb_paper_item")
@Getter
@Setter
public class PaperItem {
    @Column(name = "paper_id")
    private Integer paperId;

    @Column(name = "item_id")
    private Integer itemId;
}
