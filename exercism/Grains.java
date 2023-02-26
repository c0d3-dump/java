package exercism;

import java.math.BigInteger;

public class Grains {
  public static void main(String[] args) {
    Grains g = new Grains();
    System.out.println(g.grainsOnSquare(64));
    System.out.println(g.grainsOnBoard());
  }

  BigInteger grainsOnSquare(final int square) {

    if (square < 1 || square > 64)
      throw new IllegalArgumentException("square must be between 1 and 64");

    StringBuilder sb = new StringBuilder("1");

    for (int i = 1; i < square; i++) {
      StringBuilder temp = new StringBuilder("");
      int reminder = 0;

      for (char c : sb.reverse().toString().toCharArray()) {
        int num = Integer.parseInt(String.valueOf(c));

        int mul = (num * 2) + reminder;
        reminder = (mul - mul % 10) / 10;

        temp.append(String.valueOf(mul % 10));
      }

      if (reminder > 0)
        temp.append(String.valueOf(reminder));

      sb = new StringBuilder(temp.reverse().toString());
    }

    return new BigInteger(sb.toString());
  }

  BigInteger grainsOnBoard() {
    BigInteger totalGrains = new BigInteger("0");
    for (int i = 1; i <= 64; i++) {
      totalGrains = totalGrains.add(grainsOnSquare(i));
    }
    return totalGrains;
  }

}
