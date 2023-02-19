package exercism;

public class Darts {
  public static void main(String[] args) {
    Darts d = new Darts();
    System.out.println(d.score(-9, -9));
    System.out.println(d.score(0, 10));
    System.out.println(d.score(-5, 0));
    System.out.println(d.score(0, -1));
    System.out.println(d.score(0.1, 0.1));
  }

  int score(double xOfDart, double yOfDart) {
    final double distance = Math.sqrt((xOfDart * xOfDart) + (yOfDart * yOfDart));
    int out;

    if (distance > 10)
      out = 0;
    else if (distance > 5)
      out = 1;
    else if (distance > 1)
      out = 5;
    else
      out = 10;

    return out;
  }
}
