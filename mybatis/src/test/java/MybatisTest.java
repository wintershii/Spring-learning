import com.winter.Person;
import com.winter.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public SqlSession getSqlSession() throws IOException {
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
        return sqlSession;
    }

    @Test
    public void testSelect() throws IOException {


        //调用mapper中的方法　命名空间+id
       //List<Person> personList = sqlSession.selectList("UserMapper.findAll",1);

        SqlSession sqlSession = getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Person> personList = userMapper.findAll(1);

        for (Person p : personList) {
            System.out.println(p);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectByParam() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Person> personList = userMapper.selectSingle("shidongxuan",19);
        System.out.println(personList);

        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Person p = new Person();
        p.setName("777");
        p.setAge(29);


        int result = userMapper.insert(p);
        System.out.println(p.getId());


        sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void testUpdateById() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Person p = new Person();
        p.setId(8);
        p.setName("mengmengchen");
        p.setAge(18);

        int result = userMapper.updateById(p);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int result = userMapper.deleteById(10);

        sqlSession.commit();
        sqlSession.close();
    }
}
