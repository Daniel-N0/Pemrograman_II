package modulDua.PRAK203_2410817110010_DanielNoprianto;

public class Soal3Main {
	public static void main(String[] args) {
			Pegawai p1 = new Pegawai();
			// p1.nama = "Roi" ini error karena tidak ada titik koma di akhir(;)
			// p1.nama = "Roi"
			p1.nama = "Roi";
			p1.asal = "Kingdom of Orvel";
			p1.setJabatan("Assasin");
			//p1 umur belum diinisialisasi, ditambahkan inisialisasi agar output sesuai yang diminta
			p1.umur = 17 ;
			//pada output hanya Nama tanpa kata pegawai
			//System.out.println("Nama Pegawai: " + p1.getNama());
			System.out.println("Nama: " + p1.getNama());
			System.out.println("Asal: " + p1.getAsal());
			System.out.println("Jabatan: " + p1.jabatan);
			//Pada output kurang kata/String "tahun" sehabis angka agar sesuai output yang diminta
			//System.out.println("Umur: " + p1.umur );
			System.out.println("Umur: " + p1.umur + " tahun");
			}
	}