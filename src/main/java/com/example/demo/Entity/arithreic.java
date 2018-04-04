package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arithreic")
public class arithreic {
    @Id
    @GeneratedValue
    private Long ari_id;
    private String arith_answer;

    public Long getAri_id() {
        return ari_id;
    }

    public void setAri_id(Long ari_id) {
        this.ari_id = ari_id;
    }

    public String getArith_answer() {
        return arith_answer;
    }

    public void setArith_answer(String arith_answer) {
        this.arith_answer = arith_answer;
    }


}
