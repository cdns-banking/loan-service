package com.cdns.banking.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdns.banking.loan.model.ILoanType;
import com.cdns.banking.loan.model.LoanEntity;
import com.cdns.banking.loan.model.factory.LoanTypeFactory;
import com.cdns.banking.loan.service.LoanService;

/**
 * LoanController
 * 
 * @author Navya Nidhi Sharma 21068054
 * @version 1.0
 */
@RestController
public class LoanController
{
	/**
	 * loanService
	 */
	@Autowired
	LoanService loanService;

	/**
	 * 
	 */
	@Autowired
	LoanTypeFactory loanTypeFactory;

	/**
	 * openLoan Account
	 * 
	 * @param loanEntity {@link LoanEntity}
	 * @return {@link String}
	 */
	@PostMapping("/loan")
	public String openLoanAccount(@RequestBody LoanEntity loanEntity)
	{
		ILoanType loanType = loanTypeFactory.getInstance(loanEntity.getLoanType());
		return loanType.openLoanAccount(loanEntity);
	}

	/**
	 * closeLoanAccount
	 * 
	 * @param loanEntity {@link LoanEntity}
	 * @return {@link String}
	 */
	@DeleteMapping("/loan")
	public String closeLoanAccount(@RequestBody LoanEntity loanEntity)
	{
		ILoanType loanType = loanTypeFactory.getInstance(loanEntity.getLoanType());
		return loanType.closeLoanAccount(loanEntity);
	}

	/**
	 * viewLoans
	 * 
	 * @param accountID {@link String}
	 * @return List<LoanEntity>
	 */
	@GetMapping("/Loan/{accountID}")
	public List<LoanEntity> viewLoans(@PathVariable String accountID)
	{
		return loanService.getLoansByAccountID(accountID);
	}
}
