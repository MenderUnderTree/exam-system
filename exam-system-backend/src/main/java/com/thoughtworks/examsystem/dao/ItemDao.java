package com.thoughtworks.examsystem.dao;

import com.thoughtworks.examsystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.dao
 */
@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
}
