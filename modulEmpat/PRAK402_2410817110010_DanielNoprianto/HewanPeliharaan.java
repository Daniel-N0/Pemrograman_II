package modulEmpat.PRAK402_2410817110010_DanielNoprianto;

public class HewanPeliharaan {
	private String nama;
	private String ras;
	
	public HewanPeliharaan(String r, String n) {
		this.ras = r;
		this.nama = n;
	}
	
	public void display() {
		System.out.println("\nDetail Hewan Peliharaan:");
		System.out.println("Nama hewan peliharaanku adalah: " + nama);
		System.out.println("Dengan ras: " + ras);
	}
	
}
