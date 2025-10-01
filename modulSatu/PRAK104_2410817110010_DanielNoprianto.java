package modulSatu;
import java.util.Scanner;

public class PRAK104_2410817110010_DanielNoprianto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Tangan Abu: ");
        String inputAbu = scan.nextLine();
        String tanganAbu = inputAbu.replaceAll("\\s+", "");

        System.out.print("Tangan Bagas: ");
        String inputBagas = scan.nextLine();
        String tanganBagas = inputBagas.replaceAll("\\s+", "");

        scan.close();

        if (tanganAbu.length() != 3 || tanganBagas.length() != 3) {
            System.out.println("\nInput tidak valid! Masing-masing pemain harus memasukkan 3 gerakan (B/G/K).");
        } else {
        	
            int skorAbu = 0;
            int skorBagas = 0;

            for (int i = 0; i < 3; i++) {
                char abuGerakan = tanganAbu.charAt(i);
                char bagasGerakan = tanganBagas.charAt(i);

                if ((abuGerakan == 'B' && bagasGerakan == 'G') || 
                    (abuGerakan == 'G' && bagasGerakan == 'K') || 
                    (abuGerakan == 'K' && bagasGerakan == 'B')) {
                    skorAbu++;
                } else if (abuGerakan != bagasGerakan) {
                    skorBagas++;
                }
            }
            
            if (skorAbu > skorBagas) {
                System.out.println("Abu");
            } else if (skorBagas > skorAbu) {
                System.out.println("Bagas");
            } else {
                System.out.println("Seri");
            }
        }
    }
}