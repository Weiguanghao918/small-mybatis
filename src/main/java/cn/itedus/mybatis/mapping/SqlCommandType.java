package cn.itedus.mybatis.mapping;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-07 16:43
 * @description: SQL 指令类型
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
