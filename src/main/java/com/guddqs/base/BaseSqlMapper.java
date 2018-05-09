package com.guddqs.base;

import java.util.List;
import java.util.Map;

/**
 * @author wq
 * @date 2018/5/8
 */
public interface BaseSqlMapper extends SqlMapper {

    /**
     * 统一查询总数
     * @return 总条数
     * @throws Exception 异常拦截
     * @param params 查询条件
     */
    int count(Map<String, Object> params) throws Exception;

    /**
     * 统一新增
     * @param entity 实体
     * @param <T> 实际实体
     * @throws Exception 异常拦截
     */
    <T> void add(T entity) throws Exception;

    /**
     * 统一修改
     * @param entity 实体
     * @param <T> 实际实体
     * @throws Exception 异常拦截
     */
    <T> void modify(T entity) throws Exception;

    /**
     * 统一删除
     * @param ids id 数组
     * @throws Exception 异常拦截
     */
    void remove(Object[] ids) throws Exception;

    /**
     * 统一查找单个
     * @param id 实体 id
     * @param <T> 实际实体
     * @return 单个结果
     * @throws Exception 异常拦截
     */
    <T> T findById(String id) throws Exception;

    /**
     * 统一查找所有(无条件)
     * @param <T> 返回类型
     * @return 多条结果
     * @throws Exception 异常拦截
     */
    <T> List<T> findAll() throws Exception;

    /**
     * 统一查找所有(带条件)
     * @param filters 条件 map
     * @param <T> 返回类型
     * @return 多条结果
     * @throws Exception 异常拦截
     */
    <T> List<T> findAll(Map<String, Object> filters) throws Exception;

}
