package com.wanda.fuyao.calf.base.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanda.fuyao.calf.base.common.mapper.SysMenuMapper;
import com.wanda.fuyao.calf.base.common.entity.SysMenu;
import com.wanda.fuyao.calf.base.common.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统菜单表(SysMenu)表服务实现类
 *
 * @Author Lion
 * @Date: 2022-03-28 11:23:20
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public SysMenu getSysMenuById(String menuId) {
        SysMenu sysMenu = this.getBaseMapper().selectById(menuId);
        List<SysMenu> childMenuList = buildMenuTree(sysMenu.getMenuId());
        sysMenu.setChildren(childMenuList);

        return sysMenu;
    }

    @Override
    public List<SysMenu> getSubSysMenuById(String menuId) {

        SysMenu sysMenu = this.getBaseMapper().selectById(menuId);

        return buildMenuTree(sysMenu.getMenuId());
    }

    /*构建菜单树*/
    public List<SysMenu> buildMenuTree(String parentMenuId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("menu_pid",parentMenuId);

        List<SysMenu> childrenMenuList = this.getBaseMapper().selectList(wrapper);
        if(childrenMenuList != null && childrenMenuList.size() > 0){
            for (SysMenu sysMenu : childrenMenuList) {
                List<SysMenu> subMenuList = buildMenuTree(sysMenu.getMenuId());
                if(subMenuList != null && subMenuList.size() > 0){
                    sysMenu.setChildren(subMenuList);
                }
            }
        }

        return childrenMenuList;
    }
}

