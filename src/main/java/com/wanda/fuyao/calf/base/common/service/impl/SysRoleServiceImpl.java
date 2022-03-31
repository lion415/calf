package com.wanda.fuyao.calf.base.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanda.fuyao.calf.base.common.mapper.SysRoleMapper;
import com.wanda.fuyao.calf.base.common.entity.SysRole;
import com.wanda.fuyao.calf.base.common.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统角色表(SysRole)表服务实现类
 *
 * @Author Lion
 * @Date: 2022-03-25 09:57:12
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<String> getRoleListFromUserId(String userId) {
        return getBaseMapper().getRoleListFromUserId(userId);
    }
}

