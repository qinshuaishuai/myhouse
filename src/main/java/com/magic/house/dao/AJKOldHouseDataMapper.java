package com.magic.house.dao;

import com.magic.house.model.AJKOldHouseData;

import org.springframework.stereotype.Repository;

@Repository
public interface AJKOldHouseDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AJKOldHouseData record);

    int insertSelective(AJKOldHouseData record);

    AJKOldHouseData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AJKOldHouseData record);

    int updateByPrimaryKey(AJKOldHouseData record);
}