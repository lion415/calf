package com.wanda.fuyao.calf.base.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wanda.fuyao.calf.base.common.entity.SysRole;

import java.util.List;

/**
 * 系统角色表(SysRole)表服务接口
 *
 * @Author Lion
 * @Date: 2022-03-25 09:57:12
 */
public interface SysRoleService extends IService<SysRole> {

    /*根据用户UserId查询对应的所有角色编号role_code*/
    public List<String> getRoleListFromUserId(String userId);
}

