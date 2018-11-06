package com.magic.house.model;

import java.util.Arrays;

/**
 *
 * @author lenovo
 * @date 2018/11/6
 * 描述：
 */
public class OldData {
    private String name;
    private Float[] prices;

    public OldData(){

    }

    public OldData(String name,Float[] prices){
        this.name=name;
        this.prices=prices;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float[] getPrices() {
        return prices;
    }

    public void setPrices(Float[] prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "OldData{" +
                "name='" + name + '\'' +
                ", prices=" + Arrays.toString(prices) +
                '}';
    }
}
