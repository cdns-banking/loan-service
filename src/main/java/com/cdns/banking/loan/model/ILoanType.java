package com.cdns.banking.loan.model;

/**
 * ITransactionType
 * 
 * @author Deepu Prasad Mathew 21017956
 * @version 1.0
 */
public interface ILoanType
{
	/**
	 * openDeposit
	 * 
	 * @param transaction {@link Transaction}
	 * @return {@link String}
	 */
	public String openLoanAccount(LoanEntity loan);

	/**
	 * openDeposit
	 * 
	 * @param transaction {@link Transaction}
	 * @return {@link String}
	 */
	public String closeLoanAccount(LoanEntity loan);
}
