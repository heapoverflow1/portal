package portal;

import java.io.IOException;

public class Jatek {
	static Jatekter palya;
	static Ezredes ezredes;
	static Ajto ajto;
	static Doboz doboz;
	static Fal fal;
	static Merleg merleg;
	static SpecFal specfal;
	static Szakadek szakadek;
	static Tolteny tolteny;
	static ZPM zpm;
	
	public static void main(String[] args){
		palya = new Jatekter();
		System.out.println("SZKELETON - heapoverflow");
		while (true){
			System.out.println("Melyik esetet szeretn� futtatni?");
			System.out.println("1 - mozg�s");
			System.out.println("2 - m�rlegre l�p�s");
			System.out.println("3 - m�rlegr�l lel�p�s");
			System.out.println("3 - mozg�s");
			System.out.println("3 - mozg�s");
			System.out.println("3 - mozg�s");
			System.out.println("3 - mozg�s");
			System.out.println("3 - mozg�s");
			System.out.println("3 - mozg�s");
			System.out.println("3 - mozg�s");
			
			int valasz = 0;
			try {
				valasz = (int) System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
			switch (valasz){
				case 1:
				try {
					ezredes.move(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						merleg.ezredesStepsOn();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
				case 3:
					try {
						merleg.ezredesStepsOff();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
				case 4:
					doboz.Lift();
					break;
				default:
						break;
			}
			
		}
	}
}
