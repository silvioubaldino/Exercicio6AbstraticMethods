package entities;

public class LegalPerson extends Contributor{

	private int employeeNumber;

	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, double annualIncome, int employeeNumber) {
		super(name, annualIncome);
		this.employeeNumber = employeeNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public double CalculateTax() {
		double tax;
		if(employeeNumber < 10) {
			tax = getAnnualIncome() * 0.16;
		} else {
			tax = getAnnualIncome() * 0.14;
		}
		return tax;
	}
	
	
	
}
