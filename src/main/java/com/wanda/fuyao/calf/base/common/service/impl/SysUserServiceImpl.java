package com.wanda.fuyao.calf.base.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanda.fuyao.calf.base.common.mapper.SysUserMapper;
import com.wanda.fuyao.calf.base.common.entity.SysUser;
import com.wanda.fuyao.calf.base.common.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统人员表--与企业微信中的组织同步(SysUser)表服务实现类
 *
 * @Author Lion
 * @Date: 2022-03-21 14:31:17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    public List<SysUser> getSysUserListByDeptId(String deptId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("main_deptment",deptId);
        return this.getBaseMapper().selectList(wrapper);
    }

}

