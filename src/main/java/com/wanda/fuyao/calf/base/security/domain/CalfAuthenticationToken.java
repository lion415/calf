package com.wanda.fuyao.calf.base.security.domain;

import com.wanda.fuyao.calf.base.common.entity.SysUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @PackName: com.wanda.fuyao.calf.base.security.domain
 * @ClassName: CalfAuthenticationToken
 * @Description: 封装AuthenticationToken 用于Token认证和授权
 * @User: Lion
 * @Date: 2022/03/16  11:22
 */

@Getter
@Setter
public class CalfAuthenticationToken extends AbstractAuthenticationToken {
    private SysUser sysUser;

    public CalfAuthenticationToken(SysUser user){
        super(null);
        this.sysUser = sysUser;
        super.setAuthenticated(false);
    }

    public CalfAuthenticationToken(SysUser sysUser, Collection<? extends GrantedAuthority> authorities){
        super(authorities);
        this.sysUser = sysUser;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.sysUser;
    }

    @Override
    public Object getPrincipal() {
        return this.sysUser.getUserId();
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException{
        if(isAuthenticated){
//            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
            throw new IllegalArgumentException("不可通过此方法设置token为认证状态，请使用带有权限列表的构造器设置为认证状态！");

        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials(){
        super.eraseCredentials();
    }
}
