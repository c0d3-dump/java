package exercism;

import java.util.ArrayList;
import java.util.List;

public class RemoteControlCompetition {
  public static void main(String[] args) {
    ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
    ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
    prc1.setNumberOfVictories(3);
    prc2.setNumberOfVictories(2);
    List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(prc1, prc2);

    if (rankings.get(1) == prc1) {
      System.out.println("oh");
    }
  }
}

interface RemoteControlCar {
  void drive();

  int getDistanceTravelled();
}

class ExperimentalRemoteControlCar implements RemoteControlCar {
  private int distance = 0;

  @Override
  public void drive() {
    distance += 20;
  }

  @Override
  public int getDistanceTravelled() {
    return distance;
  }

}

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
  private int numberofVictories;
  private int distance = 0;

  @Override
  public void drive() {
    distance += 10;
  }

  @Override
  public int getDistanceTravelled() {
    return distance;
  }

  public int getNumberOfVictories() {
    return numberofVictories;
  }

  public void setNumberOfVictories(int numberofVictories) {
    this.numberofVictories = numberofVictories;
  }

  @Override
  public int compareTo(ProductionRemoteControlCar car) {
    return numberofVictories - car.getNumberOfVictories();
  }

}

class TestTrack {
  public static void race(RemoteControlCar car) {
    car.drive();
  }

  public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
      ProductionRemoteControlCar prc2) {
    List<ProductionRemoteControlCar> list = new ArrayList<>(List.of(prc1, prc2));
    list.sort(null);
    return list;
  }
}