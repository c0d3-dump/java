package exercism;

public class ElonsToyCar {
  private int distance = 0;
  private int battery = 100;

  public static void main(String[] args) {
    ElonsToyCar et = ElonsToyCar.buy();
    et.drive();
    et.drive();
    System.out.println(et.distanceDisplay());
    System.out.println(et.batteryDisplay());
  }

  public static ElonsToyCar buy() {
    return new ElonsToyCar();
  }

  public String distanceDisplay() {
    return String.format("Driven %d meters", distance);
  }

  public String batteryDisplay() {
    return battery > 0 ? String.format("Battery at %d%%", battery) : "Battery empty";
  }

  public void drive() {
    if (battery > 0) {
      distance += 20;
      battery -= 1;
    }
  }
}
