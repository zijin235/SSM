package mybatis.test;

import mybatis.mapper.DynamicSQLMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(null,"",22,"");
        List<Emp> list=mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChooose(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(null,"张三",22,"");
        List<Emp> list=mapper.getEmpByChoose(emp);
        list.forEach(System.out::println);
    }
    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper =sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1=new Emp(null,"小1",20,"男");
        Emp emp2=new Emp(null,"小2",20,"男");
        Emp emp3=new Emp(null,"小3",20,"男");
        List<Emp> list=Arrays.asList(emp1,emp2,emp3);
        mapper.insertMoreEmp(list);
    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds=new Integer[]{3,4,5};
        mapper.deleteMoreEmp(empIds);

    }

}
