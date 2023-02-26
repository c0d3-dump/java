package exercism;

public class LinkedList {
  public static void main(String[] args) {
    DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
    dl.push(1);
    dl.push(2);
    dl.push(3);
    dl.unshift(5);

    System.out.println(dl.pop());
    System.out.println(dl.shift());
    System.out.println(dl.shift());
    System.out.println(dl.shift());
  }
}

class DoublyLinkedList<T> {
  private Element<T> head;

  void push(T value) {
    if (head == null)
      head = new Element<T>(value, null, null);
    else {
      Element<T> temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = new Element<T>(value, temp, null);
    }
  }

  T pop() {
    Element<T> temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    if (temp.prev != null) {
      temp.prev.next = null;
    }
    return temp.value;
  }

  void unshift(T value) {
    if (head == null)
      head = new Element<T>(value, null, null);
    else {
      Element<T> temp = head;
      while (temp.prev != null) {
        temp = temp.prev;
      }
      temp.prev = new Element<T>(value, null, temp);
      head = temp.prev;
    }
  }

  T shift() {
    Element<T> temp = head;
    if (temp.next != null) {
      head = temp.next;
      head.prev = null;
    }
    return temp.value;
  }

  private static final class Element<T> {
    private final T value;
    private Element<T> prev;
    private Element<T> next;

    Element(T value, Element<T> prev, Element<T> next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }
}
