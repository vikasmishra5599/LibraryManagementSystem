package com.asssignment.LibraryManagementSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontendController {
    Logger LOG = LoggerFactory.getLogger(FrontendController.class);

    @GetMapping("/")
    public String appStatus() {
        LOG.info("starting app");
        return "App is up and running";
    }
}
