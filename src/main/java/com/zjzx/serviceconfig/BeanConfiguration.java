package com.zjzx.serviceconfig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.jfinal.aop.Duang;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.zjzx.service.CompanyauthService;
import com.zjzx.service.PersionauthService;

@Configuration
public class BeanConfiguration {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	@Bean
	public CompanyauthService companyauthService() {
		return Duang.duang(CompanyauthService.class, Tx.class);
	}
	@Bean
	public PersionauthService persionauthService() {
		return Duang.duang(PersionauthService.class, Tx.class);
	}
	

}
