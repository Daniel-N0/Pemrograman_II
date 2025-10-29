package modulEmpat.PRAK402_2410817110010_DanielNoprianto;

public class Anjing extends HewanPeliharaan {
	private String warnaBulu;
	private String[] kemampuan;
	
	public Anjing(String n, String r, String w, String[]k) {
		super(r, n);
		this.warnaBulu = w;
		this.kemampuan = k;
	}

	public void displayDetailAnjing() {
		super.display();
        System.out.println("Memiliki warna bulu : " + warnaBulu);
        System.out.print("Memiliki kemampuan : ");
        
        for (String k : kemampuan) {
            System.out.print(k.trim() + " ");
        }
        System.out.println();
	}
	
}
