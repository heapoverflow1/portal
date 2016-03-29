package portal;

public class SpecFal extends Fal {
	
	/* Konstruktor
	 * Az SPECFAL inicializalasa x, y koordinatakkal
	 * Meghivja az os (FAL) konstruktorat
	 */
	public SpecFal(int x, int y) {
		super(x,y);
	}

	//!TODO
	//Letrehozzuk a csillagkaput kb
	void createCSK(Tolteny t, Csillagkapu cs){
		if(t.type_kek == true /*es meg nem letezik csillagkapu*/){
			//beallítjuk a kek erteket
			cs.setBlue(this);
		}else{
			//beallítjuk a sarga erteket
			cs.setYellow(this);
		}
	}
	
	//!TODO
	void destroyCSK(Tolteny t){}
}
