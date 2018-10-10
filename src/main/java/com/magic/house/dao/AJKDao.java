package com.magic.house.dao;

import com.magic.house.model.AJKBaseData;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface AJKDao {

    /**
     * 插入方法
     * @param data
     */
    @Insert("insert into h_ajk_new(`no`,`area`,`address`,`price`,`html`,`day`) " +
            "values(#{data.no},#{data.area},#{data.address},#{data.price},#{data.html},now())")
    void insert(@Param("data") AJKBaseData data);

}
