package com.example.demo.domain;

import com.example.demo.Entity.score;
import com.example.demo.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 成绩展示的接口
 */
@Repository
public interface scoreRepository extends JpaRepository<score,String> {
    @Query(value = "select score from score where userpassword=?1",nativeQuery = true)
    List<String> findBypassword(String password);
}
