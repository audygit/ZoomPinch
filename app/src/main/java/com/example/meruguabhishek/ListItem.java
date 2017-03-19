package com.example.meruguabhishek.zoompinch;


public class ListItem {
    private String name;
    private String company;
    private String image;
    private int drawable;

    public ListItem(String name,String company,int  drawable){
        setName(name);
        setDrawable(drawable);
        setCompany(company);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
