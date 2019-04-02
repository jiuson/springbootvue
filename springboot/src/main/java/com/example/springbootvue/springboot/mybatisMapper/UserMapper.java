package com.example.springbootvue.springboot.mybatisMapper;

import com.example.springbootvue.springboot.domain.TbUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @program: springbootvue
 * @descripttion: user
 * @author: jiuson
 * @create: 2019-03-29 16:11:48
 */
public interface UserMapper {

    @Select(value = "select * from tb_user where username = #{username, jdbcType=VARCHAR}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modify_date", property="modifyDate", jdbcType=JdbcType.TIMESTAMP)
    })
    TbUser selectByUsername(String username);

    /**
     * 新增一条数据，且将新增数据的主键返回设置到插入对应的id中
     * 参考：https://blog.csdn.net/ylforever/article/details/79191182
     * @param tbUser
     * @return
     */
    @Insert({
            "insert into tb_user (username, ",
            "password, create_date, ",
            "modify_date)",
            "values (#{username,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR}, ",
            "#{createDate,jdbcType=TIMESTAMP}, ",
            "#{modifyDate,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertUser(TbUser tbUser);

    @Select(value = "select * from tb_user")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modify_date", property="modifyDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbUser> findAllUser();
}
