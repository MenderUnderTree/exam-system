package com.thoughtworks.examsystem.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author : luoweiyao
 * @created : 2018/7/28
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.bean
 */
@Getter
@Setter
public class GetPaperResponse {
    private String paperName;
    private List<ItemBean> itemBeanList;
}
