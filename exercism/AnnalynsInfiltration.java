package exercism;

public class AnnalynsInfiltration {
  public static void main(String[] args) {
    final boolean t = AnnalynsInfiltration.canSpy(false, true, false);
    System.out.println(t);
  }

  public static boolean canFastAttack(boolean knightIsAwake) {
    return !knightIsAwake;
  }

  public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
    return knightIsAwake || archerIsAwake || prisonerIsAwake;
  }

  public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
    return prisonerIsAwake && !archerIsAwake;
  }

  public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake,
      boolean petDogIsPresent) {
    if (petDogIsPresent) {
      return !archerIsAwake;
    }
    return prisonerIsAwake && !knightIsAwake && !archerIsAwake;
  }

}
