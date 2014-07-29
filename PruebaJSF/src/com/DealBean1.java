package com;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DealBean1 {

	private String accountId, countString;
	private int count;

	public String getCountString() {
		return (countString);
	}

	public void setCountString(String countString) {
		try {
			count = Math.abs(Integer.parseInt(countString));
			this.countString = countString;
		} catch (NumberFormatException | NullPointerException e) {
			// Keep default values (count=0, countString=null)
		}
	}

	public int getCount() {
		return (count);
	}

	private Account account;

	private static AccountLookupService lookupService = new AccountSimpleMap();

	public Account getAccount() {
		return (account);
	}

	public String buyDailyDeal() {
		if (FormUtils.isAnyMissing(accountId, countString)) {
		return("deal-error-1");
		}
		account = lookupService.findAccount(accountId);
		if (account == null) {
		return("deal-bad-id-1");
		}
		if (account.getBalance() < getPurchaseAmount()) {
		return("deal-insufficient-balance-1");
		}
		account.setBalance(account.getBalance() –
		getPurchaseAmount());
		return("deal-success-1");
		}
	
	
}
