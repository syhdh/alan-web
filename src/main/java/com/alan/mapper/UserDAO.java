package com.alan.mapper;

import org.apache.ibatis.annotations.Param;

import com.alan.model.User;

public interface UserDAO {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User findByNameAndPassword(@Param("nickname")String nickname,@Param("password")String password);
}