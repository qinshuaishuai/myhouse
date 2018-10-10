package com.magic.house.model;

import java.io.Serializable;

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
