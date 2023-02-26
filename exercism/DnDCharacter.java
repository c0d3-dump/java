package exercism;

import java.util.List;
import java.util.Random;

public class DnDCharacter {

  private int strength;
  private int dexercity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  DnDCharacter() {
    strength = getRandomDiceValue();
    dexercity = getRandomDiceValue();
    constitution = getRandomDiceValue();
    intelligence = getRandomDiceValue();
    wisdom = getRandomDiceValue();
    charisma = getRandomDiceValue();
  }

  int ability(List<Integer> scores) {
    return scores.stream().mapToInt(Integer::intValue).sum()
        - scores.stream().mapToInt(Integer::intValue).min().getAsInt();
  }

  List<Integer> rollDice() {
    Random rnd = new Random();
    return rnd.ints(4, 1, 7).boxed().toList();
  }

  int modifier(int input) {
    return Math.floorDiv(input - 10, 2);
  }

  int getRandomDiceValue() {
    return ability(rollDice());
  }

  int getStrength() {
    return strength;
  }

  int getDexterity() {
    return dexercity;
  }

  int getConstitution() {
    return constitution;
  }

  int getIntelligence() {
    return intelligence;
  }

  int getWisdom() {
    return wisdom;
  }

  int getCharisma() {
    return charisma;
  }

  int getHitpoints() {
    return 10 + modifier(getConstitution());
  }
}
