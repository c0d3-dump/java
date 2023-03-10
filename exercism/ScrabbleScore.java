package exercism;

public class ScrabbleScore {
  public static void main(String[] args) {

  }
}

class Scrabble {

  private String word;

  Scrabble(String word) {
    this.word = word;
  }

  int getValue(char c) {
    switch (c) {
      case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T':
        return 1;
      case 'D', 'G':
        return 2;
      case 'B', 'C', 'M', 'P':
        return 3;
      case 'F', 'H', 'V', 'W', 'Y':
        return 4;
      case 'K':
        return 5;
      case 'J', 'X':
        return 8;
      case 'Q', 'Z':
        return 10;
      default:
        return 0;
    }
  }

  int getScore() {
    return word.toUpperCase().chars().map(i -> getValue((char) i)).sum();
  }

}
