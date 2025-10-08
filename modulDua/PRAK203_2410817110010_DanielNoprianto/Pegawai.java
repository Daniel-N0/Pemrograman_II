package modulDua.PRAK203_2410817110010_DanielNoprianto;

// public class Employee { ini salah karena nama file adalah Pegawai.java sedangkan nama file dan class harus sama.
// public class Employee {
public class Pegawai {
	public String nama;
	// public char asal; ini salah karena char hanya dapat meyimpan 1 karakter saja sedangkan inputnya adalah data String.
	// public char asal;
	public String asal;
	public String jabatan;
	public int umur;
	
	public String getNama() {
		return nama;
	}
	
	public String getAsal() {
		return asal;
	}
	// public void setJabatan() { ini salah karena kurang parameter String j sebagai nilai jabatan
	// public void setJabatan() {
	public void setJabatan(String j) {
		this.jabatan = j;
	}
	
}