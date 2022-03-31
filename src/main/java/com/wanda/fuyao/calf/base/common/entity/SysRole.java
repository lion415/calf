package com.wanda.fuyao.calf.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;


/**
 * 系统角色表(SysRole)表实体类
 *
 * @Author Lion
 * @Date: 2022-03-25 09:57:12
 */
@SuppressWarnings("serial")
@Data
@TableName("CALF_SYS_ROLE")
public class SysRole{
    //角色主键
    @TableId
    private String roleId;
    //角色名称
    private String roleName;
    //角色编码
    private String roleCode;
    //备注
    private String remark;
}

