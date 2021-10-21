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

    /**
     * 通过id查询用户
     *
     * @param id 用户id
     * @return 用户
     */
    User selectUserById(Integer id);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 插入的记录数
     */
    int addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    void updateUser(User user);

    /**
     * 通过id删除用户
     *
     * @param id 用户id
     * @return 删除的记录数
     */
    int deleteUserById(Integer id);
}
