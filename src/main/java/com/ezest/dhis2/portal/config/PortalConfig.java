package com.ezest.dhis2.portal.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class PortalConfig {

	@Value("${dhis2.endpoint.user}")
	private String userEndpointUrl;
	
	@Bean
	public URI userEndpoint() {
		URI endpoint = null;
		try {
			endpoint = new URI(userEndpointUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return endpoint;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("admin", "district"));

		return restTemplate;
	}

}
