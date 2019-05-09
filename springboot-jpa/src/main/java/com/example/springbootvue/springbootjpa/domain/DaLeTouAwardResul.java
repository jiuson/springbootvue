package com.example.springbootvue.springbootjpa.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.javafx.beans.IDProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Description:da le tou award result
 * @Author: jiuson
 * @Date: 2019/5/9:16:19
 */

@Entity
@Table(name = "ts_daletou")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class DaLeTouAwardResul {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 10, unique = true)
    private Long id;

    private Integer times;//期数

    private String redNum1;

    private String redNum2;
    
    private String redNum3;
    
    private String redNum4;
    
    private String redNum5;

    private String blueNum1;

    private String blueNum2;
    
}
