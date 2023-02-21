package exercism;

public class WizardsAndWarriors {
  public static void main(String[] args) {

  }
}

abstract class Fighter {

  boolean isVulnerable() {
    return false;
  }

  abstract int damagePoints(Fighter fighter);

  public abstract String toString();

  public String toString(String type) {
    return String.format("Fighter is a %s", type);
  }

}

class Warrior extends Fighter {

  @Override
  public String toString() {
    return super.toString("Warrior");
  }

  @Override
  int damagePoints(Fighter wizard) {
    return wizard.isVulnerable() ? 10 : 6;
  }
}

class Wizard extends Fighter {

  private boolean isSpellPrepared = false;

  @Override
  public String toString() {
    return super.toString("Wizard");
  }

  @Override
  boolean isVulnerable() {
    return !isSpellPrepared;
  }

  @Override
  int damagePoints(Fighter warrior) {
    return isSpellPrepared ? 12 : 3;
  }

  void prepareSpell() {
    isSpellPrepared = true;
  }

}
