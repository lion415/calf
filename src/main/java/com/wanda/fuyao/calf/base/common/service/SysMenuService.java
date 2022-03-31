package com.wanda.fuyao.calf.base.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wanda.fuyao.calf.base.common.entity.SysMenu;

import java.util.List;

/**
 * 系统菜单表(SysMenu)表服务接口
 *
 * @Author Lion
 * @Date: 2022-03-28 11:23:20
 */
public interface SysMenuService extends IService<SysMenu> {

    /*根据menuId获取其所有子菜单，包括自己本身*/
    public SysMenu getSysMenuById(String menuId);

    /*根据menuId获取其所有子菜单，不包括自己本身*/
    public List<SysMenu> getSubSysMenuById(String menuId);

}

