package cn.itedus.mybatis.session.defaults;

import cn.itedus.mybatis.binding.MapperRegistry;
import cn.itedus.mybatis.mapping.MappedStatement;
import cn.itedus.mybatis.session.Configuration;
import cn.itedus.mybatis.session.SqlSession;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:56
 * @description: 默认SqlSession实现类
 */
public class DefaultSqlSession implements SqlSession {


    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
