package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contributor;
import entities.LegalPerson;
import entities.PhisicalPerson;

public class application {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Contributor> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthSpending = sc.nextDouble();
				list.add(new PhisicalPerson(name, annualIncome, healthSpending));
			} else if (ch == 'c'){
				System.out.print("Number of employees: ");
				int employeeNumber = sc.nextInt();
				list.add(new LegalPerson(name, annualIncome, employeeNumber));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for(Contributor cont : list) {
			System.out.println(cont.getName() + ": $ " + String.format("%.2f",cont.CalculateTax()));
		}
		
		double sum = 0;
		for(Contributor cont : list) {
			sum += cont.CalculateTax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f",sum));
				
		sc.close();
	}

}
