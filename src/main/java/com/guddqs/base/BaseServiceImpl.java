package com.guddqs.base;

import com.guddqs.common.PageEntity;
import com.guddqs.common.PageParams;

import java.util.List;
import java.util.Map;

/**
 * @author wq
 * @date 2018/5/8
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

    protected BaseSqlMapper sqlMapper;

    @Override
    public void add(T entity) throws Exception {
        sqlMapper.add(entity);
    }

    @Override
    public void modify(T entity) throws Exception {
        sqlMapper.modify(entity);
    }

    @Override
    public void remove(Object[] ids) throws Exception {
        sqlMapper.remove(ids);
    }

    @Override
    public T findById(String id) throws Exception {
        return sqlMapper.findById(id);
    }

    @Override
    public List<T> findAll() throws Exception {
        return sqlMapper.findAll();
    }

    @Override
    public List<T> findAll(Map<String, Object> filters) throws Exception {
        return sqlMapper.findAll(filters);
    }

    @Override
    public PageEntity<T> findAll(PageParams pageParams, Map<String, Object> params) throws Exception {
        PageEntity<T> page = new PageEntity<>();
        page.setTotal(sqlMapper.count(params));
        params.put("page", pageParams);
        List<T> list = sqlMapper.findAll(params);
        page.setData(list);
        return page;
    }
}
