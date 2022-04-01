package Tugas2;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    var sc = new Scanner(System.in);

    var antrianMobil = new Stack();
    var antrianMotor = new Queue();

    var mobilSelamat = new DoublyLinkedList();
    var motorSelamat = new DoublyLinkedList();

    int waktuGempa = sc.nextInt();
    int jumlahKendaraan = sc.nextInt();

    int jumlahOrang = 0;

    for (int i = 0; i < jumlahKendaraan; i++) {
      var jenisKendaraan = sc.next();
      switch (jenisKendaraan) {
        case "mobil":
          String platNomor = sc.next();
          int penumpang = sc.nextInt();
          // Buat instance Mobil dengan polymorfisme
          Kendaraan mobil = new Mobil(platNomor, penumpang);

          // push mobil kedalam stack
          antrianMobil.push(mobil);
          jumlahOrang += penumpang;
          break;
        case "motor":
          platNomor = sc.next();
          int cc = sc.nextInt();

          // Buat instance Motor dengan polymorfisme
          Kendaraan motor = new Motor(platNomor, cc);

          // enqueue motor tersebut ke dalam Queue
          antrianMotor.enQueue(motor);

          jumlahOrang++;
      }
    }

    // Dequeue motor dalam sebanyak waktu gempa
    int jumlahOrangSelamat = 0;
    for (int i = 0; i < waktuGempa; i++) {
      motorSelamat.addFirst(antrianMotor.peekFirst().data);
      antrianMotor.deQueue();
      jumlahOrang--;
      jumlahOrangSelamat++;
    }

    // Pop mobil sebanyak waktu gempa
    for (int i = 0; i < waktuGempa; i++) {
      jumlahOrang -= ((Mobil) antrianMobil.peekTop().data).penumpang;
      jumlahOrangSelamat += ((Mobil) antrianMobil.peekTop().data).penumpang;
      mobilSelamat.addFirst(antrianMobil.peekTop().data);
      antrianMobil.pop();
    }

    // Print semua mobil/motor yang selamat
    System.out.print("Mobil dengan plat ");
    mobilSelamat.printAll();
    System.out.println("berhasil keluar dengan selamat");

    System.out.print("Motor dengan plat ");
    motorSelamat.printAll();
    System.out.println("berhasil keluar dengan selamat");
    System.out.println();

    // Print semua mobil/motor yang tidak selamat

    System.out.print("Mobil dengan plat ");
    antrianMobil.printAll();
    System.out.println("tertimbun reruntuhan");

    System.out.print("Motor dengan plat ");
    antrianMotor.printAll();
    System.out.println("tertimbun reruntuhan");
    System.out.println();

    // Print orang yang selamt dan tidak selamat

    System.out.println("selamat : " + jumlahOrangSelamat);
    System.out.println("tidak selamat : " + (jumlahOrang));

  }
}
