package cn.edu.bjfu.professionalpractice.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements Serializable , UserDetails {
    String u_id;
    String u_password;
    String u_type;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_type() {
        return u_type;
    }

    public void setU_type(String u_type) {
        this.u_type = u_type;
    }

    /**
     * SpringSecurity权限相关方法
     * getAuthorities利用用户类型（string）构造SimpleGrantedAuthority
     * 并加入GrantedAuthority权限集
     * 在专业实践平台，每个用户的权限集只有一种权限（admin、student、teacher中的一个）
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths=new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(getU_type()));
        return auths;
    }

    @Override
    public String getPassword() {
        return getU_password();
    }

    @Override
    public String getUsername() {
        return getU_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
