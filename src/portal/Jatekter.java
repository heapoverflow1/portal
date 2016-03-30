package portal;

import java.util.ArrayList;
import java.util.List;

public class Jatekter {
	List<Ososztaly> objects;
	
	/* Konstruktor
	 * A JATEKTER inicializalasa, az objects lista letrehozasa
	 */
	public Jatekter() {
		System.out.println(">Jatekter::konstruktor");	
		objects = new ArrayList<Ososztaly>();
		System.out.println("<Jatekter::konstruktor");
	}
	
	//!TODO - KOMMENT
	public Doboz getDoboz(Pont innen){
		for (Ososztaly i : objects){
			if (i instanceof Doboz && i.position.compareTo(innen)){
				return (Doboz) i;
			}				
		}
		return null;
	}
	
	//Új objektum hozzaadasa a JATEKTER-hez
	public void add(Ososztaly uj){
		uj.Add(objects);	//Ezt biztos igy akarjuk? Nekem jo, de olyan fura.
		//Mert hogy objects.add(uj); nekem logikusabb lenne.
		//Az inicializalashoz tartozik, ezert szerintem kiiras nem szükgseges
		//!TODO
		/** Szerintem ez igy jo:
		 *  objects.add(uj);
		 *  mashogy en sem ertem, szoval akkor az OSOSZTALY beli Add-ot sem ertem
		 *  -WM
		 */
	}
	
	//!TODO - out of date lett a kommentje
	//Irany iranyban levo mezo ellenorzese
	public Pont checkfield(Pont regihely, Pont ujhely){
		System.out.println(">Jatekter::checkfield");
		for (Ososztaly i : objects){
			//ez most csak a merleg miatt van benn, a baj vele az, hogy minden mezore meghivodik, 
			//amirol az ezredes elmozdul, ami a kiiraskor bezavarhat - TG
			if (i.position.compareTo(regihely)){
				i.ertesit(regihely);
			}
			if (i.position.compareTo(ujhely)){
				ujhely = i.ertesit(regihely);
			}				
		}		
		
		System.out.println("<Jatekter::checkfield");
		
		return ujhely;
	}
}
