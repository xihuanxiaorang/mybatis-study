package top.xiaorang.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import top.xiaorang.mybatis.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author liulei
 */
public interface BlogMapper {
    /**
     * 更新博客
     *
     * @param params 查询条件
     */
    void updateBlog(Map<String, Object> params);

    /**
     * 根据条件查询所有的博客列表
     *
     * @param params 查询条件
     * @return 博客列表
     */
    List<Blog> queryBlogChoose(Map<String, Object> params);

    /**
     * 根据条件查询所有的博客列表
     *
     * @param params 查询条件
     * @return 博客列表
     */
    List<Blog> findBlogs(Map<String, Object> params);

    /**
     * 根据ids查询博客列表
     * @param ids id集合
     * @return 博客列表
     */
    List<Blog> findBlogsById(@Param("ids") List<String> ids);
}
