package com.wanda.fuyao.calf.base.security.service;
import com.wanda.fuyao.calf.base.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @PackName: com.wanda.fuyao.calf.base.security.service
 * @ClassName: LoginServiceImpl
 * @Description: ${TODO}
 * @User: Lion
 * @Date: 2022/03/07  14:10
 */
@Service
public class LoginServiceImpl {

    public String login(String userId){

        //判断登录的信息是否合法，合法则回复Token

        return JwtUtil.createToken(userId);
    }
}
