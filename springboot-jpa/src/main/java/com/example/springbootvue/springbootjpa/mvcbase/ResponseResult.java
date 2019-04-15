package com.example.springbootvue.springbootjpa.mvcbase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @program: springboot-web
 * @descripttion: controller general result
 * @author: jiuson
 * @create: 2019-03-27 14:55:13
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ResponseResult<P> {

    @JsonView(ResultJsonView.class)
    private boolean success;
    @JsonView(ResultJsonView.class)
    private int errorCode;
    @JsonView(ResultJsonView.class)
    private String errorMessage;
    @JsonView(ResultJsonView.class)
    private P payload;

    public P deserialize(){
        if (!this.success){
            throw new GeneralException(this.errorCode, this.errorMessage);
        }else {
            return this.payload;
        }
    }

    public static ResponseResult<Void> success(){
        ResponseResult<Void> instance = new ResponseResult<>();
        instance.setSuccess(true);
        return instance;
    }

    public static <P> ResponseResult<P> success(P payload){
        ResponseResult<P> instance = new ResponseResult<>();
        instance.setSuccess(true);
        instance.setPayload(payload);
        return instance;
    }

    public static ResponseResult<Void> failed(GeneralException be){
        ResponseResult<Void> instance = new ResponseResult<>();
        instance.setErrorCode(be.getErrorCode());
        instance.setErrorMessage(be.getMessage());
        return instance;
    }

    public static <P> ResponseResult<P> failed(GeneralException be, P payload){
        ResponseResult<P> instance = new ResponseResult<>();
        instance.setErrorCode(be.getErrorCode());
        instance.setErrorMessage(be.getMessage());
        instance.setPayload(payload);
        instance.setSuccess(false);
        return instance;
    }

    public static <T> ResponseResult<Page<T>> success(Page<T> page, Pageable pageable){
        ResponseResult<Page<T>> instance = new ResponseResult<>();
        instance.success(true);
        instance.setPayload(new ResponsePageResult<T>(page, pageable));
        return instance;
    }

    public interface ResultJsonView{}
}
