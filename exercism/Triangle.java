package exercism;

// cutstom exception
class TriangleException extends Exception {
  public TriangleException() {
    super();
  }
}

public class Triangle {

  private double side1, side2, side3;

  Triangle(double side1, double side2, double side3) throws TriangleException {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;

    if (side1 == 0 && side2 == 0 && side3 == 0)
      throw new TriangleException();

    boolean cond1 = (side1 + side2) < side3;
    boolean cond2 = (side1 + side3) < side2;
    boolean cond3 = (side3 + side2) < side1;

    if (cond1 || cond2 || cond3)
      throw new TriangleException();
  }

  boolean isEquilateral() {
    return (side1 == side2) && (side2 == side3);
  }

  boolean isIsosceles() {
    int count = 0;
    if (side1 == side2)
      count++;
    if (side2 == side3)
      count++;
    if (side1 == side3)
      count++;
    return count >= 1;
  }

  boolean isScalene() {
    return (side1 != side2) && (side2 != side3) && (side1 != side3);
  }

}
