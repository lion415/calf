package com.wanda.fuyao.calf.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 系统部门表--与企业微信同步(SysDept)表实体类
 *
 * @Author Lion
 * @Date: 2022-03-22 11:09:46
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("CALF_SYS_DEPT")
public class SysDept{
    //部门Id
    @TableId
    private String deptId;
    //部门名称
    private String deptName;
    //父部门id
    private String parentId;
    //在父部门中排序
    private String orderBy;
    //部门英文名称
    private String deptNameEn;

    //子部门/科室
    @TableField(exist = false)
    private List<SysDept> children;
}

