package com.example.springbootvue.springboot.repository.impl;

import com.example.springbootvue.springboot.domain.TbToken;
import com.example.springbootvue.springboot.mybatisMapper.TokenMapper;
import com.example.springbootvue.springboot.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @program: springboot-vue
 * @descripttion: token repository impl
 * @author: jiuson
 * @create: 2019-03-29 14:59:32
 */
@Repository
public class TokenRepositoryImpl implements TokenRepository {

    @Autowired
    private TokenMapper tbTokenMapper;

    @Override
    public int insert(TbToken tbToken) {
        return tbTokenMapper.insert(tbToken);
    }
}
