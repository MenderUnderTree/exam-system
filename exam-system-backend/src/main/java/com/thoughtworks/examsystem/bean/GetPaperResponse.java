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
public class GetPaperResponse {
    private String paperName;
    private List<ItemBean> itemBeanList;

    public List<ItemBean> getItemBeanList() {
        return itemBeanList;
    }

    public void setItemBeanList(List<ItemBean> itemBeanList) {
        this.itemBeanList = itemBeanList;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
