package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    /**
     * 通过did查询部门信息
     */
    Dept getDeptByDid(@Param("did") Integer did);

    /**
     * 获取部门以及部门中的员工信息
     * @return
     */
    Dept getDeptWithEmpList(@Param("did") Integer did);
}
