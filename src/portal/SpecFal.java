package portal;

import java.io.IOException;

public class SpecFal extends Fal {
	
	private Csillagkapu cs;
	
	/* Konstruktor
	 * Az SPECFAL inicializalasa x, y koordinatakkal
	 * Meghivja az os (FAL) konstruktorat
	 */
	public SpecFal(int x, int y) {
		super(x,y);
	}

	//Letrehozzuk a csillagkaput kb
	void createCSK() throws IOException{
		
		System.out.println(">SpecFal::createCSK(Tolteny, Csillagkapu)");
		System.out.println("Milyen szinu csillagkaput lottunk?(kek/sarga) k/s");
		char cs_szin = (char) System.in.read();
		
		System.out.println("Van mar valamilyen csillagkapu? (nem, sarga, kek) n/s/k");
		char cs_van_e = (char) System.in.read();
				
		
		if(cs_szin == 'k'){
			switch (cs_van_e) {
				case 'n':
					cs.setBlue(this);
					break;				
				case 's':
					cs.setBlue(this);
					cs.makeFeregjarat();
					break;
				case 'k':
					cs.setBlue(this);
					break;
				default:
					break;
			}			
		}else if(cs_szin == 's'){
			
			switch (cs_van_e) {
				case 'n':
					cs.setYellow(this);
					break;
				case 's':
					cs.setYellow(this);
					break;
				case 'k':
					cs.setYellow(this);
					cs.makeFeregjarat();
					break;
	
				default:
					break;
			}		
		}
		
		System.out.println("<SpecFal::createCSK(Tolteny, Csillagkapu)");
	}	
	
		
	
	//!TODO - HA TOLTENY VAN?
	public Pont ertesit(Pont regi){
		return null;
	}
}
