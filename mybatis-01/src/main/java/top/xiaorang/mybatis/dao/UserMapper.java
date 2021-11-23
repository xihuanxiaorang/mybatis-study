package top.xiaorang.mybatis.dao;

import org.apache.ibatis.annotations.*;
import top.xiaorang.mybatis.entity.User;

import java.util.List;
import java.util.Map;

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
     * 查询所有的用户
     *
     * @return 用户集合
     */
    @Select("select * from user")
    List<User> selectUserList2();

    /**
     * 通过id查询用户
     *
     * @param id 用户id
     * @return 用户
     */
    User selectUserById(Integer id);

    /**
     * 通过id查询用户
     *
     * @param id 用户id
     * @return 用户
     */
    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") Integer id);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 插入的记录数
     */
    int addUser(User user);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 插入的记录数
     */
    @Insert("insert into user(id, name, pwd) values(#{id}, #{name}, #{password})")
    int addUser2(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    void updateUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    void updateUser2(User user);

    /**
     * 通过id删除用户
     *
     * @param id 用户id
     * @return 删除的记录数
     */
    int deleteUserById(Integer id);

    /**
     * 通过id删除用户
     *
     * @param id 用户id
     * @return 删除的记录数
     */
    @Delete("delete from user where id = #{id}")
    int deleteUserById2(Integer id);

    /**
     * 通过用户名称模糊查询用户
     *
     * @param name 用户名称
     * @return 用户集合
     */
    List<User> selectUserByName(String name);

    /**
     * 根据id和用户名称查询用户
     *
     * @param params 查询条件
     * @return 用户集合
     */
    List<User> selectUsers(Map<String, Object> params);

    /**
     * 分页查询用户数据
     *
     * @param params 查询条件(从第多少条开始查，每页多少条数据)
     * @return 用户集合
     */
    List<User> selectUsersByPage(Map<String, Integer> params);
}
