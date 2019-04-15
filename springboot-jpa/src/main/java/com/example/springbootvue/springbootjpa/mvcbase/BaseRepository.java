package com.example.springbootvue.springbootjpa.mvcbase;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @program: springboot-jpa
 * @descripttion: base repository
 * @author: jiuson
 * @create: 2019-04-15 18:16:49
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {
}
