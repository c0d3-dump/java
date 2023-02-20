package exercism;

import java.util.Arrays;

public class BirdWatcher {
  private final int[] birdsPerDay;

  public BirdWatcher(int[] birdsPerDay) {
    this.birdsPerDay = birdsPerDay.clone();
  }

  public static void main(String[] args) {
    int[] bpd = { 2, 5, 0, 7, 4, 1 };
    BirdWatcher bw = new BirdWatcher(bpd);
    bw.incrementTodaysCount();
    System.out.println(bw.getToday());
    System.out.println(bw.hasDayWithoutBirds());
    System.out.println(bw.getCountForFirstDays(10));
    System.out.println(bw.getBusyDays());
  }

  public int[] getLastWeek() {
    return birdsPerDay;
  }

  public int getToday() {
    return birdsPerDay.length == 0 ? 0 : birdsPerDay[birdsPerDay.length - 1];
  }

  public void incrementTodaysCount() {
    birdsPerDay[birdsPerDay.length - 1] += 1;
  }

  public boolean hasDayWithoutBirds() {
    return Arrays.stream(birdsPerDay).filter(i -> i == 0).findAny().isPresent();
  }

  public int getCountForFirstDays(int numberOfDays) {
    return Arrays.stream(birdsPerDay).limit(numberOfDays).sum();
  }

  public int getBusyDays() {
    return (int) Arrays.stream(birdsPerDay).filter(b -> b >= 5).count();
  }
}