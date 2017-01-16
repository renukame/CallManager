package com.ar.callmanager.model;

/**
 * Created by Renuka on 16-01-2017.
 */

public class WhiteDetails {
    private String name;
    private String number;

    public WhiteDetails(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }
}
