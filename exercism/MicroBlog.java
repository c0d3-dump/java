package exercism.exercises;

public class MicroBlog {
  public static void main(String[] args) {
    MicroBlog mb = new MicroBlog();
    final String out = mb.truncate("❄🌡🤧🤒🏥");
    System.out.println(out);
  }

  public String truncate(String input) {
    StringBuilder out = new StringBuilder();

    input.codePoints().limit(5).forEach(i -> out.appendCodePoint(i));
    return out.toString();
  }
}
