package com.neo.mbg.service.impl;

import com.neo.mbg.entity.User;
import com.neo.mbg.mapper.UserMapper;
import com.neo.mbg.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangguangfei
 * @since 2022-07-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
