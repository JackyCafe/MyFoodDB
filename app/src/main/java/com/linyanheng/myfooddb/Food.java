package com.linyanheng.myfooddb;

import java.io.Serializable;

/**
 * Created by linyanheng on 2017/12/13.
 */

public class Food implements Serializable {
   private long id;
   private String food;
   private String cal;


    public Food() {}
    public Food(int id, String food, String cal) {
        this.id = id;
        this.food = food;
        this.cal = cal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", food='" + food + '\'' +
                ", cal='" + cal + '\'' +
                '}';
    }
}
