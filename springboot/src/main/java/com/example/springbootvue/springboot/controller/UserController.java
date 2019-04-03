package com.example.springbootvue.springboot.controller;

import com.example.springbootvue.springboot.domain.TbUser;
import com.example.springbootvue.springboot.mvcbase.BaseController;
import com.example.springbootvue.springboot.mvcbase.ResponseResult;
import com.example.springbootvue.springboot.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springbootvue
 * @descripttion: user
 * @author: jiuson
 * @create: 2019-04-01 10:18:15
 */

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @return
     */
    @JsonView(TbUser.UserListJsonView.class)
    @GetMapping("/list")
    public ResponseResult<List<TbUser>> getUserList(){

        List<TbUser> tbUserList = userRepository.findAllUser();

        return ResponseResult.success(tbUserList);
    }

    @JsonView(TbUser.UserListJsonView.class)
    @GetMapping("/username")
    public ResponseResult<TbUser> getUserByUsername(@RequestParam(name = "username") String username){

        TbUser tbUser = userRepository.findByUsername(username);

        return ResponseResult.success(tbUser);
    }
}
