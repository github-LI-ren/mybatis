package mybatisTest;

import com.atguigu.mybatis.mapper.DynamicSQL;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DynamicSQLTest {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DynamicSQL mapper = sqlSession.getMapper(DynamicSQL.class);
        Emp emp = new Emp();
        emp.setAge(12);
        Dept dept = new Dept();
        System.out.println(dept.getDid());
        emp.setDept(dept);
        List<Emp> empByCondition = mapper.getEmpByConditionDemo3(emp);
        System.out.println(empByCondition);
    }
    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DynamicSQL mapper = sqlSession.getMapper(DynamicSQL.class);
        List<Emp> empByConditionDemo4 = mapper.getEmpByConditionDemo4(new Emp(null, null, null, null, new Dept()));
        System.out.println(empByConditionDemo4);
    }

}
