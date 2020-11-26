package com.example.demo;

import com.example.demo.SeleniumConfig;

public class SeleniumExample {
    private SeleniumConfig config;
    private String url = "http://localhost:8080/log";

    public SeleniumExample() {
        config = new SeleniumConfig();
        config.getDriver().get(url);
    }

    public void closeWindow() {
        this.config.getDriver().close();
    }

    public String getTitle() {
        return this.config.getDriver().getTitle();
    }
}
