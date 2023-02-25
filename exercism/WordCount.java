package exercism;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {

  public static void main(String[] args) {
    WordCount wc = new WordCount();

    System.out.println(wc.phrase("Joe can't tell between 'large' and large."));
  }

  public Map<String, Integer> phrase(String input) {
    Map<String, Integer> out = new HashMap<>();

    StringBuilder temp = new StringBuilder();

    int[] arr = input.toLowerCase().chars().toArray();
    int len = arr.length;

    for (int i = 0; i < len; i++) {
      int t = arr[i];
      if (Character.isLetterOrDigit(t)) {
        temp.appendCodePoint(t);
      } else if (Character.toString(t).matches("'")) {
        if (Character.isLetterOrDigit(arr[i - 1]) && (i + 1 < len && Character.isLetterOrDigit(arr[i + 1]))) {
          temp.appendCodePoint(t);
        }
      } else if (i > 0 && (Character.isLetterOrDigit(arr[i - 1]) || Character.toString(arr[i - 1]).matches("'"))
          && !Character.isLetterOrDigit(t)) {
        temp.append("-");
      }
    }

    Arrays.stream(temp.toString().split("-")).forEach(i -> {
      if (i != " ") {
        if (out.containsKey(i))
          out.put(i, out.get(i) + 1);
        else
          out.put(i, 1);
      }
    });

    return out;
  }
}
