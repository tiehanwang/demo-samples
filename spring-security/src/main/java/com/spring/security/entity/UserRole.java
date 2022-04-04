package com.spring.security.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;


/**
 * @ClassName: UserRole
 * @Description: User实体
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 18:57
 * @Version: v1.0
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class UserRole implements UserDetails, Serializable {


    private Long userId;

    private String username;

    private String userPassword;

    private String userRole;

    private int enabled = 1;

    private Collection<SimpleGrantedAuthority> grantedAuthorityCollection;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorityCollection;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 默认为 true
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 默认为 true
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 默认为 true
    }

    @Override
    public boolean isEnabled() {
        return this.enabled == 1;
    }
}
