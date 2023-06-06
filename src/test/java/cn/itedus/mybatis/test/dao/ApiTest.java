package cn.itedus.mybatis.test.dao;

import cn.itedus.mybatis.binding.MapperProxyFactory;
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
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();

        sqlSession.put("cn.itedus.mybatis.test.dao.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml种SQL语句的操作：查询用户姓名");
        sqlSession.put("cn.itedus.mybatis.test.dao.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml种SQL语句的操作：查询用户年龄");

        IUserDao userDao = factory.newInstance(sqlSession);
        String res = userDao.queryUserName("10001");

        logger.info("测试结果：{}", res);

    }

}
