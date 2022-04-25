package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserParamenter {

    List<Map<String, Object>> getAllNameAndPassword();
//    以id字段作为键
    @MapKey("id")
    Map<String, Object> getAll();

    Map<String, Object> getParamenters(@Param("id") Integer id);
    /**
     * 添加用户信息
     */
    int addUser(User user);
    /**
     * 查找(参数为map)
     */
    User checkLogin(Map<String, Object>map);

    /**
     * Mybatis获取参数值的两种方式
     * ${}本质字符串拼接,需要注意单引号问题
     * #{}本质占位符赋值
     * #{arg0} #{arg1} 为键在map集合中找值
     */
    User getUserByUsername(String username);
    User getUserByUsernameAndId(String username,Integer id);
}
