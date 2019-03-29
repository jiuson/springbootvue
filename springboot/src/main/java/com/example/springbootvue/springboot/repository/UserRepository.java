package com.example.springbootvue.springboot.repository;


import com.example.springbootvue.springboot.domain.TbUser;

import java.util.Optional;

/**
 * @program: springboot-vue
 * @descripttion: user repository
 * @author: jiuson
 * @create: 2019-03-29 12:14:31
 */
public interface UserRepository {

    TbUser findByUsername(String username);

    int insertUser(TbUser tbUser);
}
