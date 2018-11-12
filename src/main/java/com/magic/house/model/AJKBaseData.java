package com.magic.house.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;


/**
 *
 * @author qinshuai
 * @date 2018/10/10
 * 描述：安居客录入基本数据
 */

@ToString
@Data
public class AJKBaseData implements Serializable {

    private static final long serialVersionUID = 485334363880756865L;

    private Integer id;

    private String no;

    private String area;

    private String address;

    private Float price;

    private String html;

    private Date day;

    public AJKBaseData(){}

    public AJKBaseData(String no, String area, String address, Float price, String html) {
        this.no = no;
        this.area = area;
        this.address = address;
        this.price = price;
        this.html = html;
        this.day = new Date();
    }

}
