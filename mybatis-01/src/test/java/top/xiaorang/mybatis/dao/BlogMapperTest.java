package top.xiaorang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.xiaorang.mybatis.entity.Blog;
import top.xiaorang.mybatis.utils.MybatisUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {
    private SqlSession sqlSession;
    private SqlSession sqlSession2;
    private BlogMapper blogMapper;
    private BlogMapper blogMapper2;

    @Before
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        sqlSession2 = MybatisUtil.getSqlSession();
        blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper2 = sqlSession2.getMapper(BlogMapper.class);
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

    @Test
    public void testFindBlogsById() {
        List<String> ids = Arrays.asList("95231459-b135-9ca3-386a-24992d5e2c72", "69824e2e-8048-0bf4-3477-0e04299be4a9");
        List<Blog> blogs = blogMapper.findBlogsById(ids);
        blogs.forEach(System.out::println);
        System.out.println("============================");
        // 测试一级缓存，在同一个sqlSession中查询相同的数据，查看到下面的sql语句没有去查询数据库
        List<Blog> blogs2 = blogMapper.findBlogsById(ids);
        blogs2.forEach(System.out::println);
        // 取出来的对象是否是同一个
        System.out.println(blogs == blogs2);
    }

    @Test
    public void testCache2() {
        List<String> ids = Arrays.asList("95231459-b135-9ca3-386a-24992d5e2c72", "69824e2e-8048-0bf4-3477-0e04299be4a9");
        List<Blog> blogs2 = blogMapper2.findBlogsById(ids);
        blogs2.forEach(System.out::println);
        // sqlSession2 关闭的时候会将一级缓存保存到二级缓存
        sqlSession2.close();
        System.out.println("================================");
        List<Blog> blogs = blogMapper.findBlogsById(ids);
        blogs.forEach(System.out::println);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}