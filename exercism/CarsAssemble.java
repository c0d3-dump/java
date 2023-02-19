package exercism;

public class CarsAssemble {

  public static void main(String[] args) {
    CarsAssemble ca = new CarsAssemble();
    System.out.println(ca.productionRatePerHour(6));
    System.out.println(ca.workingItemsPerMinute(6));
  }

  public double productionRatePerHour(int speed) {
    final int baseProduction = 221;
    double out;
    if (speed < 5) {
      out = speed * baseProduction;
    } else if (speed < 9) {
      out = speed * baseProduction * 0.9;
    } else if (speed < 10) {
      out = speed * baseProduction * 0.8;
    } else {
      out = speed * baseProduction * 0.77;
    }
    return out;
  }

  public int workingItemsPerMinute(int speed) {
    return (int) (this.productionRatePerHour(speed) / 60);
  }
}
