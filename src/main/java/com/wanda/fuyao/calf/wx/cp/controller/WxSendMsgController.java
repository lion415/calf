package com.wanda.fuyao.calf.wx.cp.controller;


import com.wanda.fuyao.calf.wx.cp.config.WxCpConfiguration;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpMessageService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.impl.WxCpMessageServiceImpl;
import me.chanjar.weixin.cp.bean.message.WxCpMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackName: com.wanda.fuyao.calf.wx.cp.controller
 * @ClassName: WxSendMsgController
 * @Description: ${TODO}
 * @User: Lion
 * @Date: 2022/02/17  17:56
 */
@RestController
@RequestMapping("/wx/cp/msg/{agentId}")
public class WxSendMsgController {

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String msgPust(@PathVariable Integer agentId) throws WxErrorException {

        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
        WxCpMessageService wxCpMessageService = new WxCpMessageServiceImpl(wxCpService);

        WxCpMessage wxCpMessage = WxCpMessage
            .TEXT()
            .agentId(agentId)
            .toUser("096721")
            .content("lion-push-msg")
            .build();

        wxCpMessageService.send(wxCpMessage);

        return "success";
    }

}
