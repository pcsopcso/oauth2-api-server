package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@EnableResourceServer
@SpringBootApplication
public class ApiServerApplication extends ResourceServerConfigurerAdapter{

	private static final String RESOURCE_ID = "resource";
	
	@Override 
    public void configure(HttpSecurity http) throws Exception {
         // @formatter:off
         http
         .requestMatchers().antMatchers("/users", "/users/**")    
         .and()
         .authorizeRequests().anyRequest().access("#oauth2.hasScope('read')");
         // @formatter:on
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(ApiServerApplication.RESOURCE_ID);
    }
    	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() { 
	    RemoteTokenServices tokenService = new RemoteTokenServices();
	    tokenService.setCheckTokenEndpointUrl(
	      "http://localhost:8080/oauth/check_token");
	    tokenService.setClientId("acme");
	    tokenService.setClientSecret("test");
	    return tokenService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiServerApplication.class, args);
	}
}