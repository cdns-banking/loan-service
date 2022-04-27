package com.cdns.banking.loan.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.cdns.banking.loan.model.repository.LoanRepository;
import com.cdns.banking.loan.service.LoanService;

/**
 * CarLoan
 * 
 * @author Navya Nidhi Sharma 21068054
 * @version 1.0
 */
@Component
public class CarLoan implements ILoanType
{
	/**
	 * env
	 */
	@Autowired
	Environment env;

	/**
	 * loanService
	 */
	@Autowired
	LoanService loanService;

	/**
	 * loanService
	 */
	@Autowired
	LoanRepository loanRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String openLoanAccount(LoanEntity loan)
	{
		loan.setInterestRate(Float.parseFloat(env.getProperty("loan.interest-rate.car-loan")));
		loan.setInstallmentAmount(
				loan.getLoanAmount() *  loan.getInterestRate() * loan.getLoanPeriod() / 100
		);
		loan.setLoanStatus("Opening");
		loanService.openLoanAccount(loan);
		return "Success";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String closeLoanAccount(LoanEntity loan)
	{
		loan.setLoanStatus("Closed");
		loanService.closeLoanAccount(loan);
		return "Success";
	}
}
