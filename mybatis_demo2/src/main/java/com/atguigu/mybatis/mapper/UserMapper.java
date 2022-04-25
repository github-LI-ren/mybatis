package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     *
     * mybatis面向接口编程的两个一直
     * 1.映射文件的namespace和mapper接口的全类名保持一致
     * 2.
     */

    int insertUser();
//    修改用户信息
    void updateUser();
    void deleteUser();
    User selectUserById();
    List<User> getAllUser();

}
