package exercism;

public class SalaryCalculator {
  public static void main(String[] args) {
    int daysSkipped = 2;
    int productsSold = 3;
    SalaryCalculator sc = new SalaryCalculator();

    System.out.println(sc.finalSalary(daysSkipped, productsSold));
  }

  public double multiplierPerDaysSkipped(int daysSkipped) {
    return daysSkipped > 5 ? 0.85 : 1.0;
  }

  public int multiplierPerProductsSold(int productsSold) {
    return productsSold > 20 ? 13 : 10;
  }

  public double bonusForProductSold(int productsSold) {
    return productsSold * this.multiplierPerProductsSold(productsSold);
  }

  public double finalSalary(int daysSkipped, int productsSold) {
    return Math.min(2000,
        (1000 * this.multiplierPerDaysSkipped(daysSkipped)) + this.bonusForProductSold(productsSold));
  }
}
