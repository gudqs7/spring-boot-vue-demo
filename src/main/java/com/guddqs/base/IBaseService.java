package com.guddqs.base;

import com.guddqs.common.PageEntity;
import com.guddqs.common.PageParams;

import java.util.List;
import java.util.Map;

/**
 * @author wq
 * @date 2018/5/8
 */
public interface IBaseService<T> {

    /**
     * 统一新增
     * @param entity 实体
     * @throws Exception 异常拦截
     */
     void add(T entity) throws Exception;

    /**
     * 统一修改
     *
     * @param entity 实体
     * @throws Exception 异常拦截
     */
     void modify(T entity) throws Exception;

    /**
     * 统一删除
     *
     * @param ids id 数组
     * @throws Exception 异常拦截
     */
    void remove(Object[] ids) throws Exception;

    /**
     * 统一查找单个
     *
     * @param id  实体 id
     * @return 单个结果
     * @throws Exception 异常拦截
     */
     T findById(String id) throws Exception;

    /**
     * 统一查找所有(无条件)
     * @return 多条结果
     * @throws Exception 异常拦截
     */
     List<T> findAll() throws Exception;

    /**
     * 统一查找所有(带条件)
     *
     * @param filters 条件 map
     * @return 多条结果
     * @throws Exception 异常拦截
     */
     List<T> findAll(Map<String, Object> filters) throws Exception;

    /**
     * 统一查找分页(带条件)
     * @param pageParams 分页参数
     * @param params 条件map
     * @return 分页结果
     * @throws Exception 异常拦截
     */
    PageEntity<T> findAll(PageParams pageParams, Map<String, Object> params) throws Exception;

}
