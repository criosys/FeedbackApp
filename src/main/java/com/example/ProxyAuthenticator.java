package com.example;

import java.net.PasswordAuthentication;

/**
 * Created by n0148661 on 11/11/16.
 */
public class ProxyAuthenticator extends java.net.Authenticator {

    private String user, password;

    public ProxyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public ProxyAuthenticator() {

    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password.toCharArray());
    }
}
