package com.example.demo.Entity;//package com.nwnu.arithreic.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "user")
public class user implements Serializable {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer ID;
    private String username;
    private String userpassword;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

}



