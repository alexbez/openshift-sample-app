package com.openshift.hcp;

import java.io.Serializable;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountNumberGenerator implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final int MAX_ACCOUNT_NUMBERS = 5;
	private static final Logger LOGGER = Logger.getLogger( "AccountNumberGenerator" );

	{
		accountNumbers= generateAccountNumbers();
	}
	
	private String[] accountNumbers;
	
	
	public String[] getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(String[] accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
	public String[] generateAccountNumbers() {
		LOGGER.log(Level.INFO, "Entering generateAccountNumbers()...");
		String[] accountPrefixes = {"AAA","BBB","CCC","DDD"};
		accountNumbers = new String[MAX_ACCOUNT_NUMBERS];
		for (int i=0; i<MAX_ACCOUNT_NUMBERS; i++) {
			String accountNumberPrefix = accountPrefixes[new Random().nextInt(accountPrefixes.length)];
			int accountNumberSuffix = 1000000 + new Random().nextInt(9000000); 
			accountNumbers[i] = new String(accountNumberPrefix + "-" + accountNumberSuffix);
		}
		return accountNumbers;
	}	
}
