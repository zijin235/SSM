package mybatis.test;

import mybatis.mapper.SpecialSQLMapper;
import mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.SqlSessionUtil;

import java.sql.*;
import java.util.List;

public class SpecialSQLTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper=sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list=mapper.getUserByLike("a");
        list.forEach(System.out::println);

    }

    @Test
    public void testJDBC(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=UTC","root","Cw2359651184..");
//            String sql="select * from t_users where username like '%?%'";
//            PreparedStatement ps=connection.prepareStatement(sql);
            //ps.setString(1,"a");
            String sql="insert into t_users values(?,?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setNull(1,Types.INTEGER);
            ps.setString(2,"aa");
            ps.setString(3,"123456");
            ps.setInt(4,23);
            ps.setString(5,"男");
            ps.setString(6,"111@qq.com");
            ps.executeUpdate();
            ResultSet resultSet =ps.getGeneratedKeys();
            resultSet.next();
            int id=resultSet.getInt(1);
            System.out.println("插入数据的主键为：" + id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void deleteMoreUser(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper=sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("6,7");
    }
    @Test
    public void testGetUserList(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper=sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list=mapper.getUserList("t_users");
        list.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession=SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper=sqlSession.getMapper(SpecialSQLMapper.class);
        User user=new User(null,"xiaob","12356",23,"男","1234@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
