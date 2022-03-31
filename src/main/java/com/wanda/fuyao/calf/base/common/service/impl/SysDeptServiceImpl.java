package com.wanda.fuyao.calf.base.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanda.fuyao.calf.base.common.mapper.SysDeptMapper;
import com.wanda.fuyao.calf.base.common.entity.SysDept;
import com.wanda.fuyao.calf.base.common.service.SysDeptService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统部门表--与企业微信同步(SysDept)表服务实现类
 *
 * @Author Lion
 * @Date: 2022-03-22 11:09:46
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    /**
     * @Method
     * @Description 获取子部门所有数据
     * @Params
     * @Return
     * @Throws
     * @Author Lion
     * @Date 2022/03/29 17:30
     */
    public List<SysDept> buildDeptTree(String parentId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("parent_id",parentId);
        //根据parentid获取父节点为parentid的子集合
        List<SysDept> childrenDept =  this.getBaseMapper().selectList(wrapper);

        //子集合不为空,则新建一个List<Department>
        if(childrenDept.size() > 0){
            for (SysDept dept:childrenDept){
                //遍历集合，判断集合中的每一个是否有子节点，递归调用
                List<SysDept> subDeptmentList = buildDeptTree(dept.getDeptId());
//                System.out.println("<--------------deptName:" + dept.getDeptName() + "--------" + subDeptmentList.size());
                if(subDeptmentList != null && subDeptmentList.size() > 0){
                    dept.setChildren(subDeptmentList);
                }
            }
        }

        return childrenDept;
    }

    @Override
    public SysDept getDeptTree(String deptId) {
        SysDept basicDept = this.getBaseMapper().selectById(deptId);
        basicDept.setChildren(buildDeptTree(basicDept.getDeptId()));
        return basicDept;
    }
}

