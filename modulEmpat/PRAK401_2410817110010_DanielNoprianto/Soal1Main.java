package modulEmpat.PRAK401_2410817110010_DanielNoprianto;

import java.util.Scanner;

public class Soal1Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nama Hewan Peliharaan: ");
		String nama = input.nextLine();
		
		System.out.print("Ras: ");
		String ras = input.nextLine();
		
		HewanPeliharaan hewan = new HewanPeliharaan(nama, ras);
		hewan.display();
		
		input.close();
	}

}
