package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {

    int insert(@Param("username")String username,@Param("password")String password);
    void auto_increment(@Param("index") Integer index);
    void deleteMore(@Param("ids") String ids);
    List<Object> getUserLike(@Param("username") String username);
    int insertUser(User user);
}
