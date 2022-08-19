package com.example.mavenspringboot.properties;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "wenky")
@PropertySource(value = "classpath:wenky.yaml", factory = YamlPropertySourceFactory.class)
public class WenkyProperties {
    private List<Field> fields;

    @Data
    public static final class Field {
        private String name;
        private Integer age;
    }
}
