package com.example.springbootvue.springbootjpa.repository;

import com.example.springbootvue.springbootjpa.domain.TbUser;
import com.example.springbootvue.springbootjpa.mvcbase.BaseRepository;

/**
 * @program: springboot-jpa
 * @descripttion: user repository
 * @author: jiuson
 * @create: 2019-04-15 18:16:09
 */
public interface UserRepository extends BaseRepository<TbUser, Long> {

    TbUser findByUsername(String username);
}
