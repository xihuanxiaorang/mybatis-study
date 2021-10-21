package top.xiaorang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.xiaorang.mybatis.entity.User;
import top.xiaorang.mybatis.utils.MybatisUtil;

import java.util.List;

public class UserMapperTest {

    @Test
    public void selectUserList() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUserList();
        users.forEach(System.out::println);
        sqlSession.close();
    }
}