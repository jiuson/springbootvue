package com.example.springbootvue.springbootjpa.intercepter;

import com.example.springbootvue.springbootjpa.domain.TbConsume;
import com.example.springbootvue.springbootjpa.domain.TbToken;
import com.example.springbootvue.springbootjpa.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

/**
 * @program: springboot-jpa
 * @descripttion: token intercepter
 * @author: jiuson
 * @create: 2019-04-19 16:05:19
 */
public class TokenIntercepter extends HandlerInterceptorAdapter {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Boolean result = Boolean.TRUE;

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "token is necessary");
            result = Boolean.FALSE;
        }else {
            Optional<TbToken> tokenOptional = tokenRepository.findByToken(token);
            if (!tokenOptional.isPresent()){
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "token is not exit");
                result = Boolean.FALSE;
            }else {
                if (tokenOptional.get().getExpireDate().before(new Date())){
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "token is expired");
                    result = Boolean.FALSE;
                }
            }
        }
//        request
        return result;
    }
}
