package exercism;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Gigasecond {
  public static void main(String[] args) {
    Gigasecond gigaSecond = new Gigasecond(LocalDate.of(1977, Month.JUNE, 13));
    LocalDateTime out = gigaSecond.getDateTime();

    assert (out == LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40));
  }

  private LocalDateTime moment;

  public Gigasecond(LocalDate moment) {
    this.moment = moment.atTime(0, 0);
  }

  public Gigasecond(LocalDateTime moment) {
    this.moment = moment;
  }

  public LocalDateTime getDateTime() {
    return moment.plusSeconds((long) Math.pow(10, 9));
  }
}