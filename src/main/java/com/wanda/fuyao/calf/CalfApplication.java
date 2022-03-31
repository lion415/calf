package com.wanda.fuyao.calf;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.wanda.fuyao.calf.base.common.entity.SysUser;
import com.wanda.fuyao.calf.base.common.service.SysUserService;
import com.wanda.fuyao.calf.base.common.service.impl.SysUserServiceImpl;
import com.wanda.fuyao.calf.base.security.utils.JwtUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@MapperScan("com.wanda.fuyao.calf")
public class CalfApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CalfApplication.class, args);

    }

}
