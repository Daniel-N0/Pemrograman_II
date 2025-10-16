package modulTiga.PRAK301_2410817110010_DanielNoprianto;
import java.util.Random;
	
public class Dadu {
	private int nilai;
	
	public Dadu() {
		acakNilai();
	}

	private void acakNilai() {
		Random acak = new Random();
		this.nilai = acak.nextInt(6) + 1;
	}
	
	public int getNilai() {
		return this.nilai;
	}
}
