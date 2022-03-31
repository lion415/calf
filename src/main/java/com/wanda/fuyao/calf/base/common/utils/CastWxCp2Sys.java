package com.wanda.fuyao.calf.base.common.utils;

import com.wanda.fuyao.calf.base.common.entity.SysDept;
import com.wanda.fuyao.calf.base.common.entity.SysUser;
import me.chanjar.weixin.cp.bean.WxCpDepart;
import me.chanjar.weixin.cp.bean.WxCpUser;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @PackName: com.wanda.fuyao.calf.base.common.utils
 * @ClassName: CastWxCpUser2SysUser
 * @Description: 将WxCpUser数据转换为SysUser
 * @User: Lion
 * @Date: 2022/03/22  08:51
 */
public class CastWxCp2Sys {
    /**
     * @Method 将wx-java中的cpUser 转换为系统用户SysUser
     * @Description
     * @Params
     * @Return
     * @Throws
     * @Author Lion
     * @Date 2022/03/22 11:16
     */
    public static void CastWxCpUser2SysUser(WxCpUser cpUser, SysUser sysUser){
        sysUser.setUserId(cpUser.getUserId());
        sysUser.setName(cpUser.getName());
        sysUser.setDepartment(Arrays.toString(cpUser.getDepartIds()));
        sysUser.setOrderBy(Arrays.toString(cpUser.getOrders()));
        sysUser.setPosition(cpUser.getPosition());
        sysUser.setMobile(cpUser.getMobile());
        sysUser.setGender(cpUser.getGender().getCode());
        sysUser.setEmail(cpUser.getEmail());
        sysUser.setIsLeaderInDept(Arrays.toString(cpUser.getIsLeaderInDept()));
        sysUser.setAvatar(cpUser.getAvatar());
        sysUser.setThumbAvatar(cpUser.getThumbAvatar());
        sysUser.setTelephone(cpUser.getTelephone());
        sysUser.setAlias(cpUser.getAlias());
        sysUser.setStatus(cpUser.getStatus().toString());
        sysUser.setAddress(cpUser.getAddress());
        sysUser.setHideMobile(cpUser.getHideMobile().toString());
        sysUser.setEnglishName(cpUser.getEnglishName());
        sysUser.setOpenUserId(cpUser.getOpenUserId());
        sysUser.setMainDeptment(cpUser.getMainDepartment());
    }

    public static void CastWxCpUser2SysUser(List<WxCpUser> cpUserList, List<SysUser> sysUserList){
        for (WxCpUser cpUser : cpUserList) {
            SysUser sysUser = new SysUser();
            CastWxCpUser2SysUser(cpUser,sysUser);
            sysUserList.add(sysUser);
        }
    }
    /**
     * @Method 将wx-java中的cpDepart 转换为系统用户SysDept
     * @Description
     * @Params
     * @Return
     * @Throws
     * @Author Lion
     * @Date 2022/03/22 11:17
     */
    public static void CastWxCpDept2SysDept(WxCpDepart cpDepart, SysDept sysDept){
        sysDept.setDeptId(cpDepart.getId().toString());
        sysDept.setDeptName(cpDepart.getName());
        sysDept.setDeptNameEn(cpDepart.getEnName());
        sysDept.setParentId(cpDepart.getParentId().toString());
        sysDept.setOrderBy(cpDepart.getOrder().toString());
    }

    public static void CastWxCpDept2SysDept(List<WxCpDepart> cpDepartList, List<SysDept> sysDeptList){
        for (WxCpDepart wxCpDepart : cpDepartList) {
            SysDept sysDept = new SysDept();
            CastWxCpDept2SysDept(wxCpDepart,sysDept);
            sysDeptList.add(sysDept);
        }
    }
}
