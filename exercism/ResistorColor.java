package exercism;

import java.util.Map;

public class ResistorColor {

  public static void main(String[] args) {
    ResistorColor rc = new ResistorColor();

    System.out.println(rc.colorCode("black"));
    System.out.println(rc.colors()[2]);
  }

  Map<String, Integer> map;

  ResistorColor() {
    map = Map.of(
        "black", 0,
        "brown", 1,
        "red", 2,
        "orange", 3,
        "yellow", 4,
        "green", 5,
        "blue", 6,
        "violet", 7,
        "grey", 8,
        "white", 9);
  }

  int colorCode(String color) {
    return map.get(color);
  }

  String[] colors() {
    return map.keySet().stream().sorted((a, b) -> map.get(a).compareTo(map.get(b))).toArray(String[]::new);
  }
}
