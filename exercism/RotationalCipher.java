package exercism;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RotationalCipher {

  private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
  private Map<Character, Character> map = new HashMap<>();

  RotationalCipher(int shiftKey) {
    final int len = alphabet.length();
    final String upperAlphabet = alphabet.toUpperCase();
    IntStream.range(0, len).forEach(i -> {
      map.put(alphabet.charAt(i), alphabet.charAt((i + shiftKey) % len));
      map.put(upperAlphabet.charAt(i), upperAlphabet.charAt((i + shiftKey) % len));
    });
  }

  public static void main(String[] args) {
    RotationalCipher rc = new RotationalCipher(4);
    System.out.println(rc.rotate("omg"));
    System.out.println(rc.rotate("OMG"));
    System.out.println(rc.rotate("Testing 1 2 3 testing"));
  }

  String rotate(String data) {
    Stream<Character> temp = data.chars()
        .mapToObj(i -> map.containsKey((char) i) ? map.get((char) i) : (char) i);

    return temp.map(String::valueOf).collect(Collectors.joining());
  }

}
