package cn.itedus.mybatis.session.defaults;

import cn.itedus.mybatis.binding.MapperRegistry;
import cn.itedus.mybatis.session.SqlSession;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:56
 * @description: 默认SqlSession实现类
 */
public class DefaultSqlSession implements SqlSession {

    //映射注册机
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
