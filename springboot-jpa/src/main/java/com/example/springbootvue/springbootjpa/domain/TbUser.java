package com.example.springbootvue.springbootjpa.domain;

import com.example.springbootvue.springbootjpa.mvcbase.ResponseResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class TbUser {

    @JsonView({UserListJsonView.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 10)
    private Long id;

    @JsonView({UserListJsonView.class})
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @JsonView({UserListJsonView.class})
    @Column(nullable = false)
    private String address;

    @JsonView({UserListJsonView.class})
    @Column(nullable = false)
    private Date createDate;

    @JsonView({UserListJsonView.class})
    @Column(nullable = false)
    private Date modifyDate;

    private static final long serialVersionUID = 1L;

    public void create(String username, String password){
        this.username = username;
        this.password = password;
        this.createDate = this.modifyDate = new Date();
    }

    public interface UserListJsonView extends ResponseResult.ResultJsonView {}
}
