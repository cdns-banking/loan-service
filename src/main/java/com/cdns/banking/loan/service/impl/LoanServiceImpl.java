package com.cdns.banking.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdns.banking.loan.model.LoanEntity;
import com.cdns.banking.loan.model.repository.LoanRepository;
import com.cdns.banking.loan.service.LoanService;

/**
 * LoanServiceImpl
 * 
 * @author Navya Nidhi Sharma 21068054
 * @version 1.0
 */
@Service
public class LoanServiceImpl implements LoanService
{
	/**
	 * loanRepository
	 */
	@Autowired
	LoanRepository loanRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LoanEntity openLoanAccount(LoanEntity loan)
	{
		return loanRepository.save(loan);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LoanEntity closeLoanAccount(LoanEntity loan)
	{
		return loanRepository.save(loan);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LoanEntity> getLoansByAccountID(String accountID)
	{
		return loanRepository.findLoansByAccountID(accountID);
	}

}
