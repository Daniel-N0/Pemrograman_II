package modulTiga.PRAK302_2410817110010_DanielNoprianto;

public class Negara {
	private String nama;
	private String jenisKepemimpinan;
	private String namaPemimpin;
	private int tanggal;
	private int bulan;
	private int tahun;
	private boolean monarki;

	// NonMonarki
	public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggal, int bulan, int tahun) {
		this.nama = nama;
		this.jenisKepemimpinan = jenisKepemimpinan;
		this.namaPemimpin = namaPemimpin;
		setTahun(tahun);
		setBulan(bulan);
		setTanggal(tanggal);
		this.monarki = false;
	}
	
	// Monarki
	public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
		this.nama = nama;
		this.jenisKepemimpinan = jenisKepemimpinan;
		this.namaPemimpin = namaPemimpin;
		this.monarki = true;
	}
	
	// Tahun kabisat
	private boolean TahunKabisat(int tahun) {
		return (tahun % 400 == 0) || (tahun % 4 == 0 && tahun % 100 != 0);
	}
	
	// Maksimal hari dalam bulan
	private int getMaksimalHari(int bulan, int tahun) {
		switch (bulan) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				return 31;
			case 4: case 6: case 9: case 11:
				return 30;
			case 2:
				return TahunKabisat(tahun) ? 29 : 28;
			default:
				return 31;
		}
	}
	
	// Set Tanggal
	public boolean setTanggal(int tanggal) {
		int maxHari = getMaksimalHari(bulan, tahun);
		if (tanggal < 1 || tanggal > maxHari) {
			System.out.println("ERROR: Tanggal tidak valid untuk bulan " + bulan + " pada tahun " + tahun + ".");
			return false;
		} else {
			this.tanggal = tanggal;
			return true;
		}
	}
	
	// Set Bulan
	public boolean setBulan(int bulan) {
		if (bulan < 1 || bulan > 12) {
			System.out.println("ERROR: Bulan harus antara 1 - 12.");
			return false;
		} else {
			this.bulan = bulan;
			return true;
		}
	}
	
	// Set Tahun
	public boolean setTahun(int tahun) {
		if (tahun <= 0 || tahun > 2025) {
			System.out.println("ERROR: Tahun tidak valid.");
			return false;
		} else {
			this.tahun = tahun;
			return true;
		}
	}
	
	// Getter
	public String getNama() {
		return nama;
	}
	
	public String getJenisKepemimpinan() {
		return jenisKepemimpinan;
	}
	
	public String getNamaPemimpin() {
		return namaPemimpin;
	}
	
	public int getTanggal() {
		return tanggal;
	}
	
	public int getBulan() {
		return bulan;
	}
	
	public int getTahun() {
		return tahun;
	}
	
	public boolean isMonarki() {
		return monarki;
	}
}
