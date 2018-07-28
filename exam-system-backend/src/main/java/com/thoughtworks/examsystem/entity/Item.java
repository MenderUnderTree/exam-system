package com.thoughtworks.examsystem.entity;

import javax.persistence.*;
import java.awt.print.Paper;
import java.util.Set;

/**
 * @author : luoweiyao
 * @created : 2018/7/28
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.entity
 */
@Entity
@Table(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue
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

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "enum('A','B','C','D')")
    private CorrectOption correctOption;


    @ManyToMany
    @JoinTable(
            name = "PaperItem",
            joinColumns = {@JoinColumn(name = "item_id",nullable = false,referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "paper_id", nullable = false,referencedColumnName = "id")}
    )
    private Set<Paper> papers;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public CorrectOption getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(CorrectOption correctOption) {
        this.correctOption = correctOption;
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public void setPapers(Set<Paper> papers) {
        this.papers = papers;
    }
}
