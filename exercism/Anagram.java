package exercism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

  private String word;
  private Map<Character, Integer> map;

  Anagram(String word) {
    this.word = word.toLowerCase();
    map = new HashMap<>();
    this.word.chars().forEach(i -> {
      map.put((char) i, map.getOrDefault((char) i, 0) + 1);
    });
  }

  public List<String> match(List<String> candidates) {

    List<String> out = new ArrayList<>();

    for (String candidate : candidates) {
      if (candidate.toLowerCase().equals(word))
        continue;
      Map<Character, Integer> temp = new HashMap<>();
      candidate.toLowerCase().chars().forEach(i -> {
        temp.put((char) i, temp.getOrDefault((char) i, 0) + 1);
      });

      if (map.equals(temp))
        out.add(candidate);

    }

    return out;
  }

  public static void main(String[] args) {
    Anagram detector = new Anagram("LISTEN");

    System.out.println(detector.match(Arrays.asList("Listen", "Silent", "LISTEN")));
  }

}
