package com.wanda.fuyao.calf.base.common.controller;

import com.wanda.fuyao.calf.base.common.entity.ResponseResult;
import com.wanda.fuyao.calf.base.common.entity.SysDept;
import com.wanda.fuyao.calf.base.common.entity.SysUser;
import com.wanda.fuyao.calf.base.common.service.impl.SysDeptServiceImpl;
import com.wanda.fuyao.calf.base.common.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @PackName: com.wanda.fuyao.calf.base.common.controller
 * @ClassName: VueDeptUserController
 * @Description: 前端Vue 部门/用户相关接口
 * @User: Lion
 * @Date: 2022/03/29  17:06
 */
@RestController
@RequestMapping("/pc/system")
public class VueDeptUserController {
    @Autowired
    SysDeptServiceImpl sysDeptService;

    @Autowired
    SysUserServiceImpl sysUserService;

    @RequestMapping("deptTree")
    public ResponseResult deptTree(){
        //获取福清汽玻下的所有部门组织
        SysDept deptTree = sysDeptService.getDeptTree("52");
        return ResponseResult.okResult(Arrays.asList(deptTree));
    }

    @RequestMapping("userList")
    public ResponseResult userList(@RequestParam String deptId){
        List<SysUser> userList = sysUserService.getSysUserListByDeptId(deptId);


        return ResponseResult.okResult(userList);
    }


}
