package mybatis.test;

import mybatis.mapper.UserMapper;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is=Resources.getResourceAsStream("mybatis-configure.xml");
        //获取sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象，是MyBatis提供的操作数据库的对象,方法设置为true会自动提交
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取usermapper的代理实现类对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户的功能
        int result=mapper.insertUser();
        //通过sql以及他的唯一表示找到sql并执行，唯一标识是namespace.sqlId
//        int result1 =sqlSession.insert("mybatis.mapper.UserMapper.insertUser");
        System.out.println("结果:"+result);//没有提交事务，默认回滚
//        sqlSession.commit();//提交事务
        sqlSession.close();//关闭sqlsession对象
    }
    @Test
    public void testUpdate() {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }
    @Test
    public void testDelete() {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }
    @Test
    public void testFindById(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        List<User> list=mapper.getAllUsers();
        System.out.println(list);
        sqlSession.close();
    }
}
