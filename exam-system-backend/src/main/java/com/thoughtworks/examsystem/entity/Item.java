package com.thoughtworks.examsystem.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    private CorrectOption correctOption;

    public enum CorrectOption {
        /**
         * Option A is correct
         */
        A,
        /**
         * Option B is correct
         */
        B,
        /**
         * Option C is correct
         */
        C,
        /**
         * Option D is correct
         */
        D
    }

    @ManyToMany(mappedBy = "items")
    private List<Paper> papers;
}
