package modulDua.PRAK201_2410817110010_DanielNoprianto;

public class Buah {
	String namaBuah;
	double berat;
	double harga;
	double jumlahBeli;
	
	//Constructor
	public Buah(String namaBuah, double berat, double harga, double jumlahBeli) {
		this.namaBuah = namaBuah;
		this.berat = berat;
		this.harga = harga;
		this.jumlahBeli = jumlahBeli;
	}
	
	//Method
	//Perhitungan Harga Sebelum Diskon
	double hargaSebelumDiskon() {
		return (jumlahBeli / berat) * harga;
	}
	
//	Perhitungan Diskon
	double diskon() {
		double diskon =(int)(jumlahBeli/4) * 0.02 * 4 * harga;
	    return diskon;
	}
	
	//Perhitungan Harga Setelah Diskon
	double hargaSetelahDiskon() {
		return hargaSebelumDiskon() - diskon();
	}
	
	//Untuk Output
	void tampilkanInfo() {
		System.out.println("Nama Buah: " + namaBuah);
		System.out.println("Berat: " + berat);
		System.out.println("Harga: " + harga);
		System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
		System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hargaSebelumDiskon());
		System.out.printf("Total Diskon: Rp%.2f%n", diskon());
		System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hargaSetelahDiskon());
		System.out.println();
	}
}
