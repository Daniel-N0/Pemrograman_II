package modulSatu;
import java.util.Scanner;

public class PRAK103_2410817110010_DanielNoprianto {

	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        System.out.print("");
	        int jumlahBaris = scan.nextInt();
	        int angka = scan.nextInt();
	        scan.close();

	        int i = 0;
	        
	        do {
	            if (angka % 2 != 0) {
	                System.out.print(angka);
	                i++;
	                if (i < jumlahBaris) {
	                    System.out.print(", ");
	                }
	            }
	            angka++;
	        } while (i < jumlahBaris); 	        
	        System.out.println();
	    }
	}