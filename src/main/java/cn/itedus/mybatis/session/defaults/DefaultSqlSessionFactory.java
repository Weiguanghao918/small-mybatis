package cn.itedus.mybatis.session.defaults;

import cn.itedus.mybatis.binding.MapperRegistry;
import cn.itedus.mybatis.session.Configuration;
import cn.itedus.mybatis.session.SqlSession;
import cn.itedus.mybatis.session.SqlSessionFactory;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:56
 * @description: 默认的DefaultSqlSessionFactory
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
