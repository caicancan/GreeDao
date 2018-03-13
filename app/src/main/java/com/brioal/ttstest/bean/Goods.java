package com.brioal.ttstest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by n009654 on 2018/3/12.
 */
@Entity
public class Goods implements Serializable{
    static final long serialVersionUID = 42L;
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "PRICE")
    private int price;
    @Property(nameInDb = "ISSALE")
    private boolean issale;

    public Goods(String name, int price, boolean issale) {
        this.name = name;
        this.price = price;
        this.issale = issale;
    }

    public Goods() {
    }

    @Generated(hash = 512496623)
    public Goods(Long id, String name, int price, boolean issale) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.issale = issale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isIssale() {
        return issale;
    }

    public void setIssale(boolean issale) {
        this.issale = issale;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", issale=" + issale +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIssale() {
        return this.issale;
    }
}
