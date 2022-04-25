package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQL {

    /**
     * 实现多条件查询
     */
    List<Emp> getEmpByConditionDemo1(Emp emp);
    List<Emp> getEmpByConditionDemo2(Emp emp);
    List<Emp> getEmpByConditionDemo3(Emp emp);

    /**
     * 测试choose,when,otherwise
     * @param emp
     * @return
     */
    List<Emp> getEmpByConditionDemo4(Emp emp);
    int deleteEmpMore(@Param("eids") Integer[] eids);
    /**
     * 批量插入
     */
    int insertEmpMore(@Param("emps") List<Emp> emps);
}
