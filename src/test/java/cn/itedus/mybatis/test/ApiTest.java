package cn.itedus.mybatis.test;

import cn.itedus.mybatis.io.Resources;
import cn.itedus.mybatis.session.SqlSession;
import cn.itedus.mybatis.session.SqlSessionFactory;
import cn.itedus.mybatis.session.SqlSessionFactoryBuilder;
import cn.itedus.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:17
 * @description: 单元测试
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);

    }

}
