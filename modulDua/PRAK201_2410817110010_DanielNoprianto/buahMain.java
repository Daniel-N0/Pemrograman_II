package modulDua.PRAK201_2410817110010_DanielNoprianto;

public class buahMain {

	public static void main(String[] args) {
		Buah apel = new Buah ("Apel", 0.4, 7000, 40.0);
		Buah mangga = new Buah ("Mangga", 0.2, 3500, 15.0);
		Buah alpukat = new Buah ("Alpukat", 0.25, 10000, 12.0);

		apel.tampilkanInfo();
		mangga.tampilkanInfo();
		alpukat.tampilkanInfo();
	}

}