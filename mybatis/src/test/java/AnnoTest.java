import com.winter.Kid;
import com.winter.KidMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnoTest {

    public SqlSession getSqlSession() throws IOException {
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
    public void testSelectById() throws IOException {
        SqlSession sqlSession = getSqlSession();
        KidMapper kidMapper = sqlSession.getMapper(KidMapper.class);

        Kid kid = kidMapper.selectById(1);

        sqlSession.close();
    }


    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = getSqlSession();

        KidMapper kidMapper = sqlSession.getMapper(KidMapper.class);

        Kid kid = new Kid();
        kid.setName("xiaofu");
        kid.setNum("0004");
        kid.setBirthDate(new Date());

        int result = kidMapper.insert(kid);
        System.out.println(result);
        sqlSession.commit();

        sqlSession.close();
    }



}
