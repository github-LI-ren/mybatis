package com;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyBatisTest {

    @Test
    public void testMybatis() throws IOException {
//        加载核心配置文件
        InputStream resource = Resources.getResourceAsStream("mybatis-config");
//        获取sql
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resource);
        SqlSession session = sessionFactory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUser();
    }
    @Test
    public void testMybatis2() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
    }
    @Test
    public void connectionTest() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/TestMybatis?allowPublicKeyRetrieval=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username="root";
        String password="qwe123";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void testSelect() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById();
        System.out.println(user);
    }
    @Test
    public void testSelectAll() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (User user : mapper.getAllUser()) {
            System.out.println(user);
        }

    }
}
