package top.xiaorang.mybatis.dao;

import top.xiaorang.mybatis.entity.User;

import java.util.List;

/**
 * @author liulei
 */
public interface UserMapper {
    /**
     * 查询所有的用户
     *
     * @return 用户集合
     */
    List<User> selectUserList();
}
