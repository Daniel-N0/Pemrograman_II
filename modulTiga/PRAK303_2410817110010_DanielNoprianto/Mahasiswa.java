package modulTiga.PRAK303_2410817110010_DanielNoprianto;

public class Mahasiswa {
	private String nama;
	private String nim;
	
	public Mahasiswa(String nama, String nim) {
		this.nama = nama;
		this.nim = nim;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNim(String nim) {
		this.nim = nim;
	}
	
	public String getNim() {
		return nim;
	}

}
