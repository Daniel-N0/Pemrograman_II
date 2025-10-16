package modulTiga.PRAK303_2410817110010_DanielNoprianto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainSoal3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Cari Mahasiswa");
            System.out.println("4. Tampilkan Daftar");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            while (!input.hasNextInt()) {
                System.out.println("ERROR: Input harus angka!");
                System.out.print("Pilihan: ");
                input.next();
            }
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    // Tambah Mahasiswa
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = input.nextLine();

                    boolean sudahAda = false;
                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.getNim().equals(nim)) {
                            sudahAda = true;
                            break;
                        }
                    }

                    if (sudahAda) {
                        System.out.println("ERROR: NIM sudah digunakan!");
                    } else {
                        daftarMahasiswa.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa " + nama + " ditambahkan.");
                    }
                    break;

                case 2:
                    // Hapus Mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String hapusNim = input.nextLine();
                    boolean ditemukan = false;

                    Iterator<Mahasiswa> iterator = daftarMahasiswa.iterator();
                    while (iterator.hasNext()) {
                        Mahasiswa m = iterator.next();
                        if (m.getNim().equals(hapusNim)) {
                            iterator.remove();
                            System.out.println("Mahasiswa dengan NIM " + hapusNim + " dihapus.");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Mahasiswa dengan NIM " + hapusNim + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    // Cari Mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String cariNim = input.nextLine();
                    boolean ketemu = false;

                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.getNim().equals(cariNim)) {
                            System.out.println("Data Mahasiswa Ditemukan:");
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                            ketemu = true;
                            break;
                        }
                    }

                    if (!ketemu) {
                        System.out.println("Mahasiswa dengan NIM " + cariNim + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    // Tampilkan Daftar
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong.");
                    } else {
                        System.out.println("=== Daftar Mahasiswa ===");
                        for (Mahasiswa m : daftarMahasiswa) {
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                        }
                    }
                    break;

                case 0:
                    daftarMahasiswa.clear();
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("ERROR: Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        input.close();
    }
}
