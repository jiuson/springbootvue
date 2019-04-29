package com.example.springbootvue.springbootjpa.controller;

import com.example.springbootvue.springbootjpa.domain.TbToken;
import com.example.springbootvue.springbootjpa.domain.TbUser;
import com.example.springbootvue.springbootjpa.mvcbase.BaseController;
import com.example.springbootvue.springbootjpa.mvcbase.ControllerResponseCode;
import com.example.springbootvue.springbootjpa.mvcbase.GeneralException;
import com.example.springbootvue.springbootjpa.mvcbase.ResponseResult;
import com.example.springbootvue.springbootjpa.repository.TokenRepository;
import com.example.springbootvue.springbootjpa.repository.UserRepository;
import com.example.springbootvue.springbootjpa.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @program: springboot-vue
 * @descripttion: login check
 * @author: jiuson
 * @create: 2019-03-29 11:53:29
 */
@RestController
@RequestMapping
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;

    /**
     * 注册用户
     * @param input
     * @return
     */
    @PostMapping("/register")
    public ResponseResult<Object> registerVerify(@RequestBody Map<String, String> input){

        TbToken tbToken = new TbToken();

        String username = input.get("username");
        String password = input.get("password");
        String address = input.get("address");

        Optional<TbUser> tbUserOptional = Optional.ofNullable(userRepository.findByUsername(username));
        if (tbUserOptional.isPresent()){
            throw new GeneralException(ControllerResponseCode.REGISTER_VERIFY_USERNAME_REPEAT_CODE, ControllerResponseCode.REGISTER_VERIFY_USERNAME_REPEAT_MESSAGE);
        }else {
            TbUser tbUser = new TbUser();
            tbUser.create(username, Md5Util.MD5(password), address);
            userRepository.save(tbUser);
            tbToken.createToken(tbUser);
            tokenRepository.save(tbToken);
        }
        return ResponseResult.success(tbToken);
    }

    /**
     * 登录验证
     * @param input
     * @return
     */
    @PostMapping("login")
    public ResponseResult<TbToken> loginVerify(@RequestBody Map<String, String> input){

        String username = input.get("username");
        String password = input.get("password");
        TbToken tbToken = new TbToken();

        if (StringUtils.isEmpty(username)){
            throw new GeneralException(ControllerResponseCode.LOGIN_VERIFY_USERNAME_ERROR_CODE, ControllerResponseCode.LOGIN_VERIFY_USERNAME_ERROR_MSG);
        }
        if (StringUtils.isEmpty(password)){
            throw new GeneralException(ControllerResponseCode.LOGIN_VERIFY_PASSWORD_ERROR_CODE, ControllerResponseCode.LOGIN_VERIFY_PASSWORD_ERROR_MSG);
        }

        Optional<TbUser> tbUserOptional = Optional.ofNullable(userRepository.findByUsername(username));
        if (tbUserOptional.isPresent()){//用户已存在，验证密码
            if (Md5Util.MD5(password).equalsIgnoreCase(tbUserOptional.get().getPassword())){
                tbToken.createToken(tbUserOptional.get());
                tokenRepository.save(tbToken);
            }else {
                throw new GeneralException(ControllerResponseCode.LOGIN_VERIFY_PASSWORD_ERROR_CODE, ControllerResponseCode.LOGIN_VERIFY_PASSWORD_ERROR_MSG);
            }
        }else {//用户不存在
            throw new GeneralException(ControllerResponseCode.LOGIN_VERIFY_USERNAME_NO_ERROR_CODE, ControllerResponseCode.LOGIN_VERIFY_USERNAME_NO_ERROR_MESSAGE);
        }

        return ResponseResult.success(tbToken);
    }

}
