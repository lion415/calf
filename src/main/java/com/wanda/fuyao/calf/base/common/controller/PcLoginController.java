package com.wanda.fuyao.calf.base.common.controller;

import com.wanda.fuyao.calf.base.common.entity.ResponseResult;
import com.wanda.fuyao.calf.base.common.entity.SysUser;
import com.wanda.fuyao.calf.base.security.utils.JwtUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackName: com.wanda.fuyao.calf.base.common.controller
 * @ClassName: PcLoginController
 * @Description: ${TODO}
 * @User: Lion
 * @Date: 2022/03/23  08:38
 */
@RestController
@RequestMapping("/pc/user")
public class PcLoginController {
    @PostMapping("/login")
    public ResponseResult login(@RequestBody Map userInfo){
        String userId = (String) userInfo.get("username");
        String password = (String) userInfo.get("password");
        System.out.println("Http request with userName is :" + userId + ",password is :" + password);

        if(!password.equals("abc123")){
            return ResponseResult.Result(20018,"密码错误");
        }

        String token = JwtUtil.createToken(userId);

        HashMap returnMap = new HashMap();
        returnMap.put("token",token);

        return ResponseResult.okResult(returnMap);
    }

    @RequestMapping("/info")
    public ResponseResult getUserInfo(@RequestParam("token") String token){
        SysUser sysUser = (SysUser) SecurityContextHolder.getContext().getAuthentication().getCredentials();

        return ResponseResult.okResult(sysUser);
    }

    @RequestMapping("/logout")
    public ResponseResult logout(){
        return ResponseResult.okResult();
    }
}
