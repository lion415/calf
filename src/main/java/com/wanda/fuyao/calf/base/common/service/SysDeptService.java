package com.wanda.fuyao.calf.base.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wanda.fuyao.calf.base.common.entity.SysDept;

import java.util.List;

/**
 * 系统部门表--与企业微信同步(SysDept)表服务接口
 *
 * @Author Lion
 * @Date: 2022-03-22 11:09:46
 */
public interface SysDeptService extends IService<SysDept> {

    /*根据部门编号，获取该部门及所有子部门*/
    public SysDept getDeptTree(String deptId);
}

