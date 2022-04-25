package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询员工以及员工所对应的部门
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);
    /**
     * 通过分步查询查询员工以及对应的部门信息
     */
    Emp getEmpAndDepartment(@Param("eid") Integer eid);

    List<Emp> getEmpByDid(@Param("did") Integer did);
}
