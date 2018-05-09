package com.guddqs.service.impl;

import com.guddqs.base.BaseServiceImpl;
import com.guddqs.base.BaseSqlMapper;
import com.guddqs.entity.UserModel;
import com.guddqs.mapper.UserMapper;
import com.guddqs.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wq
 * @date 2018/5/8
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserModel> implements IUserService {

    @Resource(type = UserMapper.class)
    public void setSqlMapper(BaseSqlMapper sqlMapper) {
        this.sqlMapper = sqlMapper;
    }


}
