package com.magic.house.dao;
/**
 *
 * @author lenovo
 * @date 2018/11/13
 * 描述：
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

}
