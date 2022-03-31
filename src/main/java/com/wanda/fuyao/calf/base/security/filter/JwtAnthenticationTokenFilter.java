package com.wanda.fuyao.calf.base.security.filter;

import com.wanda.fuyao.calf.base.common.entity.SysUser;
import com.wanda.fuyao.calf.base.common.service.impl.SysRoleServiceImpl;
import com.wanda.fuyao.calf.base.common.service.impl.SysUserServiceImpl;
import com.wanda.fuyao.calf.base.security.domain.CalfAuthenticationToken;
import com.wanda.fuyao.calf.base.security.utils.JwtUtil;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @PackName: com.wanda.fuyao.calf.base.security.filter
 * @ClassName: WxMiniAppJwtAnthenticationTokenFilter
 * @Description: Token认证过滤器，判断请求头是否含有有效Token,以此为依据判断是否已经登录
 * @User: Lion
 * @Date: 2022/03/16  17:04
 */
@Component
public class JwtAnthenticationTokenFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysRoleServiceImpl sysRoleService;
    @Autowired
    SysUserServiceImpl sysUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //从请求头中获取Token
        String token = request.getHeader("token");
//        this.logger.info("请求中的token为：" + token);
        if(token == null || "".equals(token)){
            filterChain.doFilter(request,response);
            return;
        }
        String userId = null;
        //解析Token,并从Token中获取到userId
        if(JwtUtil.verifyToken(token) != null){
            userId = JwtUtil.getClaim(token, "userId");
        }

        if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null){
            //获取到系统用户信息及权限信息，并存入SecurityContextHolder
            SysUser sysUser = sysUserService.getById(userId);
            List<String> roles = sysRoleService.getRoleListFromUserId(userId);
            sysUser.setRoles(roles);

            List<SimpleGrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            SecurityContextHolder.getContext().setAuthentication(new CalfAuthenticationToken(sysUser,authorities));
        }

        filterChain.doFilter(request,response);
    }
}
