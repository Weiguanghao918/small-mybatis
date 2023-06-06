package cn.itedus.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import cn.itedus.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:55
 * @description: 映射器注册机
 */
public class MapperRegistry {
    //将已添加的映射器代理加入到HashMap
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);

        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type" + type + " is not known to the MapperRegistry");
        }

        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        //mapper必须是接口才会注册
        if (type.isInterface()) {
            if (hashMapper(type)) {
                //如果重复添加了，报错
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            //注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    private <T> boolean hashMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }
}
