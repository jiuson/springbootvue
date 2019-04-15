package com.example.springbootvue.springbootjpa.domain;

import com.example.springbootvue.springbootjpa.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_token")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
public class TbToken implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 20)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date expireDate;

    private static final long serialVersionUID = 1L;

    public void createToken(Long userId){
        this.userId = userId;
        this.token = UUID.randomUUID().toString();
        this.createDate = new Date();
        this.expireDate = DateUtil.addMonth(1);
    }
}
