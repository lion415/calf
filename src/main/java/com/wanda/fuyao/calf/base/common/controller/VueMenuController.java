package com.wanda.fuyao.calf.base.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wanda.fuyao.calf.base.common.entity.ResponseResult;
import com.wanda.fuyao.calf.base.common.entity.SysMenu;
import com.wanda.fuyao.calf.base.common.service.impl.SysMenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @PackName: com.wanda.fuyao.calf.base.common.controller
 * @ClassName: VueMenuController
 * @Description: 前端Vue 菜单相关接口
 * @User: Lion
 * @Date: 2022/03/28  13:38
 */
@RestController
@RequestMapping("/pc/system")
public class VueMenuController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysMenuServiceImpl sysMenuService;

    @RequestMapping("/getMenus")
    public ResponseResult getDynamicMenu(){
        SysMenu sysMenu = sysMenuService.getSysMenuById("0");
        return ResponseResult.okResult(Arrays.asList(sysMenu));
    }

    @PostMapping("/addMenu")
    public ResponseResult addMenu(@RequestBody SysMenu sysMenu){
        this.logger.info("Add menu data is :" + sysMenu);
        sysMenuService.save(sysMenu);

        return ResponseResult.okResult();
    }

    @PostMapping("/updateMenu")
    public ResponseResult updateMenu(@RequestBody SysMenu sysMenu){
        this.logger.info("update menu data is :" + sysMenu);
        sysMenuService.saveOrUpdate(sysMenu);

        return ResponseResult.okResult();
    }

    @RequestMapping("/getLeftMenu")
    public ResponseResult getLeftMenu(){
        //根据当前用户的角色查询Vue左侧菜单导航数据
        List<SysMenu> subSysMenuList = sysMenuService.getSubSysMenuById("0");

        this.logger.info("GET LEFT MENU-----" + subSysMenuList);
        return ResponseResult.okResult(subSysMenuList);
    }
}
