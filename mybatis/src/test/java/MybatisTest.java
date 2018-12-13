import com.winter.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test() throws IOException {
        /**
         * 1.获得　SqlSessionFactory
         * 2.获得 SqlSession
         * 3.调用在mapper文件中配置的SQL语句
         */

        //定位核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用mapper中的方法　命名空间+id
        List<Person> personList = sqlSession.selectList("UserMapper.findAll");

        for (Person p : personList) {
            System.out.println(p);
        }
    }
}
