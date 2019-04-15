package com.example.springbootvue.springbootjpa.controller;

import com.example.springbootvue.springbootjpa.domain.TbUser;
import com.example.springbootvue.springbootjpa.mvcbase.BaseController;
import com.example.springbootvue.springbootjpa.mvcbase.ResponseResult;
import com.example.springbootvue.springbootjpa.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseResult<Page<TbUser>> getUserList(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        Page<TbUser> tbUserPage = userRepository.findAll(pageable);

        return ResponseResult.success(tbUserPage, pageable);
    }

    @JsonView(TbUser.UserListJsonView.class)
    @GetMapping("/username")
    public ResponseResult<TbUser> getUserByUsername(@RequestParam(name = "username") String username){

        TbUser tbUser = userRepository.findByUsername(username);

        return ResponseResult.success(tbUser);
    }
}
