package exercism;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FlattenArray {
  public static void main(String[] args) {
    System.out
        .println(Flattener.flatten(Arrays.asList(1, Arrays.asList('2', 3, 4, 5, "six", "7"), null, 8)).toString());
  }
}

class Flattener {
  public static List<Object> flatten(List<Object> input) {
    return input.stream()
        .flatMap(e -> e instanceof List ? Flattener.flatten((List<Object>) e).stream() : Stream.of(e))
        .filter(Objects::nonNull).toList();
  }
}