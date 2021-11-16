package top.xiaorang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xiaorang.mybatis.entity.User;
import top.xiaorang.mybatis.utils.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void selectUserList() {
        List<User> users = userMapper.selectUserList();
        users.forEach(System.out::println);
    }

    @Test
    public void selectUserById() {
        User user = userMapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        int res = userMapper.addUser(new User(5, "xiaohuang", "456789"));
        System.out.printf("插入的记录数%s!", res);
    }

    @Test
    public void updateUser() {
        userMapper.updateUser(new User(5, "xiaoxin", "456789"));
    }

    @Test
    public void deleteUserById() {
        int res = userMapper.deleteUserById(5);
        System.out.printf("删除的记录数%s!", res);
    }

    @Test
    public void testSelectUserByName() {
        List<User> users = userMapper.selectUserByName("xiao");
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectUsers() {
        Map<String,Object> params = new HashMap<>();
        params.put("id", 1);
        params.put("name", "xiao");
        List<User> users = userMapper.selectUsers(params);
        users.forEach(System.out::println);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}