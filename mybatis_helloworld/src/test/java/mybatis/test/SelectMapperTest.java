package mybatis.test;

import mybatis.mapper.SelectMapper;
import mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        User user=mapper.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void testgetAllUsers(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        List<User> list=mapper.getAllUser();
        list.forEach(System.out::println);
    }
    @Test
    public void testCount(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        int count=mapper.Count();
        System.out.println(count);
    }
    @Test
    public void testgetUserByIdToMap(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map=mapper.getUserByIdToMap(3);
        System.out.println(map);
    }
    @Test
    public void testgetAllUserToMap(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
//        List<Map<String,Object>> list=mapper.getAllUserToMap();
//        System.out.println(list);
        Map<String,Object> map=mapper.getAllUserToMap();
        System.out.println(map);
    }
}
