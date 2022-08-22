package SalesBonusWithUI;

public class Logic {
    double sales; 
    boolean isTeam;
    double commission;

    double salaryWithBonus = 0;
    double baseSalary = 9000;

    public Logic(double sales, boolean isTeam) {
        this.sales = sales;
        this.isTeam = isTeam;
    }

    public void calculateCommission () {
        double tenThousand = Math.exp(5);

        if (this.isTeam == true) {
            if (this.sales >= 9 * tenThousand) {
                this.commission = 0.8 / 100 * this.sales;
            } else if ((this.sales >= 5 * tenThousand) && (this.sales < 9 * tenThousand)) {
                this.commission = 0.5 / 100 * this.sales;
            } else if (this.sales < 5 * tenThousand) {
                this.commission = 0.2 / 100 * this.sales;
            } else {
                // Below 0
                this.commission = 0;
            }
        } else {
            this.commission = .05 * this.sales;
        }
    }
}
