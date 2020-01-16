package entities;

public class PhisicalPerson extends Contributor {

	private double healthSpending;

	public PhisicalPerson() {
		super();
	}

	public PhisicalPerson(String name, double annualIncome, double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public double CalculateTax() {
		double tax;
		if (getAnnualIncome() < 20000) {
			tax = getAnnualIncome() * 0.15 - healthSpending * 0.5;
		} else {
			tax = getAnnualIncome() * 0.25 - healthSpending * 0.5;
		}
		return tax;
	}
	
	
}
