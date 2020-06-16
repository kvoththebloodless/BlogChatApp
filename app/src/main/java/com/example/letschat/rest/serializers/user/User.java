package com.example.letschat.rest.serializers.user;

public class User {
    private String token;

    //Setters and getters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "token:"+token;
    }
}
