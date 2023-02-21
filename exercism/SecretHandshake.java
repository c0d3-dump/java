package exercism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretHandshake {
  public static void main(String[] args) {
    HandshakeCalculator hc = new HandshakeCalculator();
    hc.calculateHandshake(8);
  }
}

enum Signal {
  WINK,
  DOUBLE_BLINK,
  CLOSE_YOUR_EYES,
  JUMP
}

class HandshakeCalculator {

  List<Signal> calculateHandshake(int number) {
    List<Signal> list = new ArrayList<Signal>();
    int count = 0;

    while (count < 5) {
      final int temp = number >> 1;
      if (temp << 1 != number) {
        switch (count) {
          case 0:
            list.add(Signal.WINK);
            break;
          case 1:
            list.add(Signal.DOUBLE_BLINK);
            break;
          case 2:
            list.add(Signal.CLOSE_YOUR_EYES);
            break;
          case 3:
            list.add(Signal.JUMP);
            break;
          case 4:
            Collections.reverse(list);
            break;
        }
      }

      count++;
      number = temp;
    }
    return list;
  }

}
