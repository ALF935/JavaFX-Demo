package com.example.javafxdemo;

import java.util.ArrayList;

public class Account{
    private String login;
    private String password;

    public Account(String Log, String Pass){
        this.login = Log;
        this.password = Pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
