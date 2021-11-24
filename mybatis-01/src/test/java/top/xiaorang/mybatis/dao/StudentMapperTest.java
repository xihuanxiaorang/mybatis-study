package top.xiaorang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xiaorang.mybatis.entity.Student;
import top.xiaorang.mybatis.utils.MybatisUtil;

import java.util.List;

public class StudentMapperTest {
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void testSelectStudents() {
        List<Student> students = studentMapper.selectStudents();
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectStudents2() {
        List<Student> students = studentMapper.selectStudents2();
        students.forEach(System.out::println);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}