package com.cdns.banking.loan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.cdns.banking.loan.controller.LoanController;
import com.cdns.banking.loan.model.LoanEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * loanServiceApplicationTests
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoanServiceApplicationTests
{
	@LocalServerPort
	private int port;

	@Autowired
	LoanController controller;

	@Autowired
	Environment env;

	@Autowired
	TestRestTemplate restTemplate;

	/**
	 * testOpenloan
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOpenloan() throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ObjectMapper Obj = new ObjectMapper();

		LoanEntity loanEntity = openloanEntityObject();

		JSONObject loanJsonObject = new JSONObject(Obj.writeValueAsString(loanEntity));

		HttpEntity<String> loanRequest = new HttpEntity<String>(loanJsonObject.toString(), headers);

		assertThat(
				this.restTemplate.postForObject(
						env.getProperty("test.loan.url") + port + "/loan", loanRequest, String.class
				)
		).contains("Success");

	}

	/**
	 * testViewloan
	 * 
	 * @throws Exception
	 */
	@Test
	public void testViewloan() throws Exception
	{
		assertThat(
				this.restTemplate.getForObject(
						env.getProperty("test.loan.url") + port + "/loan/D713684F-00FC-4289-810D-049FF27F496C",
						String.class
				)
		).contains("D713684F-00FC-4289-810D-049FF27F496C");
	}

	/**
	 * openloanEntityObject
	 * 
	 * @return {@link LoanEntity}
	 */
	private LoanEntity openloanEntityObject()
	{
		LoanEntity loanEntity = new LoanEntity();
		loanEntity.setAccountID("D713684F-00FC-4289-810D-049FF27F496C");
		loanEntity.setLoanAmount(1000);
		loanEntity.setLoanStatus("Opening");
		loanEntity.setLoanType("fixed");
		loanEntity.setInterestRate(6);
		loanEntity.setInstallmentAmount(1991);
		loanEntity.setLoanTime("2021-11-28");
		return loanEntity;
	}
}
