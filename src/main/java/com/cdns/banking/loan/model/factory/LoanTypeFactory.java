package com.cdns.banking.loan.model.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdns.banking.loan.model.CarLoan;
import com.cdns.banking.loan.model.EducationLoan;
import com.cdns.banking.loan.model.HousingLoan;
import com.cdns.banking.loan.model.ILoanType;

/**
 * LoanTypeFactory
 * 
 * @author Navya Nidhi Sharma 21068054
 * @version 1.0
 */
@Component
public class LoanTypeFactory
{
	/**
	 * loanType
	 */
	private static ILoanType loanType;

	/**
	 * housing loan
	 */
	@Autowired
	private HousingLoan housingLoan;

	/**
	 * educationLoan
	 */
	@Autowired
	private EducationLoan educationLoan;

	/**
	 * carLoan
	 */
	@Autowired
	private CarLoan carLoan;

	/**
	 * getInstance
	 * 
	 * @param loanType {@link String}
	 * @return {@link LoanFactory}
	 */
	public ILoanType getInstance(String loanType)
	{

		if ("housing".equals(loanType))
		{
			this.loanType = housingLoan;
		}
		else if ("education".equals(loanType))
		{
			this.loanType = educationLoan;
		}
		else if ("car".equals(loanType))
		{
			this.loanType = carLoan;
		}
		return this.loanType;
	}
}
