package top.xiaorang.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionFactoryBuilder 一旦创建了 SqlSessionFactory 就不再需要，因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域（即局部方法变量）
 * SqlSessionFactory 一旦创建就应该在应用的运行期间一直存在，没有任何理由丢弃或者重新创建另一个实例，因此 SqlSessionFactory 的最佳作用域是应用作用域（使用单例模式或者静态单例模式）
 * SqlSession 每个线程应该有它自己的 SqlSession 实例，SqlSession 实例不是线程安全的，因此不能被共享，所以它的最佳作用域是请求或者方法作用域。使用完之后一定记得关闭，或者占用资源。
 * @author liulei
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    private MybatisUtil() {
    }

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
