package com.alawiya.springredis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    String id;
    String name;

    public String toString(){
        return this.id + ":" + this.name;
    }
}
