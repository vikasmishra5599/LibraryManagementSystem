package com.asssignment.LibraryManagementSystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.stream.Collectors;
import static java.nio.charset.Charset.defaultCharset;

@Service
public class FrontendService {
    private static final Logger LOG = LoggerFactory.getLogger(FrontendService.class);

    private ServletContext servletContext;
    private WebpackConfig webpackConfig;

    @Autowired
    public FrontendService(ServletContext servletContext,WebpackConfig webpackConfig) {
        this.servletContext = servletContext;
        this.webpackConfig = webpackConfig;
    }

    public String fetchLayout() {
        String content = "";
        try {
            content = StreamUtils.copyToString(
                    new ClassPathResource("/public/index.html").getInputStream(), defaultCharset());
        }
        catch (IOException e) {
            LOG.error("Error occurred while fetching layout", e);
        }
        return generateLayout(content);
    }

    private String generateLayout(String content) {
        return content.replace("$title", "Library Management System")
                .replace("$body",
                        "<div id='root'></div>" +
                                webpackConfig
                                        .getJs()
                                        .stream()
                                        .map(filename -> String.format(
                                                "<script type=\"text/javascript\" src=\"%s/%s\"></script>",
                                                servletContext.getContextPath(),
                                                filename
                                        ))
                                        .collect(Collectors.joining())
                                        .trim());
    }
}