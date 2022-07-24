package com.neo.model.mapper;

import com.neo.model.dto.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangguangfei
 * @since 2022-07-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
