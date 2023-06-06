package cn.itedus.mybatis.test.dao.dao;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-06 17:17
 * @description:
 */
public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
