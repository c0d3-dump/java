package exercism;

import java.util.HashSet;
import java.util.Set;

public class RobotName {
  public static void main(String[] args) {
    Robot r = new Robot();
    System.out.println(r.getName().matches("[A-Z]{2}\\d{3}"));
  }
}

class Robot {
  private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private String name;
  private static int charNum1 = 0;
  private static int charNum2 = 0;
  private static int number = 111;

  Robot() {
    this.generate();
  }

  public String getName() {
    return name;
  }

  public void reset() {
    this.generate();
  }

  private void generate() {
    StringBuilder sb = new StringBuilder();

    sb.append(alphabet.charAt(charNum1 % 26));
    sb.append(alphabet.charAt(charNum2 % 26));
    sb.append(String.valueOf(number % 999 + 111));

    name = sb.toString();

    if (charNum1 > 0 && charNum1 % 26 == 0)
      charNum2++;
    charNum1++;
    number++;

  }

}