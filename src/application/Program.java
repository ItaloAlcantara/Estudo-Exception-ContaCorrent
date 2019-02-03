package application;

import java.util.Scanner;

import model.exceptions.DomainException;
import module.entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		try {
		System.out.println("Enter account date");
		System.out.print("Numer: ");
		int number = s.nextInt();
		System.out.print("Holder: ");
		s.nextLine();
		String holder =s.nextLine();
		System.out.println("Initial Balance:");
		double balance=s.nextDouble();
		System.out.println("Withdraw limit: ");
		double withdrawLimit = s.nextDouble();
		
		Account c = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println("Enter amout for withdraw");
		c.withdraw(s.nextDouble());
		System.out.println(c);
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}

	}

}
