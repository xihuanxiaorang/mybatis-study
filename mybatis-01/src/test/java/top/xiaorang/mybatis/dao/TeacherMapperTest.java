package top.xiaorang.mybatis.dao;

import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xiaorang.mybatis.entity.Teacher;
import top.xiaorang.mybatis.utils.MybatisUtil;

import java.util.List;

public class TeacherMapperTest  {
    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @Test
    public void testSelectTeacherList() {
        List<Teacher> teachers = teacherMapper.selectTeacherList();
        teachers.forEach(System.out::println);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}