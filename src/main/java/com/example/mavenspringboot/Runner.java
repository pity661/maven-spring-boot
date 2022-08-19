package com.example.mavenspringboot;

import com.example.mavenspringboot.properties.WenkyProperties;
import com.example.mavenspringboot.utils.YamlToBeanUtils;
import java.io.IOException;
import java.util.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final WenkyProperties wenkyProperties;

    @Override
    public void run(String... args) throws Exception {
        //        propertyLoad();
        objectLoad();
        System.out.println(wenkyProperties.getFields());
    }

    private void objectLoad() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:wenky.yaml");
        WenkyProperties properties =
                YamlToBeanUtils.parser(resource, WenkyProperties.class, "wenky");
        System.out.println(properties.getFields());
    }

    private void propertyLoad() {
        Resource resource = new DefaultResourceLoader().getResource("classpath:wenky.yaml");
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(resource);
        Properties properties = yamlPropertiesFactoryBean.getObject();
        System.out.println(properties.size());
    }
}
