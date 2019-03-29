package com.example.springbootvue.springboot.mybatisMapper;

import com.example.springbootvue.springboot.domain.TbToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @program: springbootvue
 * @descripttion: token
 * @author: jiuson
 * @create: 2019-03-29 16:11:28
 */
public interface TokenMapper {

    @Insert({
            "insert into tb_token (id, user_id, ",
            "token, create_date, ",
            "expire_date)",
            "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
            "#{token,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
            "#{expireDate,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(TbToken record);
}
