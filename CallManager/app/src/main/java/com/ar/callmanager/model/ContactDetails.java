package com.ar.callmanager.model;

/**
 * Created by 22716832 on 5/19/16.
 */
public class ContactDetails {

    private String name;
    private String number;

    public ContactDetails(String name, String number){
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
