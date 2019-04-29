package com.example.springbootvue.springbootjpa.domain;

import com.example.springbootvue.springbootjpa.mvcbase.ControllerResponseCode;
import com.example.springbootvue.springbootjpa.mvcbase.GeneralException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

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

    @ManyToOne(targetEntity = TbUser.class)
    @JoinColumn(name = "tb_user_id")
    //添加人
    private TbUser tbUser;

    /**
     * 检验参数
     * @param consumeName
     * @param expenditure
     * @param consumeType
     * @param consumeDate
     */
    private void verify(String consumeName, Float expenditure, String consumeType, Long consumeDate){
        if (StringUtils.isEmpty(consumeName) || StringUtils.isEmpty(consumeType) || null == expenditure || null == consumeDate){
            throw new GeneralException(ControllerResponseCode.PARAM_VERIFY_ERROR_CODE, ControllerResponseCode.PARAM_VERIFY_ERROR_MESSAGE);
        }
        this.consumeName = consumeName;
        this.expenditure = expenditure;
        this.consumeType = consumeType;
        this.consumeDate = new Date(consumeDate);
        this.modifyDate = new Date();
    }

    /**
     * 新增
     * @param consumeName
     * @param expenditure
     * @param consumeType
     * @param consumeDate
     */
    public void create(String consumeName, Float expenditure, String consumeType, Long consumeDate){
        this.verify(consumeName, expenditure, consumeType, consumeDate);
    }

    /**
     * 修改
     * @param consumeName
     * @param expenditure
     * @param consumeType
     * @param consumeDate
     */
    public void modify(String consumeName, Float expenditure, String consumeType, Long consumeDate){
        this.verify(consumeName, expenditure, consumeType, consumeDate);
    }
}
