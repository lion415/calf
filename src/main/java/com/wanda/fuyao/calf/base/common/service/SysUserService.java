package com.wanda.fuyao.calf.base.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wanda.fuyao.calf.base.common.entity.SysUser;

import java.util.List;

/**
 * 系统人员表--与企业微信中的组织同步(SysUser)表服务接口
 *
 * @Author Lion
 * @Date: 2022-03-21 14:31:17
 */
public interface SysUserService extends IService<SysUser> {

    public List<SysUser> getSysUserListByDeptId(String deptId);
}

