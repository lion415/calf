package com.wanda.fuyao.calf.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;


/**
 * 系统菜单表(SysMenu)表实体类
 *
 * @Author Lion
 * @Date: 2022-03-28 11:29:52
 */
@SuppressWarnings("serial")
@Data
@TableName("CALF_SYS_MENU")
public class SysMenu{
    //菜单主键
    @TableId()
    private String menuId;
    //菜单父主键
    private String menuPid;
    //菜单名称
    private String menuName;
    //菜单Url
    private String menuUrl;
    //菜单路径
    private String menuPath;
    //是否隐藏
    private String isHidden;
    //组件
    private String component;
    //重定向路径
    private String redirect;
    //菜单标题
    private String menuTitle;
    //菜单图标
    private String menuIcon;

    //子菜单
    @TableField(exist = false)
    private List<SysMenu> children;
}

