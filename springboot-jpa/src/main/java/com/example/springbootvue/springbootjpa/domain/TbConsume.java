package com.example.springbootvue.springbootjpa.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: springboot-jpa
 * @descripttion: 消费明细
 * @author: jiuson
 * @create: 2019-04-16 19:05:45
 */

@Entity
@Table(name = "tb_consume")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
public class TbConsume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 20, unique = true)
    private Long id;

    @Column(nullable = false)
    //消费名称
    private String consumeName;

    @Column(nullable = false)
    //消费金额
    private Float expenditure;

    @Column(nullable = false)
    //消费类型
    private String consumeType;

    @Column(nullable = false)
    //消费时间
    private Date consumeDate;

    @Column(nullable = false)
    //添加时间
    private Date modifyDate;
}
