package modulSatu;
import java.util.Scanner;

public class PRAK101_2410817110010_DanielNoprianto {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Input Nama
        System.out.print("Masukkan Nama Lengkap: ");
        String namaLengkap = scan.nextLine();

        //Input Tempat Lahir
        System.out.print("Masukkan Tempat Lahir: ");
        String tempatLahir = scan.nextLine();

        //Validasi untuk Tanggal, Bulan, dan Tahun 
        int tanggalLahir, bulanLahir, tahunLahir;
        boolean tanggalValid = false;

        do {
            System.out.print("Masukkan Tanggal Lahir: ");
            tanggalLahir = scan.nextInt();

            System.out.print("Masukkan Bulan Lahir: ");
            bulanLahir = scan.nextInt();

            System.out.print("Masukkan Tahun Lahir: ");
            tahunLahir = scan.nextInt();

            //Validasi Bulan
            if (bulanLahir < 1 || bulanLahir > 12) {
                System.out.println("ERROR: Bulan harus antara 1 - 12. Silakan ulangi.");
                continue;
            }

            //Cek Tahun
            int tahunSekarang = 2025;
            if (tahunLahir > tahunSekarang || tahunLahir <= 0) {
                System.out.println("ERROR: Tahun lahir tidak valid. Silakan ulangi.");
                continue;
            }

            //Cek Tanggal sesuai Bulan dan Tahun Kabisat
            int maksTanggal;
            if (bulanLahir == 2) {
                //Cek tahun kabisat
                boolean isKabisat = (tahunLahir % 4 == 0 && tahunLahir % 100 != 0) || (tahunLahir % 400 == 0);
                maksTanggal = isKabisat ? 29 : 28;
            } else if (bulanLahir == 4 || bulanLahir == 6 || bulanLahir == 9 || bulanLahir == 11) {
                maksTanggal = 30;
            } else {
                maksTanggal = 31;
            }

            if (tanggalLahir >= 1 && tanggalLahir <= maksTanggal) {
                tanggalValid = true;
            } else {
                System.out.println("ERROR: Tanggal " + tanggalLahir + " tidak valid untuk bulan " + bulanLahir + " tahun " + tahunLahir + ". Maksimal tanggal adalah " + maksTanggal + ".");
                System.out.println("Silakan masukkan ulang tanggal, bulan, dan tahun.");
            }

        } while (!tanggalValid);

        //Validasi Tinggi & Berat Badan ---
        int tinggiBadan;
        do {
            System.out.print("Masukkan Tinggi Badan: ");
            tinggiBadan = scan.nextInt();
            if (tinggiBadan <= 0) {
                System.out.println("Tinggi badan tidak boleh nol atau negatif. Silakan coba lagi.");
            }
        } while (tinggiBadan <= 0);

        double beratBadan;
        do {
            System.out.print("Masukkan Berat Badan: ");
            beratBadan = scan.nextDouble();
            if (beratBadan <= 0) {
                System.out.println("Berat badan tidak boleh nol atau negatif. Silakan coba lagi.");
            }
        } while (beratBadan <= 0);

        scan.close();

        String namaBulan;
        switch (bulanLahir) {
            case 1:  namaBulan = "Januari"; break;
            case 2:  namaBulan = "Februari"; break;
            case 3:  namaBulan = "Maret"; break;
            case 4:  namaBulan = "April"; break;
            case 5:  namaBulan = "Mei"; break;
            case 6:  namaBulan = "Juni"; break;
            case 7:  namaBulan = "Juli"; break;
            case 8:  namaBulan = "Agustus"; break;
            case 9:  namaBulan = "September"; break;
            case 10: namaBulan = "Oktober"; break;
            case 11: namaBulan = "November"; break;
            case 12: namaBulan = "Desember"; break;
            default: namaBulan = ""; break;
        }

        System.out.println("Nama Lengkap " + namaLengkap + ", Lahir di " + tempatLahir + " pada Tanggal " + tanggalLahir + " " + namaBulan + " " + tahunLahir);
        System.out.println("Tinggi Badan " + tinggiBadan + " cm dan Berat Badan " + beratBadan + " kilogram");
    }
}