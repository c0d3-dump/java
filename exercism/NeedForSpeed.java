package exercism;

public class NeedForSpeed {
  private int speed;
  private int batteryDrain;
  private int distanceCovered = 0;
  private int batteryRemained = 100;

  public NeedForSpeed(int speed, int batteryDrain) {
    this.speed = speed;
    this.batteryDrain = batteryDrain;
  }

  public static void main(String[] args) {
    int speed = 5;
    int batteryDrain = 2;
    var car = new NeedForSpeed(speed, batteryDrain);

    int distance = 100;
    var race = new RaceTrack(distance);

    System.out.println(race.tryFinishTrack(car));

    System.out.println(car.distanceDriven());

  }

  public boolean batteryDrained() {
    return batteryRemained <= 0;
  }

  public int distanceDriven() {
    return distanceCovered;
  }

  public void drive() {
    if (batteryRemained > 0) {
      distanceCovered += speed;
      batteryRemained -= batteryDrain;
    }
  }

  public static NeedForSpeed nitro() {
    return new NeedForSpeed(50, 4);
  }
}

class RaceTrack {
  private int distance;

  RaceTrack(int distance) {
    this.distance = distance;
  }

  public boolean tryFinishTrack(NeedForSpeed car) {
    while (!car.batteryDrained() && distance > car.distanceDriven()) {
      car.drive();
    }
    return car.distanceDriven() >= distance;
  }
}
