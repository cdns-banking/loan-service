package com.cdns.banking.loan.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.cdns.banking.loan.model.repository.LoanRepository;
import com.cdns.banking.loan.service.LoanService;

/**
 * EducationLoan
 * 
 * @author Navya Nidhi Sharma 21068054
 * @version 1.0
 */
@Component
public class EducationLoan implements ILoanType
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
		loan.setInterestRate(Float.parseFloat(env.getProperty("loan.interest-rate.education-loan")));
		loan.setInstallmentAmount(
				loan.getLoanAmount() * (1 + loan.getInterestRate() * (loan.getLoanPeriod() / 365))
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
