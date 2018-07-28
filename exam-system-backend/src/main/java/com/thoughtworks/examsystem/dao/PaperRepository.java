package com.thoughtworks.examsystem.dao;

import com.thoughtworks.examsystem.entity.Paper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: Realks
 * @Date: 2018/7/29 00:49
 * @Description:
 */
@Repository
public interface PaperRepository extends JpaRepository<Paper,Integer> {
    Page<Paper> findAll(Pageable pageable);
}
