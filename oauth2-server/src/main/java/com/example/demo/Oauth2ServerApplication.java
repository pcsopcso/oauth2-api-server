package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableAuthorizationServer
@SpringBootApplication
public class Oauth2ServerApplication extends AuthorizationServerConfigurerAdapter {

	//@Autowired
	//ClientDetailsService clientDetailsService;
	
	@Autowired
	TokenStore tokenStore;
	
	@Autowired
	DataSource dataSource;
	
	//@Autowired
	AuthenticationManager authenticationManager;

	public Oauth2ServerApplication(@Lazy AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager);
		configurer.tokenStore(tokenStore);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		String result = bcr.encode("test");  
		System.out.println("암호 === " + result);
		//"$2a$10$Yi7rQ5lpVxNyWPxQXN75vOZeEwFU1pST0Wel3YghW/fsxupFeiKyy"
		//clients.withClientDetails(clientDetailsService);
		clients.jdbc(dataSource);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Oauth2ServerApplication.class, args);
	}
	///////////////////////////////////////////////////////////////////

}