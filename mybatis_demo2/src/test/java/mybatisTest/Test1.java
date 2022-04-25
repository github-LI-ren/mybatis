package mybatisTest;

import com.atguigu.mybatis.mapper.*;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    @Test
    public void test1() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(resource);
        SqlSession session1 = sessionFactory.openSession(true);
        SqlSession session2= sessionFactory.openSession(true);
        System.out.println(session1 == session2);
        System.out.println(session1);
        System.out.println(session2);
        UserMapper mapper = session1.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        for (User user : allUser){
            System.out.println(user);
        }

    }
    @Test
    public void test2() throws IOException {
        SqlSession session = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserParamenter mapper = session.getMapper(UserParamenter.class);
        User admin2 = mapper.getUserByUsernameAndId("admin1",1);
        System.out.println(admin2);
    }
    @Test
    public void test3() throws IOException {
        SqlSession session = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserParamenter mapper = session.getMapper(UserParamenter.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",1);
        hashMap.put("username","admin1");
        User admin2 = mapper.checkLogin(hashMap);
        System.out.println(admin2);
    }
    @Test
    public void test4() throws IOException {
        SqlSession session = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserParamenter mapper = session.getMapper(UserParamenter.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        User user = new User();
        user.setUsername("admin3");
        user.setPassword("qwe222");
        int r = mapper.addUser(user);
        System.out.println(r);
    }
    @Test
    public void test5() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserParamenter mapper = sqlSession.getMapper(UserParamenter.class);
        Map<String, Object> all = mapper.getAll();
        Object o = all.get(1);
        System.out.println(o);
        System.out.println(all);
    }
    @Test
    public void test6() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<Object> admin = mapper.getUserLike("admin");
        System.out.println(admin);
    }
    @Test
    public void test7() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        mapper.auto_increment(1);
    }
    @Test
    public void test8() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        mapper.deleteMore("1,2,3,4");
    }
    @Test
    public void test9() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        mapper.insert("admin1","qwsdas");
        mapper.insert("admin2","qwsdas");
        mapper.insert("admin3","qwsdas");
        mapper.insert("admin4","qwsdas");
    }
    @Test
    public void test10() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "admin5", "slkdjasd", 1, "男", "12321@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
    @Test
    public void test11() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
    }
    @Test
    public void test12() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDepartment = mapper.getEmpAndDepartment(1);
//        只执行第一个sql
        System.out.println(empAndDepartment.getDept());
    }
    @Test
    public void test13() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptWithEmpList = mapper.getDeptWithEmpList(1);
        System.out.println(deptWithEmpList);
    }
    @Test
    public void test14() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empByDid = mapper.getEmpByDid(1);
        System.out.println(empByDid);
    }
    @Test
    public void test15() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DynamicSQL mapper = sqlSession.getMapper(DynamicSQL.class);
        Dept dept = new Dept();
        dept.setDid(1);
        Emp admin2 = new Emp(null, "admin4", "123@qq.com", 12, dept);
        Emp admin3 = new Emp(null, "admin5", "123@qq.com", 12, dept);
        Emp admin4 = new Emp(null, "admin6", "123@qq.com", 12, dept);
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(admin2);
        emps.add(admin3);
        emps.add(admin4);
        mapper.insertEmpMore(emps);
    }

}
