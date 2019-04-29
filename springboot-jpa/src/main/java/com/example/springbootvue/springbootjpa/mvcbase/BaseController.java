package com.example.springbootvue.springbootjpa.mvcbase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot-web
 * @descripttion: base controller
 * @author: jiuson
 * @create: 2019-03-27 14:50:42
 */
@Slf4j
public abstract class BaseController {

    @Autowired
    public EntityManager entityManager;

    /**
     * GeneralException异常处理
     * @param request
     * @param be
     * @return
     */
    @ExceptionHandler({GeneralException.class})
    public ResponseResult<Void> businessExceptionHandler(HttpServletRequest request, GeneralException be){
        log.info(String.valueOf(be.getErrorCode()), be);
        ResponseResult<Void> response = ResponseResult.failed(be);
        return response;
    }

    /**
     * 返回通过反向代理的远程ip地址
     * @param request
     * @return
     */
    public String getRemoteIp(HttpServletRequest request){
        return request.getHeader("x-forwarded-for") == null ? request.getRemoteAddr() : request.getHeader("x-forwarded-for");
    }

    /**
     * 执行原生sql查询
     * @param sql
     * @return
     */
    public List<Map<String, Object>> excuteNativeQuery(String sql){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        List<Map<String, Object>> resultList =nativeQuery.getResultList();
        return resultList;
    }

    /**
     * 执行原生sql查询，指定返回结果类型
     * @param sql
     * @param cla
     * @return
     */
    public List excuteNativeQuery(String sql, Class cla){
        Query nativeQuery = entityManager.createNativeQuery(sql, cla);
        List resultList = nativeQuery.getResultList();
        return resultList;
    }
}
