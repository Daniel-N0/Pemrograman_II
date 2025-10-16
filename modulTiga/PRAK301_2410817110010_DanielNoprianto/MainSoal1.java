package modulTiga.PRAK301_2410817110010_DanielNoprianto;

import java.util.LinkedList;
import java.util.Scanner;

public class MainSoal1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int jumlahDadu = 0;

        while (true) {
            System.out.print(""); 
            
            if (scan.hasNextInt()) {
                jumlahDadu = scan.nextInt();
                if (jumlahDadu > 0) {
                    break; 
                } else {
                    System.out.println("ERROR: Jumlah dadu harus > 0");
                }
            } else {
                System.out.println("ERROR: Input HARUS sebuah angka!");
                scan.next();
            }
        }

        System.out.println(); 

        LinkedList<Dadu> kumpulanDadu = new LinkedList<>();
        for (int i = 0; i < jumlahDadu; i++) {
            kumpulanDadu.add(new Dadu());
        }

        int totalNilai = 0;
        for (int i = 0; i < kumpulanDadu.size(); i++) {
            Dadu dadu = kumpulanDadu.get(i);
            int nilai = dadu.getNilai();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilai);
            totalNilai += nilai;
        }

        System.out.println("Total nilai dadu keseluruhan " + totalNilai);
        scan.close();
    }
}