package com.example.springbootvue.springboot.repository;


import com.example.springbootvue.springboot.domain.TbUser;

import java.util.List;

/**
 * @program: springboot-vue
 * @descripttion: user repository
 * @author: jiuson
 * @create: 2019-03-29 12:14:31
 */
public interface UserRepository {

    TbUser findByUsername(String username);

    int insertUser(TbUser tbUser);

    List<TbUser> findAllUser();
}
