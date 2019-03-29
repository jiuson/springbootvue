package com.example.springbootvue.springboot.domain;

import com.example.springbootvue.springboot.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@ToString
public class TbToken implements Serializable {

    private Long id;

    private Long userId;

    private String token;

    private Date createDate;

    private Date expireDate;

    private static final long serialVersionUID = 1L;

    public void createToken(Long userId){
        this.userId = userId;
        this.token = UUID.randomUUID().toString();
        this.createDate = new Date();
        this.expireDate = DateUtil.addMonth(1);
    }
}
