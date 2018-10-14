package com.magic.house.dao;

import com.magic.house.model.AJKBaseData;

import org.springframework.stereotype.Repository;

@Repository
public interface AJKBaseDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AJKBaseData record);

    int insertSelective(AJKBaseData record);

    AJKBaseData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AJKBaseData record);

    int updateByPrimaryKey(AJKBaseData record);
}