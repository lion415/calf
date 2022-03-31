package com.wanda.fuyao.calf.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.cp.bean.WxCpUser;


/**
 * 系统人员表--与企业微信中的组织同步(SysUser)表实体类
 *
 * @Author Lion
 * @Date: 2022-03-21 14:31:16
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("CALF_SYS_USER")
public class SysUser{
    //成员UserID
    @TableId
    private String userId;
    //成员名称
    private String name;
    //成员所属部门id列表
    private String department;
    //部门内排序值
    private String orderBy;
    //职务
    private String position;
    //手机号码
    private String mobile;
    //性别。0-未定义；1-男性；2--女性
    private String gender;
    //邮箱
    private String email;
    //是否为部门负责人
    private String isLeaderInDept;
    //直属上级UserId
    private String directLeader;
    //头像url
    private String avatar;
    //头像缩略图url
    private String thumbAvatar;
    //座机
    private String telephone;
    //别名
    private String alias;
    //激活状态。1=已激活，2=已禁用，4=未激活，5=退出企业
    private String status;
    //地址
    private String address;
    //是否隐藏手机号码
    private String hideMobile;
    //英文名
    private String englishName;
    //全局唯一
    private String openUserId;
    //主部门
    private String mainDeptment;

    //角色
    @TableField(exist = false)
    private List<String> roles;
}

