package com.ezest.dhis2.portal.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.hisp.dhis.Dhis2;
import org.hisp.dhis.Dhis2Config;
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

	@Value("${dhis2.endpoint.api}")
	private String apiEndpointUrl;
	
	@Value("${dhis2.endpoint.user}")
	private String userEndpointUrl;
	
	@Value("${dhis2.user.name}")
	private String userName;
	
	@Value("${dhis2.user.password}")
	private String userPassword;

	@Value("${dhis2.endpoint.metadata}")
	private String metadataUrl;
	
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
	public URI metadataEndpoint() {
		URI endpoint = null;
		try {
			endpoint = new URI(metadataUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return endpoint;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(userName, userPassword));

		return restTemplate;
	}
	
	@Bean
	public Dhis2 getDhis2() {
        Dhis2Config dhis2Config = new Dhis2Config(apiEndpointUrl, userName, userPassword);
        return new Dhis2(dhis2Config);
	}

}
