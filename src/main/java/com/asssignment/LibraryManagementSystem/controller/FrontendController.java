package com.asssignment.LibraryManagementSystem.controller;

import com.asssignment.LibraryManagementSystem.service.FrontendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@RestController
public class FrontendController {
    private static final Logger LOG = LoggerFactory.getLogger(FrontendController.class);
    private FrontendService frontendService;

    @Autowired
    public FrontendController(FrontendService frontendService) {
        this.frontendService = frontendService;
    }

    @GetMapping(value = {"/", ""}, produces = TEXT_HTML_VALUE)
    public String fetchLayout() {
        LOG.info("Loading layout for app");
        return frontendService.fetchLayout();
    }
}
