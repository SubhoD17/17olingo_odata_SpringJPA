package com.subho;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.subho.annotation.processor.MyODataServiceFactory;
import com.subho.entities.VendorODataAgent;

@SpringBootApplication(scanBasePackages = "com.subho")
@EnableJpaRepositories(basePackages = "com.subho")
@EntityScan(basePackages = "com.subho")
@ServletComponentScan(basePackages = "com.subho")
@EnableAsync

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(name = "com.subho.processor.MyODataServiceFactory")
	public ODataServiceFactory getsDataServiceFactory() {
		return new MyODataServiceFactory("com.subho");
	}
	
	@Bean(name = "com.subho.entities.VendorODataAgent")
	public VendorODataAgent vendorODataAgent() {
		return new VendorODataAgent();
	}
}
