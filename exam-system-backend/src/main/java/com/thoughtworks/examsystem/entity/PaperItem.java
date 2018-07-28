package com.thoughtworks.examsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: Realks
 * @Date: 2018/7/28 23:18
 * @Description:
 */
@Embeddable
@Table(name = "tb_paper_item")
@Getter
@Setter
public class PaperItem {
    @Column(name = "paper_id")
    private Integer paperId;

    @Column(name = "item_id")
    private Integer itemId;
}
