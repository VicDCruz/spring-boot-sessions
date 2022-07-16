package com.example.onlineretailer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "resources")
@Getter
@Setter
@ToString
public class ResourcesBean {
    private String db;
    private String logs;
    private boolean secure;
}
