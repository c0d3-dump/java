package exercism.exercises;

import java.util.HashMap;
import java.util.Map;

public class PlayYourCards {
  public static void main(String[] args) {
    Blackjack bj = new Blackjack();
    System.out.println(bj.parseCard("ace"));
    System.out.println(bj.parseCard("king"));

    System.out.println(bj.isBlackjack("ace", "queen"));
  }
}

class Blackjack {
  public int parseCard(String card) {
    final Map<String, Integer> map = new HashMap<>();
    map.put("ace", 11);
    map.put("two", 2);
    map.put("three", 3);
    map.put("four", 4);
    map.put("five", 5);
    map.put("six", 6);
    map.put("seven", 7);
    map.put("eight", 8);
    map.put("nine", 9);
    map.put("ten", 10);
    map.put("jack", 10);
    map.put("queen", 10);
    map.put("king", 10);
    map.put("other", 0);
    return map.get(card);
  }

  public boolean isBlackjack(String card1, String card2) {
    return this.parseCard(card1) + this.parseCard(card2) == 21;
  }

  public String largeHand(boolean isBlackjack, int dealerScore) {
    if (!isBlackjack)
      return "P";
    return dealerScore < 10 ? "W" : "S";
  }

  public String smallHand(int handScore, int dealerScore) {
    if (handScore >= 17)
      return "S";
    if (handScore <= 11)
      return "H";
    return dealerScore >= 7 ? "H" : "S";
  }

  // FirstTurn returns the semi-optimal decision for the first turn, given the
  // cards of the player and the dealer.
  // This function is already implemented and does not need to be edited. It pulls
  // the other functions together in a
  // complete decision tree for the first turn.
  public String firstTurn(String card1, String card2, String dealerCard) {
    int handScore = parseCard(card1) + parseCard(card2);
    int dealerScore = parseCard(dealerCard);

    if (20 < handScore) {
      return largeHand(isBlackjack(card1, card2), dealerScore);
    } else {
      return smallHand(handScore, dealerScore);
    }
  }
}
