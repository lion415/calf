package com.wanda.fuyao.calf.base.common.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.wanda.fuyao.calf.base.common.entity.ResponseResult;
import com.wanda.fuyao.calf.base.security.service.LoginServiceImpl;
import com.wanda.fuyao.calf.wx.cp.config.WxCpConfiguration;
import com.wanda.fuyao.calf.wx.miniapp.config.WxMaConfiguration;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @PackName: com.wanda.fuyao.calf.base.common.controller
 * @ClassName: WxLoginController
 * @Description: ${TODO}
 * @User: Lion
 * @Date: 2022/03/23  08:39
 */
@RestController
@RequestMapping("/wx/user/{appid}")
public class WxLoginController {

    @Autowired
    LoginServiceImpl loginService;

    @GetMapping("wxLogin")
    public ResponseResult wxLogin(@PathVariable String appid, String code, String signature, String rawData, String encryptedData, String iv ){
        if (StringUtils.isBlank(code)) {
            return ResponseResult.Result(4000,"jsCode不能为空");
        }

        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);

            // 用户信息校验
            if (!wxService.getUserService().checkUserInfo(session.getSessionKey(), rawData, signature)) {
                return ResponseResult.Result(4000,"wx mini app 用户校验失败");
            }

            // 解密用户信息
            WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), encryptedData, iv);

            //根据openId获取userId
            int agentId = 1000045;
            String openId =  session.getOpenid();
            WxCpService cpService = WxCpConfiguration.getCpService(agentId);
            String userId = cpService.getUserService().openid2UserId(openId);

            String token = loginService.login(userId);

            HashMap returnMap = new HashMap();
            returnMap.put("token",token);
            return ResponseResult.okResult(returnMap);

        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return ResponseResult.Result(4000,"获取数据异常");
    }
}
