package modulSatu;
import java.util.Scanner;

public class PRAK105_2410817110010_DanielNoprianto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         double jariJari, tinggi;
         final double PI = 3.14; 

        do {
            System.out.print("Masukkan jari-jari: ");
            jariJari = scanner.nextDouble();
            if (jariJari <= 0) {
                System.out.println("Input tidak valid. Jari-jari harus lebih besar dari 0.");
            }
        } while (jariJari <= 0);

        do {
            System.out.print("Masukkan tinggi: ");
            tinggi = scanner.nextDouble();
            if (tinggi <= 0) {
                System.out.println("Input tidak valid. Tinggi harus lebih besar dari 0.");
            }
        } while (tinggi <= 0);

        scanner.close();

        double volume = PI * jariJari * jariJari * tinggi;

        System.out.printf(
            "Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f cm3\n", 
            jariJari, tinggi, volume
        );
    }
}