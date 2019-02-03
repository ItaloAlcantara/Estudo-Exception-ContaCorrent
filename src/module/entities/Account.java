package module.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		if(balance<0 || withdrawLimit<0) {
			throw new DomainException("Error : Values of balance or withdraw limit can't be less zero");
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(double deposit) {
		if(deposit<=0) {
			throw new DomainException("Error Deposit: Value can't be less than zero or zero");
		}
		balance+=deposit;
	}
	
	public void withdraw(double withdraw) {
		if(withdraw >withdrawLimit) {
			throw new DomainException("Error withdraw: Value can'be acepted because is bigger then withdraw limit");
		}
		if(withdraw>balance) {
			throw new DomainException("Error Withdraw: Not enough balance");
		}
		balance-=withdraw;
	}
	
	@Override
	public String toString() {
		
		return "New balance: "+getBalance();
	}
}
