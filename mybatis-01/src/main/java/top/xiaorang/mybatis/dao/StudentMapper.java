package top.xiaorang.mybatis.dao;

import top.xiaorang.mybatis.entity.Student;
import top.xiaorang.mybatis.entity.Teacher;

import java.util.List;

/**
 * @author liulei
 */
public interface StudentMapper {
    /**
     * 查询所有的学生
     * @return 学生集合
     */
    List<Student> selectStudents();

    /**
     * 查询所有的学生
     * @return 学生集合
     */
    List<Student> selectStudents2();
}
