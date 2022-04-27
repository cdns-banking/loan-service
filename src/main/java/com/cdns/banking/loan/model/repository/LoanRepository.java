package com.cdns.banking.loan.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cdns.banking.loan.model.LoanEntity;

/**
 * LoanRepository
 * 
 * @author Navya Nidhi Sharma 21068054
 * @version 1.0
 */
public interface LoanRepository extends CrudRepository<LoanEntity, Integer>
{
	/**
	 * findLoansByAccountID
	 * 
	 * @param accountID {@link String}
	 * @return List<Transaction>
	 */
	List<LoanEntity> findLoansByAccountID(String accountID);
}
