package exercism;

import java.util.HashMap;
import java.util.Map;

public class Raindrops {
  public static void main(String[] args) {
    RaindropConverter rc = new RaindropConverter();
    System.out.println(rc.convert(28));
    System.out.println(rc.convert(30));
    System.out.println(rc.convert(34));
  }
}

class RaindropConverter {
  private final Map<Integer, String> map = new HashMap<Integer, String>(
      Map.of(3, "Pling", 5, "Plang", 7, "Plong"));

  String convert(int number) {
    StringBuilder sb = new StringBuilder();

    map.forEach((key, val) -> {
      if (number % key == 0) {
        sb.append(val);
      }
    });

    return sb.length() > 0 ? sb.toString() : String.valueOf(number);
  }
}
