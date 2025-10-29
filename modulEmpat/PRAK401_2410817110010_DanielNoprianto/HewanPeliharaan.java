package modulEmpat.PRAK401_2410817110010_DanielNoprianto;

public class HewanPeliharaan {
	private String nama;
	private String ras;
	
	public HewanPeliharaan(String n, String r) {
		this.nama = n;
		this.ras = r;
	}
	
	public void display() {		
		System.out.println("\nDetail Hewan Peliharaan: " );
		System.out.println("Nama Hewan Peliharaan: " + nama);
		System.out.println("Dengan ras: " + ras);		
	}

}
