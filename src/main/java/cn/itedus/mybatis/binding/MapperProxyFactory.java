package cn.itedus.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:03
 * @description: 映射器代理工厂
 */
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
