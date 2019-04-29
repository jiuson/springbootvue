package com.example.springbootvue.springbootjpa.repository;

import com.example.springbootvue.springbootjpa.domain.TbToken;
import com.example.springbootvue.springbootjpa.mvcbase.BaseRepository;

import java.util.Optional;

/**
 * @program: springboot-jpa
 * @descripttion: token repository
 * @author: jiuson
 * @create: 2019-04-15 18:28:22
 */
public interface TokenRepository extends BaseRepository<TbToken, Long> {

    Optional<TbToken> findByToken(String token);
}
