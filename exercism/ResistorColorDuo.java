package exercism;

import java.util.Map;

public class ResistorColorDuo {

  Map<String, Integer> map;

  ResistorColorDuo() {
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

  int value(String[] colors) {
    return map.get(colors[0]) * 10 + map.get(colors[1]);
  }
}
