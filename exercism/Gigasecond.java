package exercism;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Gigasecond {
  // public static void main(String[] args) {
  //   Gigasecond gigaSecond = new Gigasecond(LocalDate.of(1977, Month.JUNE, 13));
  //   LocalDateTime out = gigaSecond.getDateTime();
  // }

  LocalDate momentDate;
  LocalDateTime momentDateTime;

  public Gigasecond(LocalDate moment) {
    momentDate = moment;
  }

  public Gigasecond(LocalDateTime moment) {
    momentDateTime = moment;
  }

  public LocalDateTime getDateTime() {
    throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
  }
}