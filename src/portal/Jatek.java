package portal;

import java.io.IOException;

public class Jatek {
	static Jatekter palya;
	static Ezredes ezredes;
	
	public static void main(String[] args){
		palya = new Jatekter();
		System.out.println("SZKELETON - heapoverflow");
		while (true){
			System.out.println("Melyik esetet szeretn� futtatni?");
			System.out.println("3 - mozg�s");
			System.out.println("4 - g�s");
			System.out.println("3 - mozg�s");
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
					break;
				case 2:
					break;
				case 3:
					break;
				default:
						break;
			}
			
		}
	}
}
