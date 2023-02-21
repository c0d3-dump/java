package exercism;

import java.util.stream.IntStream;

public class Hamming {
  private String leftStrand;
  private String rightStrand;

  public Hamming(String leftStrand, String rightStrand) {
    if (leftStrand.length() != rightStrand.length()) {
      if (leftStrand.length() == 0)
        throw new IllegalArgumentException("left strand must not be empty.");
      else if (rightStrand.length() == 0)
        throw new IllegalArgumentException("right strand must not be empty.");
      else
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
  }

  public static void main(String[] args) {
    Hamming hm = new Hamming("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT");
    System.out.println(hm.getHammingDistance());
  }

  public int getHammingDistance() {
    return IntStream.range(0, leftStrand.length()).reduce(0,
        (hamCount, i) -> hamCount + (leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0));
  }
}
