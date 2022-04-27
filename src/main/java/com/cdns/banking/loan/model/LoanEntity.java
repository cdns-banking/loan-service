package com.cdns.banking.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_loans")
public class LoanEntity
{
	/**
	 * requestID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "loan_id_seq", allocationSize = 1)
	@Column(name = "loan_id", nullable = false, unique = true)
	private int loanID;

	/**
	 * accountID
	 */
	@Column(name = "account_id", nullable = false, length = 64)
	private String accountID;

	/**
	 * loanType
	 */
	@Column(name = "loan_type", nullable = false, length = 32)
	private String loanType;

	/**
	 * loanAmount
	 */
	@Column(name = "loan_amount", nullable = false)
	private float loanAmount;

	/**
	 * loanTime
	 */
	@Column(name = "loan_time", nullable = false, length = 32)
	private String loanTime;

	/**
	 * loanPeroid
	 */
	@Column(name = "loan_period", nullable = false)
	private int loanPeriod;

	/**
	 * interestRate
	 */
	@Column(name = "interest_rate", nullable = false)
	private float interestRate;

	/**
	 * installmentAmount
	 */
	@Column(name = "installment_amount", nullable = false)
	private float installmentAmount;

	/**
	 * loanStatus
	 */
	@Column(name = "loan_status", nullable = false, length = 16)
	private String loanStatus;

	/**
	 * getLoanID
	 * 
	 * @return loanID {@link Integer}
	 */
	public int getLoanID()
	{
		return loanID;
	}

	/**
	 * setLoanID
	 * 
	 * @param loanID {@link Integer}
	 */
	public void setLoanID(int loanID)
	{
		this.loanID = loanID;
	}

	/**
	 * getAccountID
	 * 
	 * @return accountID {@link String}
	 */
	public String getAccountID()
	{
		return accountID;
	}

	/**
	 * setAccountID
	 * 
	 * @param accountID {@link String}
	 */
	public void setAccountID(String accountID)
	{
		this.accountID = accountID;
	}

	/**
	 * getLoanPeriod
	 * 
	 * @return loanPeriod {@link Integer}
	 */
	public int getLoanPeriod()
	{
		return loanPeriod;
	}

	/**
	 * setLoanPeriod
	 * 
	 * @param loanPeriod {@link Integer}
	 */
	public void setLoanPeriod(int loanPeriod)
	{
		this.loanPeriod = loanPeriod;
	}

	/**
	 * getLoanType
	 * 
	 * @return loanType {@link String}
	 */
	public String getLoanType()
	{
		return loanType;
	}

	/**
	 * setLoanType
	 * 
	 * @param loanType {@link String}
	 */
	public void setLoanType(String loanType)
	{
		this.loanType = loanType;
	}

	/**
	 * getLoanTime
	 * 
	 * @return loanTime {@link String}
	 */
	public String getLoanTime()
	{
		return loanTime;
	}

	/**
	 * setLoanTime
	 * 
	 * @param loanTime {@link String}
	 */
	public void setLoanTime(String loanTime)
	{
		this.loanTime = loanTime;
	}

	/**
	 * setLoanPeroid
	 * 
	 * @param loanPeroid {@link Integer}
	 */
	public void setLoanPeroid(int loanPeriod)
	{
		this.loanPeriod = loanPeriod;
	}

	/**
	 * getLoanAmount
	 * 
	 * @return loanAmount {@link Integer}
	 */
	public float getLoanAmount()
	{
		return loanAmount;
	}

	/**
	 * setLoanAmount
	 * 
	 * @param loanAmount {@link Integer}
	 */
	public void setLoanAmount(float loanAmount)
	{
		this.loanAmount = loanAmount;
	}

	/**
	 * getInterestRate
	 * 
	 * @return interestRate {@link Integer}
	 */
	public float getInterestRate()
	{
		return interestRate;
	}

	/**
	 * setInterestRate
	 * 
	 * @param interestRate {@link Integer}
	 */
	public void setInterestRate(float interestRate)
	{
		this.interestRate = interestRate;
	}

	/**
	 * getMaturityAmount
	 * 
	 * @return maturityAmount {@link Integer}
	 */
	public float getInstallmentAmount()
	{
		return installmentAmount;
	}

	/**
	 * setInstallmentAmount
	 * 
	 * @param installmentAmount {@link Integer}
	 */
	public void setInstallmentAmount(float installmentAmount)
	{
		this.installmentAmount = installmentAmount;
	}

	/**
	 * getLoanStatus
	 * 
	 * @return loanStatus {@link String}
	 */
	public String getLoanStatus()
	{
		return loanStatus;
	}

	/**
	 * setLoanStatus
	 * 
	 * @param loanStatus {@link String}
	 */
	public void setLoanStatus(String loanStatus)
	{
		this.loanStatus = loanStatus;
	}
}
