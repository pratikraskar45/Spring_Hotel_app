package com.jsp.hotel_management_system.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class Applicationconfig {
	@Bean
	public Docket getDocket() {
		Contact contact=new Contact("accenture", "www.accenture.com", "accenture@gmail.com");
		List<VendorExtension> list=new ArrayList<>();
		ApiInfo apiInfo=new ApiInfo("hotel_management_system", "hotel app", "hotel vesrion is 1.0", "accenture@gmail.com", 
				contact, "accentute.license", "www.accenture.com", list);
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.basePackage("com.jsp.hotel_management_system"))
				.build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}

}
