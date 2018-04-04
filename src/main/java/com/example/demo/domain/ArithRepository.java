package com.example.demo.domain;

import com.example.demo.Entity.arithreic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 运算式的接口
 */
@Repository
public interface ArithRepository extends JpaRepository<arithreic,String> {
      List<arithreic> findAll();//查找运算式

      @Query(value = "SELECT * FROM arithreic WHERE ari_id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM arithreic)))ORDER BY ari_id LIMIT 20",nativeQuery = true)

      List<arithreic> findTwenty();
}
