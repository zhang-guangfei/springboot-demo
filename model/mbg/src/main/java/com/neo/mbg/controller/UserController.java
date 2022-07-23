package com.neo.mbg.controller;

import com.neo.common.dto.Result;
import com.neo.mbg.entity.User;
import com.neo.mbg.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangguangfei
 * @since 2022-07-24
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;


    @GetMapping("/user")
    public Result findUsers(){
        List<User> users = userMapper.selectList(null);
        return Result.success("查询成功",users);
    }

}
