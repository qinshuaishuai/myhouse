package com.magic.house.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author qinshuai
 * @date 2018/10/10
 * 描述：安居客录入基本数据
 */
public class AJKBaseData implements Serializable {

    private static final long serialVersionUID = 485334363880756865L;

    private Integer id;

    private String no;

    private String area;

    private String address;

    private Float price;

    private String html;

    private Date date;

    public AJKBaseData(){}

    public AJKBaseData(String no, String area, String address, Float price, String html) {
        this.no = no;
        this.area = area;
        this.address = address;
        this.price = price;
        this.html = html;
        this.date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AJKBaseData{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", html='" + html + '\'' +
                '}';
    }
}
