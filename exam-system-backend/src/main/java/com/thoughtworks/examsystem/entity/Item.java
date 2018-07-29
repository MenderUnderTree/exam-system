package com.thoughtworks.examsystem.entity;

import com.thoughtworks.examsystem.entity.enums.Option;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author : luoweiyao
 * @created : 2018/7/28
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.entity
 */
@Entity
@Table(name = "tb_item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column
    private Integer points;

    @Column(nullable = false)
    private String optionA;

    @Column(nullable = false)
    private String optionB;

    @Column(nullable = false)
    private String optionC;

    @Column(nullable = false)
    private String optionD;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('A','B','C','D')")
    private Option correctOption;

    @ManyToMany(mappedBy = "items")
    private List<Paper> papers;
}
