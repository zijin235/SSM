package test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.util.List;

public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        /**
         * 开启分页功能
         */
        Page<Object> page=PageHelper.startPage(1,4);
        List<Emp> list =mapper.selectByExample(null);
        //查询功能之后，可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo=new PageInfo<>(list,5);//导航分页的页码数
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
