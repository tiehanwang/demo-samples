package com.spring.security.service;

import com.spring.security.dao.UserDao;
import com.spring.security.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserRoleDetailService
 * @Description: 生成细节类
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 18:38
 * @Version: v1.0
 */
@Service("userDetailsService")
public class UserRoleDetailService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        UserRole userRole = userDao.findUserRoleByUsername(username);
        if(null == userRole) return new UserRole();
        List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_A,ROLE_start,admin");
        return new User(username,new BCryptPasswordEncoder().encode(userRole.getPassword()),list);
    }
}
