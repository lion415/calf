package com.wanda.fuyao.calf.base.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wanda.fuyao.calf.base.common.entity.SysRole;

import java.util.List;

/**
 * 系统角色表(SysRole)表数据库访问层
 *
 * @Author Lion
 * @Date: 2022-03-25 09:57:11
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /*根据用户UserId查询对应的所有角色编号role_code*/
    public List<String> getRoleListFromUserId(String userId);
}

