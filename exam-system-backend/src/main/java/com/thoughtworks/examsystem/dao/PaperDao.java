package com.thoughtworks.examsystem.dao;

import com.thoughtworks.examsystem.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : luoweiyao
 * @created : 2018/7/29
 * @project : exam-system
 * @package : com.thoughtworks.examsystem.dao
 */
public interface PaperDao extends JpaRepository<Paper, Long> {
}
