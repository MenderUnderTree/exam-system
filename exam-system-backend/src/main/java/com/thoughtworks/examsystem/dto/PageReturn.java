package com.thoughtworks.examsystem.dto;

import java.util.List;

/**
 * @Auther: Realks
 * @Date: 2018/7/29 00:29
 * @Description:
 */
public class PageReturn<T> {
    private Integer currentPage;

    private Integer pageSize;

    private List<T> data;
}
