package com;

public interface AccountSimpleMap {
	
	implements AccountLookupService {
		
	}
		private Map<String,Account> accounts;
		public AccountSimpleMap() {
		accounts = new HashMap<>();
		addAccount(new Account("a1234", "Bill", "Gates", 1000));
		}
		
		@Override
		public Account findAccount(String id) {
		if (id != null) {
		return(accounts.get(id.toLowerCase()));
		} else {
		return(null);
		}

}
