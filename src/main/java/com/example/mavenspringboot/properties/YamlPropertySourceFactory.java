package com.example.mavenspringboot.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource)
            throws IOException {
        Resource resource = encodedResource.getResource();
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource);
        Properties properties = factoryBean.getObject();
        if (properties == null) {
            throw new FileNotFoundException();
        }
        return new PropertiesPropertySource(
                Objects.requireNonNull(Optional.ofNullable(name).orElse(resource.getFilename())),
                properties);
    }
}
