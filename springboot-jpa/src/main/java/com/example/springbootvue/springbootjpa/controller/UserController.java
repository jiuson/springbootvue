package com.example.springbootvue.springbootjpa.controller;

import com.example.springbootvue.springbootjpa.domain.TbUser;
import com.example.springbootvue.springbootjpa.mvcbase.BaseController;
import com.example.springbootvue.springbootjpa.mvcbase.ControllerResponseCode;
import com.example.springbootvue.springbootjpa.mvcbase.GeneralException;
import com.example.springbootvue.springbootjpa.mvcbase.ResponseResult;
import com.example.springbootvue.springbootjpa.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Predicate;
import java.util.Optional;

/**
 * @program: springbootvue
 * @descripttion: user
 * @author: jiuson
 * @create: 2019-04-01 10:18:15
 */

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @param date
     * @return
     */
    @JsonView(TbUser.UserListJsonView.class)
    @GetMapping("/list")
    public ResponseResult<Page<TbUser>> getUserList(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                                    @RequestParam(required = false) String date){

        Page<TbUser> tbUserPage = userRepository.findAll(pageable);

        return ResponseResult.success(tbUserPage, pageable);
    }

    /**
     * 根据username查询
     * @param username
     * @return
     */
    @JsonView(TbUser.UserListJsonView.class)
    @GetMapping("/username")
    public ResponseResult<TbUser> getUserByUsername(@RequestParam(name = "username") String username){

        TbUser tbUser = userRepository.findByUsername(username);

        return ResponseResult.success(tbUser);
    }

    /**
     * 根据userId删除数据
     * @param userId
     * @return
     */
    @PostMapping("/{userId}")
    public ResponseResult<Object> deleteUserById(@PathVariable final Long userId){

        Optional<TbUser> userOptional = userRepository.findOne(((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.equal(root.get("id"), userId);
            return predicate;
        }));

        if (userOptional.isPresent()){
            userRepository.delete(userOptional.get());
        }else {
            throw new GeneralException(ControllerResponseCode.DATA_NOT_EXIST_CODE, ControllerResponseCode.DATA_NOT_EXIST_MESSAGE);
        }

        return ResponseResult.success(null);
    }

}
