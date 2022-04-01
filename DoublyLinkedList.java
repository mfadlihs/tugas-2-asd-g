package Tugas2;

public class DoublyLinkedList {
  Node head;
  Node tail;

  void addFirst(Kendaraan data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
      return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }

  void printAll() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data.platNomor + ", ");
      current = current.next;
    }
  }

}
