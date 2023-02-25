package exercism;

import java.util.List;

class ValueNotFoundException extends Exception {
  ValueNotFoundException(String msg) {
    super(msg);
  }
}

public class BinarySearch {

  private List<Integer> list;

  BinarySearch(List<Integer> list) {
    this.list = list;
  }

  public static void main(String[] args) throws ValueNotFoundException {
    List<Integer> sortedListOfOddLength = List.of(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634);

    BinarySearch bs = new BinarySearch(sortedListOfOddLength);
    System.out.println(bs.indexOf(144));
  }

  public int indexOf(int target) throws ValueNotFoundException {
    return this.search(target, 0, list.size() - 1);
  }

  private int search(int target, int min, int max) throws ValueNotFoundException {

    if (min > max)
      throw new ValueNotFoundException("Value not in array");

    int mid = Math.floorDiv(max - min, 2) + min;
    int val = list.get(mid);
    if (val == target) {
      return mid;
    } else if (target > val) {
      return search(target, mid + 1, max);
    } else {
      return search(target, min, mid - 1);
    }

  }

}
