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
	void createCSK(Tolteny t){
		if(t.type_kek == true /*es meg nem letezik csillagkapu*/){
			//beall�tjuk a kek erteket
		}else{
			//beall�tjuk a sarga erteket
		}
	}
	
	//!TODO
	void destroyCSK(Tolteny t){}
}
