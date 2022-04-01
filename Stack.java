package Tugas2;

class Stack {
  Node head;
  Node tail;
  int size = 0;

  Node peekTop() {
    return tail;
  }

  void push(Kendaraan data) {
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

  void pop() {
    if (size == 0) {
      return;
    }
    if (size == 1) {
      head = null;
      size--;
      return;
    }
    tail = tail.prev;
    tail.next = null;
    size--;
  }

  void printAll() {
    if (size == 0) {
      return;
    }
    var current = head;
    for (int i = 0; i < size; i++) {
      System.out.print(current.data.platNomor + ", ");
      current = current.next;
    }
  }
}