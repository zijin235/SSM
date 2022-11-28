package test;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.pojo.EmpExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        /**
         * 根据id查询数据
         */
//        Emp emp=mapper.selectByPrimaryKey(1);
        /**
         * 查询所有数据
         */
//        List<Emp> list=mapper.selectByExample(null);
        /**
         * 根据条件查询
         */
//        EmpExample example=new EmpExample();
//        example.createCriteria().andEmpNameEqualTo("张三");
//        example.or().andEmpGenderEqualTo("男");
//        List<Emp> list=mapper.selectByExample(example);
//        System.out.println(list);
        /**
         * 测试普通修改功能
         */
//        Emp emp=new Emp(1,"小黑",null,"女");
//        mapper.updateByPrimaryKey(emp);
        /**
         * 选择性修改
         */
        Emp emp=new Emp(1,"小白",null,"女");
        mapper.updateByPrimaryKeySelective(emp);
    }
}
