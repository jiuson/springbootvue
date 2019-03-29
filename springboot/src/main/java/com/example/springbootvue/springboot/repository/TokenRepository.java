package com.example.springbootvue.springboot.repository;


import com.example.springbootvue.springboot.domain.TbToken;

/**
 * @program: springboot-vue
 * @descripttion: token repository
 * @author: jiuson
 * @create: 2019-03-29 14:58:49
 */
public interface TokenRepository {

    int insert(TbToken tbToken);
}
