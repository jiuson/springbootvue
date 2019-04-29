package com.example.springbootvue.springbootjpa.mvcbase;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @program: springboot-jpa
 * @descripttion: response page result
 * @author: jiuson
 * @create: 2019-04-15 18:49:20
 */
public class ResponsePageResult<T> extends PageImpl<T> {

    public ResponsePageResult(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public ResponsePageResult(Page<T> page, Pageable pageable) {
        super(page.getContent(), pageable, page.getTotalElements());
    }

    public ResponsePageResult(List<T> content) {
        super(content);
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public int getTotalPages(){
        return super.getTotalPages();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public long getTotalElements() {
        return super.getTotalElements();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public boolean isLast() {
        return super.isLast();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public int getSize() {
        return super.getSize();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public int getNumberOfElements() {
        return super.getNumberOfElements();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public boolean isFirst() {
        return super.isFirst();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public List<T> getContent() {
        return super.getContent();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public Sort getSort() {
        return super.getSort();
    }

    @Override
    @JsonView(ResponseResult.ResultJsonView.class)
    public Pageable getPageable() {
        return super.getPageable();
    }
}
