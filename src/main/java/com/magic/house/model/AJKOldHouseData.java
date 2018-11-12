package com.magic.house.model;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author lenovo
 * @date 2018/10/11
 * 描述：安居客二手房信息
 */
@Data
@ToString
public class AJKOldHouseData extends AJKBaseData{

    private static final long serialVersionUID = 3694585866126118251L;
    /**年代*/
    private String houseAge;
    /**户型*/
    private String houseType;
    /**面积*/
    private String houseAreas;
    /**朝向*/
    private String houseOrien;
    /**楼层*/
    private String houseFloor;
    /**首付*/
    private String housePay;
    /**装修程度*/
    private String houseSpruce;

    public AJKOldHouseData(String no, String area, String address, Float price, String html, String houseAge, String houseType, String houseAreas, String houseOrien, String houseFloor, String housePay, String houseSpruce) {
        super(no, area, address, price, html);
        this.houseAge = houseAge;
        this.houseType = houseType;
        this.houseAreas = houseAreas;
        this.houseOrien = houseOrien;
        this.houseFloor = houseFloor;
        this.housePay = housePay;
        this.houseSpruce = houseSpruce;
    }

    public AJKOldHouseData() {
    }


}
