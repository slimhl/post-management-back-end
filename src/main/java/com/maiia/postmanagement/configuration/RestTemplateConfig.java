package com.maiia.postmanagement.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean()
	public RestTemplate prepareRestTemplate() {
		RestTemplateBuilder builder= new RestTemplateBuilder();
		return builder.build();
		}
}
