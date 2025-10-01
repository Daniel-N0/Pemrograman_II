	package modulSatu;
	import java.util.Scanner;
	
	public class PRAK102_2410817110010_DanielNoprianto {
	
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("");
			int angkaAwal = scan.nextInt();
			scan.close();
	
			System.out.print("");
	        
			int i = 0;
	        while (i <= 10) {
	            if (angkaAwal % 5 == 0) {
	                System.out.print(((angkaAwal / 5) - 1));
	            } else {
	                System.out.print(angkaAwal);
	            }
	
	            if (i < 10) {
	                System.out.print(", ");
	            }
	
	            angkaAwal++; 
	            i++;
	        }
	        System.out.println();
	
		}
	
	}
