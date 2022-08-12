public class salesBonusCalculator {
	public static void main(String[] args) {
		double sales = Double.valueOf(args[0]);
		boolean isTeam = Integer.valueOf(args[1]) == 1 ? true : false;
		double commission;
		double salaryWithBonus = 0;
		double baseSalary = 9000;
		double tenThousand = Math.exp(5);
		if (isTeam == true) {
			if (sales >= 9 * tenThousand) {
				commission = 0.8 / 100 * sales;
			} else if ((sales >= 5 * tenThousand) && (sales < 9 * tenThousand)) {
				commission = 0.5 / 100 * sales;
			} else if (sales < 5 * tenThousand) {
				commission = 0.2 / 100 * sales;
			} else {
				// Below 0
				commission = 0;
			}
		} else {
			commission = .05 * sales;
		}
		salaryWithBonus = baseSalary + commission;

		System.out.println(Integer.valueOf(args[1]));
		System.out.println("Salary with Bonus : " + salaryWithBonus);
		System.out.println("=====================================");
		System.out.println("Sales is : " + sales);
		System.out.println("Commission is : " + commission);
		System.out.println("Base Salary is : " + baseSalary);
	}
}