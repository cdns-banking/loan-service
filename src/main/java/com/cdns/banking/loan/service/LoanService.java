package com.cdns.banking.loan.service;

import java.util.List;

import com.cdns.banking.loan.model.LoanEntity;

/**
 * LoanService
 * 
 * @author Navya Nidhi Sharma 21068054
 * @version 1.0
 */
public interface LoanService
{
	
	public LoanEntity openLoanAccount(LoanEntity transaction);

	public LoanEntity closeLoanAccount(LoanEntity transaction);

	public List<LoanEntity> getLoansByAccountID(String accountID);
}
