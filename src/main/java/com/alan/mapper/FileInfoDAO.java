package com.alan.mapper;

import com.alan.model.FileInfoModel;

public interface FileInfoDAO {
    int deleteByPrimaryKey(String id);

    int insert(FileInfoModel record);

    int insertSelective(FileInfoModel record);

    FileInfoModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FileInfoModel record);

    int updateByPrimaryKey(FileInfoModel record);
}