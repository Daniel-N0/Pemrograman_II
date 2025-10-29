package modulEmpat.PRAK402_2410817110010_DanielNoprianto;

import java.util.Scanner;

public class Soal2Main {
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
	        System.out.println("1 = Kucing");
	        System.out.println("2 = Anjing");
	        System.out.print("Masukkan pilihan: ");
	        int pilihan = input.nextInt();
	        input.nextLine(); 

	        System.out.print("Nama hewan peliharaan: ");
	        String nama = input.nextLine();

	        System.out.print("Ras: ");
	        String ras = input.nextLine();

	        System.out.print("Warna Bulu: ");
	        String warna = input.nextLine();

	        if (pilihan == 1) {
	            Kucing k = new Kucing(ras, nama, warna);
	            k.displayDetailKucing();
	        } else if (pilihan == 2) {
	            System.out.print("Kemampuan : ");
	            String kemampuanInput = input.nextLine();

	            String[] kemampuan = kemampuanInput.split(",");

	            for (int i = 0; i < kemampuan.length; i++) {
	                kemampuan[i] = kemampuan[i].trim();
	            }

	            Anjing a = new Anjing(nama, ras, warna, kemampuan);
	            a.displayDetailAnjing();
	        } else {
	            System.out.println("Pilihan tidak valid.");
	        }

	        input.close();
	    }
	}

