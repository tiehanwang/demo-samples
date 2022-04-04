package com.spring.security.dao;

import com.spring.security.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Description: 用户接口
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 18:43
 * @Version: v1.0
 */
@Mapper
public interface UserDao {

    @Select("select user_id as userId,user_name as userName,user_password as userPassword,user_role as userRole,"
    +"is_enabled as enabled from user_role where user_name = #{userName}"
    )
    UserRole findUserRoleByUsername(String userName);

}
