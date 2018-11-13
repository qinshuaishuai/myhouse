package com.magic.house.service.impl;

import com.magic.house.dao.AJKBaseDataMapper;
import com.magic.house.dao.AJKOldHouseDataMapper;
import com.magic.house.model.OldData;
import com.magic.house.service.AjkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author lenovo
 * @date 2018/11/13
 * 描述：
 */
@Service
public class AjkServiceImpl implements AjkService{

    @Autowired
    private AJKBaseDataMapper ajkBaseDataMapper;

    @Autowired
    private AJKOldHouseDataMapper ajkOldHouseDataMapper;

    @Override
    public List<OldData> queryOldDatas() {
        return null;
    }
}
