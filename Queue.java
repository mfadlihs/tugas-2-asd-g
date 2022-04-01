package Tugas2;

public class Queue {
  Node head;
  Node tail;
  int size;

  void enQueue(Kendaraan data) {
    Node newNode = new Node(data);
    if (size == 0) {
      head = tail = newNode;
      size++;
      return;
    }
    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
    size++;
  }

  void deQueue() {
    if (size == 0) {
      return;
    }
    if (size == 1) {
      head = null;
      size--;
      return;
    }

    int maxTemp = -999;
    int nodeDelete = 0;

    var current = head;
    // Mengetahui node mana yang akan dihapus
    for (int i = 0; i < size; i++) {
      if (((Motor) current.data).cc > maxTemp) {
        nodeDelete = i;
        maxTemp = ((Motor) current.data).cc;
      }
      current = current.next;
    }

    // traversing ke node yang akan dihapus
    current = head;
    for (int i = 0; i < nodeDelete; i++) {
      current = current.next;
    }

    if (nodeDelete == 0) {
      deleteFirst();
    } else if (nodeDelete == size - 1) {
      deleteLast();
    } else {
      current.prev.next = current.next;
      current.next.prev = current.prev;
      size--;
    }

    // head = head.next;
    // head.prev = null;
    // size--;
  }

  Node peekFirst() {
    return head;
  }

  void deleteFirst() {
    head = head.next;
    head.prev = null;
    size--;
  }

  void deleteLast() {
    tail = tail.prev;
    tail.next = null;
    size--;
  }

  void printAll() {
    var current = head;
    for (int i = 0; i < size; i++) {
      System.out.print(current.data.platNomor + ", ");
      current = current.next;
    }
  }
}
