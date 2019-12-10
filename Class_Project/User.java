package com.ctucs310.macandcheezary;

public class User {
    String name;
    String price;
    String comments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String cost) {
        this.price = cost;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comment) {
        this.comments = comment;
    }

    public User(String name, String cost, String location) {
        super();
        this.name = name;
        this.price = cost;
        this.comments = location;
    }

}

