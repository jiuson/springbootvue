package com.example.springbootvue.springbootjpa.controller;

import com.example.springbootvue.springbootjpa.domain.TbConsume;
import com.example.springbootvue.springbootjpa.mvcbase.BaseController;
import com.example.springbootvue.springbootjpa.mvcbase.ResponseResult;
import com.example.springbootvue.springbootjpa.repository.ConsumeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;

/**
 * @program: springboot-jpa
 * @descripttion: consume controller
 * @author: jiuson
 * @create: 2019-04-16 19:24:31
 */

@RestController
@RequestMapping("/consume")
@Slf4j
public class ConsumeController extends BaseController {

    @Autowired
    private ConsumeRepository consumeRepository;

    /**
     * 获取消费明细
     * @param pageable
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping
    public ResponseResult<Page<TbConsume>> getConsumeListPage(@PageableDefault(sort = {"consumeDate", "id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                                              @RequestParam(required = false) final String startDate,
                                                              @RequestParam(required = false) final String endDate){

        Page<TbConsume> tbConsumePage = consumeRepository.findAll(((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.isNotNull(root.get("id"));
            return predicate;
        }), pageable);


        return ResponseResult.success(tbConsumePage);
    }
}
