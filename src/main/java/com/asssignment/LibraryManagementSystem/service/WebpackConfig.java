package com.asssignment.LibraryManagementSystem.service;

import java.util.List;

public class WebpackConfig {
    private List<String> js;

    public WebpackConfig(List<String> js) {
        this.js = js;
    }

    public List<String> getJs() {
        return js;
    }
}