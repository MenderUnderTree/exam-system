package com.thoughtworks.examsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Auther: Realks
 * @Date: 2018/7/29 00:29
 * @Description:
 */
@Getter
@Setter
public class PageReturn<T> {
    private Integer currentPage;

    private Long total;

    private List<T> data;


    public PageReturn(Integer currentPage, Long total, List<T> data) {
        this.currentPage = currentPage;
        this.total = total;
        this.data = data;
    }
}
