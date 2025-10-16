package modulTiga.PRAK302_2410817110010_DanielNoprianto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MainSoal2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList<Negara> listNegara= new LinkedList<>();
		HashMap<Integer, String> namaBulan = new HashMap<>();
		
		namaBulan.put(1, "Januari");
        namaBulan.put(2, "Februari");
        namaBulan.put(3, "Maret");
        namaBulan.put(4, "April");
        namaBulan.put(5, "Mei");
        namaBulan.put(6, "Juni");
        namaBulan.put(7, "Juli");
        namaBulan.put(8, "Agustus");
        namaBulan.put(9, "September");
        namaBulan.put(10, "Oktober");
        namaBulan.put(11, "November");
        namaBulan.put(12, "Desember");
        
        int jumlahNegara = 0;
        while(true) {
        	if(scan.hasNextInt()) {
        		jumlahNegara = scan.nextInt();
        		if (jumlahNegara > 0) {
        			break;
        		} else {
        			System.out.println("ERROR: Jumlah negara HARUS > 0");
        		}
        	} else {
        		System.out.println("ERROR: Input HARUS angka!");
        		scan.next();
        	}
        }
        scan.nextLine();
        
        for(int i = 0; i < jumlahNegara; i++) {
//        	Nama Negara
            String nama = scan.nextLine();
            
//          Jenis Kepemimpinan
            String jenis = scan.nextLine();

//          Nama Pemimpin
            String pemimpin = scan.nextLine();

            if (jenis.equalsIgnoreCase("monarki")) {
                listNegara.add(new Negara(nama, jenis, pemimpin));
            } else {
                int tgl = 0, bln = 0, thn = 0;

                while (true) {
//                	Tanggal Kemerdekaan
                	if (scan.hasNextInt()) {
                        tgl = scan.nextInt();
                        if (tgl >= 1 && tgl <= 31) break;
                        else System.out.println("ERROR: Tanggal tidak valid.");
                    } else {
                        System.out.println("ERROR: Input tanggal harus angka.");
                        scan.next();
                    }
                }

                while (true) {
//                	Bulan Kemerdekaan
                    if (scan.hasNextInt()) {
                        bln = scan.nextInt();
                        if (bln >= 1 && bln <= 12) break;
                        else System.out.println("ERROR: Bulan tidak valid.");
                    } else {
                        System.out.println("ERROR: Input bulan harus angka.");
                        scan.next();
                    }
                }

                while (true) {
//                	Tahun Kemerdekaan
                    if (scan.hasNextInt()) {
                        thn = scan.nextInt();
                        if (thn > 0) break;
                        else System.out.println("ERROR: Tahun harus positif.");
                    } else {
                        System.out.println("ERROR: Input tahun harus angka.");
                        scan.next();
                    }
                }
                scan.nextLine();

                listNegara.add(new Negara(nama, jenis, pemimpin, tgl, bln, thn));
            }
        }
        
//      Hasil
        System.out.println("");
        for (Negara negara : listNegara) {
            String jabatan;
            String jenisKepemimpinan = negara.getJenisKepemimpinan();

            if (jenisKepemimpinan.equalsIgnoreCase("presiden")) {
                jabatan = "Presiden";
            } else if (jenisKepemimpinan.equalsIgnoreCase("perdana menteri")) {
                jabatan = "Perdana Menteri";
            } else {
                jabatan = "Raja";
            }

            System.out.println("Negara " + negara.getNama() + " mempunyai " + jabatan + " bernama " + negara.getNamaPemimpin());

            if (!negara.isMonarki()) {
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " +
                        negara.getTanggal() + " " + namaBulan.get(negara.getBulan()) + " " + negara.getTahun());
            }

            System.out.println();
        }

        scan.close();
    }
}