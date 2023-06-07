package cn.itedus.mybatis.builder;

import cn.itedus.mybatis.session.Configuration;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-07 16:42
 * @description: 构建器的基类，建造者模式
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
