package exercism;

public class Isogram {

  public static void main(String[] args) {
    IsogramChecker ic = new IsogramChecker();

    System.out.println(ic.isIsogram("lumberjacks"));
    System.out.println(ic.isIsogram("Emily Jung Schwartzkopf"));
    System.out.println(ic.isIsogram("Alphabet"));
    System.out.println(ic.isIsogram("isisograms"));
  }

}

class IsogramChecker {

  boolean isIsogram(String phrase) {
    String temp = phrase.replaceAll("[-\\s]", "").toLowerCase();
    return temp.chars().distinct().count() == temp.length();
  }

}
