package cn.itedus.mybatis.test.dao;

import cn.itedus.mybatis.binding.MapperProxyFactory;
import cn.itedus.mybatis.binding.MapperRegistry;
import cn.itedus.mybatis.session.SqlSession;
import cn.itedus.mybatis.session.SqlSessionFactory;
import cn.itedus.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.itedus.mybatis.test.dao.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:17
 * @description: 单元测试
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {

        //1.注册Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("cn.itedus.mybatis.test.dao");

        //2. 从SqlSession工厂获取Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        //4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);

    }

}
