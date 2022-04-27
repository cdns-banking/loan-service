package com.cdns.banking.loan;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * LoanServiceApplication
 * 
 * @author Navya Sharma 21068054
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class LoanServiceApplication
{
	/**
	 * main
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(LoanServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cdns.banking.loan")).build()
				.apiInfo(getAPIInfo());
	}

	private ApiInfo getAPIInfo() {
		return new ApiInfo("CDNS Banking Loan Service APIs",
				"Documentation of APIs provided by the microservice loan-service", "1.0", "Free to use", null,
				"API License", null, Collections.emptyList());
	}

}

