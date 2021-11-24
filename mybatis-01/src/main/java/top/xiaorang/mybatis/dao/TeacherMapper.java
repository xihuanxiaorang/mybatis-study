package top.xiaorang.mybatis.dao;

import org.apache.ibatis.annotations.*;
import top.xiaorang.mybatis.entity.Teacher;
import top.xiaorang.mybatis.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author liulei
 */
public interface TeacherMapper {
    /**
     * 查询所有的老师
     *
     * @return 老师集合
     */
    List<Teacher> selectTeacherList();
}
