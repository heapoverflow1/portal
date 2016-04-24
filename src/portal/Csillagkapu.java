package portal;


public class Csillagkapu{
	SpecFal[] falak;	
	boolean[] Feregjarat;
	
	
	/* Konstruktor
	 * beallitja a feregjaratot false-ra. Alapertelmezes.
	 */
	public Csillagkapu(int x, int y) {
		
		Feregjarat = new boolean[2];
		falak = new SpecFal[4];
		for (int i=0;i<4;i++){
			falak[i]=null;
		}
	}
	
	// Beallitja a kek privat SpecFal erteket a kapottra
	boolean SetCsk(SpecFal pos, Szin color){
		falak[color.getValue()] = pos;
		//a megfelelõ színhez tároljuk, hogy melyik fal tartozik
		Szin masik = null;
		//megszerezzük, hogy milyen színû a párja
		switch(color){
			case SARGA:
				masik = Szin.KEK;
				break;
			case KEK:
				masik = Szin.SARGA;
				break;
			//a sárgának a kék,
			case ZOLD:
				masik = Szin.PIROS;
				break;
			case PIROS:
				masik = Szin.ZOLD;
				break;
			//a zöldnek a piros
			default:
				break;
		}
		//elkerüljük a nullpointerexceptiont az ellenõrzéssel
		if (masik!=null && falak[masik.getValue()]==null){
			Feregjarat[color.getValue()/2]=true;
			return true;
		}
		return false;
	}

	Pont checkCsk(SpecFal fal, Pont innenjon){
		for (int i=0;i<4;i++){
			if (fal==falak[i]){
				if (i%2==0 && falak[i+1]!=null) return falak[i+1].position;
				if (i%2==1 && falak[i-1]!=null) return falak[i-1].position;
				return innenjon;
			}
		}
		return innenjon;
	}
}
