package com.example.springbootvue.springboot.domain;

import com.example.springbootvue.springboot.mvcbase.ResponseResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class TbUser implements Serializable {

    @JsonView({UserListJsonView.class})
    private Long id;

    @JsonView({UserListJsonView.class})
    private String username;

    private String password;

    @JsonView({UserListJsonView.class})
    private String address;

    @JsonView({UserListJsonView.class})
    private Date createDate;

    @JsonView({UserListJsonView.class})
    private Date modifyDate;

    private static final long serialVersionUID = 1L;

    public void create(String username, String password){
        this.username = username;
        this.password = password;
        this.createDate = this.modifyDate = new Date();
    }

    public interface UserListJsonView extends ResponseResult.ResultJsonView {}
}
