package exercism;

public class SqueakyClean {
  public static void main(String[] args) {
    System.out.println(SqueakyClean.clean(" my \0 id à-ḃç a-1bc a1😀2😀3😀b MyΟβιεγτFinder"));
  }

  static String clean(String identifier) {
    StringBuilder sb = new StringBuilder();
    boolean flag = false;

    for (int i : identifier.codePoints().toArray()) {
      if (Character.isISOControl(i))
        sb.append("CTRL");
      else if (Character.toChars(i)[0] == ' ')
        sb.append('_');
      else if (Character.toChars(i)[0] == '-')
        flag = true;
      else {
        if (Character.isLetter(i) && !(i >= 945 && i <= 969)) {
          if (flag) {
            sb.appendCodePoint(Character.toUpperCase(i));
            flag = false;
          } else {
            sb.appendCodePoint(i);
          }
        }
      }
    }

    return sb.toString();
  }
}