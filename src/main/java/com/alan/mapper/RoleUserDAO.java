package com.alan.mapper;

import com.alan.model.RoleUser;

public interface RoleUserDAO {
    int deleteByPrimaryKey(String userId);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}