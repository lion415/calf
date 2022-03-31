package com.wanda.fuyao.calf.wx.cp.controller;

import com.wanda.fuyao.calf.base.common.entity.SysDept;
import com.wanda.fuyao.calf.base.common.entity.SysUser;
import com.wanda.fuyao.calf.base.common.service.SysDeptService;
import com.wanda.fuyao.calf.base.common.service.SysUserService;
import com.wanda.fuyao.calf.base.common.service.impl.SysDeptServiceImpl;
import com.wanda.fuyao.calf.base.common.service.impl.SysUserServiceImpl;
import com.wanda.fuyao.calf.base.common.utils.CastWxCp2Sys;
import com.wanda.fuyao.calf.wx.cp.config.WxCpConfiguration;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpDepart;
import me.chanjar.weixin.cp.bean.WxCpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackName: com.wanda.fuyao.calf.wx.cp.controller
 * @ClassName: WxCpUserController
 * @Description: ${TODO}
 * @User: Lion
 * @Date: 2022/03/21  16:00
 */
@RestController
@RequestMapping("/wx/cp/contact/{agentId}")
public class WxCpContactController {
    @Autowired
    SysUserServiceImpl sysUserService;
    @Autowired
    SysDeptServiceImpl sysDeptService;

    @RequestMapping("/userListSync")
    public void getUserListFromCpWx(@PathVariable Integer agentId){
        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
        if (wxCpService == null) {
            throw new IllegalArgumentException(String.format("未找到对应agentId=[%d]的配置，请核实！", agentId));
        }

        try {
            List<WxCpUser> wxCpUsers = (List<WxCpUser>) wxCpService.getUserService().listByDepartment(52L,true,0);
            List<SysUser> sysUsers = new ArrayList<SysUser>();
            CastWxCp2Sys.CastWxCpUser2SysUser(wxCpUsers,sysUsers);

            sysUserService.saveBatch(sysUsers);


        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/userDeptSync")
    public void getDeptListFromCpWx(@PathVariable Integer agentId){
        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
        if (wxCpService == null) {
            throw new IllegalArgumentException(String.format("未找到对应agentId=[%d]的配置，请核实！", agentId));
        }

        try {
            List<WxCpDepart> wxCpDeparts = wxCpService.getDepartmentService().list(52L);
            List<SysDept> sysDepts = new ArrayList<SysDept>();
            CastWxCp2Sys.CastWxCpDept2SysDept(wxCpDeparts,sysDepts);

            sysDeptService.saveBatch(sysDepts);

        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

}
