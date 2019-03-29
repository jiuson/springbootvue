package com.example.springbootvue.springboot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class TbUser implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Date createDate;

    private Date modifyDate;

    private static final long serialVersionUID = 1L;

    public void create(String username, String password){
        this.username = username;
        this.password = password;
        this.createDate = this.modifyDate = new Date();
    }
}
