package com.atguigu.mybatis.util;

import com.sun.istack.internal.Nullable;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(String mybatisConfig_xml) throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(resource);
        SqlSession session = sessionFactory.openSession(true);
        return session;
    }
}
