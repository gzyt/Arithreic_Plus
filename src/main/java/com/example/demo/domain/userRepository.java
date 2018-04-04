package com.example.demo.domain;

import com.example.demo.Entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户登录的接口
 */
@Repository
public interface userRepository extends JpaRepository<user,String> {
    @Query(value = "select * from user where userpassword=?1",nativeQuery = true)
    List<user> findBypassword(String password);
}