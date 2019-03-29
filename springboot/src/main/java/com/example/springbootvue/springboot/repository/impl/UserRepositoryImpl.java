package com.example.springbootvue.springboot.repository.impl;

import com.example.springbootvue.springboot.domain.TbUser;
import com.example.springbootvue.springboot.mybatisMapper.UserMapper;
import com.example.springbootvue.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @program: springboot-vue
 * @descripttion: user repository impl
 * @author: jiuson
 * @create: 2019-03-29 12:15:30
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper tbUserMapper;

    @Override
    public TbUser findByUsername(String username) {

        TbUser tbUserOptional = tbUserMapper.selectByUsername(username);

        return tbUserOptional;
    }

    @Override
    public int insertUser(TbUser tbUser) {
        return tbUserMapper.insertUser(tbUser);
    }
}
