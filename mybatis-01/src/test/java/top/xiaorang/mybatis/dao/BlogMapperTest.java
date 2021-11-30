package top.xiaorang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xiaorang.mybatis.entity.Blog;
import top.xiaorang.mybatis.utils.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {
    private SqlSession sqlSession;
    private BlogMapper blogMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        blogMapper = sqlSession.getMapper(BlogMapper.class);
    }

    @Test
    public void testFindBlogs() {
        Map<String, Object> params = new HashMap<>();
        params.put("title", "java如此简单");
        params.put("author", "xiaorang");
        params.put("id", "95231459-b135-9ca3-386a-24992d5e2c72");
        List<Blog> blogs = blogMapper.findBlogs(params);
        blogs.forEach(System.out::println);
    }

    @Test
    public void testQueryBlogChoose() {
        Map<String, Object> params = new HashMap<>();
//        params.put("title", "java如此简单");
//        params.put("author", "xiaoxing");
        params.put("views", 9999);
        List<Blog> blogs = blogMapper.queryBlogChoose(params);
        blogs.forEach(System.out::println);
    }

    @Test
    public void testUpdateBlog() {
        Map<String, Object> params = new HashMap<>();
        params.put("title", "python如此简单");
        params.put("author", "xiaoxing");
        params.put("id", "95231459-b135-9ca3-386a-24992d5e2c72");
        blogMapper.updateBlog(params);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}