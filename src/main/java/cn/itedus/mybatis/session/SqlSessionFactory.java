package cn.itedus.mybatis.session;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:55
 * @description: 工厂模式接口，构建SqlSession的工厂
 */
public interface SqlSessionFactory {

    /**
     * 打开一个session
     * @return SqlSession
     */
    SqlSession openSession();
}
