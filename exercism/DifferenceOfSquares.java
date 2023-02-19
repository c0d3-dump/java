package exercism;

public class DifferenceOfSquares {
  public static void main(String[] args) {
    DifferenceOfSquaresCalculator dc = new DifferenceOfSquaresCalculator();

    System.out.println(dc.computeDifferenceOfSquares(10));
  }
}

class DifferenceOfSquaresCalculator {

  int computeSquareOfSumTo(int input) {
    return (int) Math.pow((input * (input + 1)) / 2, 2);
  }

  int computeSumOfSquaresTo(int input) {
    return (input * (input + 1) * (2 * input + 1)) / 6;
  }

  int computeDifferenceOfSquares(int input) {
    return this.computeSquareOfSumTo(input) - this.computeSumOfSquaresTo(input);
  }

}
