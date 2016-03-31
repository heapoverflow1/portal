package portal;

import java.util.ArrayList;
import java.util.List;

public class Jatekter {
	List<Ososztaly> objects;
	
	/* Konstruktor
	 * A JATEKTER inicializalasa, az objects lista letrehozasa
	 */
	public Jatekter() {		
		objects = new ArrayList<Ososztaly>();		
	}
	
	//!TODO - KOMMENT
	public Doboz getDoboz(Pont innen){
		
		System.out.println(">Jatekter::getDoboz(Pont)");
		
		for (Ososztaly i : objects){
			if (i instanceof Doboz && i.position.compareTo(innen)){
				
				System.out.println("<Jatekter::getDoboz(Pont)");
				return (Doboz) i;
			}				
		}
		
		System.out.println("<Jatekter::getDoboz(Pont)");
		return null;
	}
	
	//Új objektum hozzaadasa a JATEKTER-hez
	public void add(Ososztaly uj){
		
		System.out.println(">Jatekter::add(Ososztaly)");
		
		//Ezt biztos igy akarjuk? Nekem jo, de olyan fura.
		//Mert hogy objects.add(uj); nekem logikusabb lenne.
		//Az inicializalashoz tartozik, ezert szerintem kiiras nem szükgseges
		//!TODO
		/** Szerintem ez igy jo:
		 *  objects.add(uj);
		 *  mashogy en sem ertem, szoval akkor az OSOSZTALY beli Add-ot sem ertem
		 *  -WM
		 */
		uj.Add(objects);
		
		System.out.println("<Jatekter::add(Ososztaly)");
		
	}
	
	//!TODO - out of date lett a kommentje
	//Irany iranyban levo mezo ellenorzese
	public Pont checkfield(Pont regihely, Pont ujhely){
		
		System.out.println(">Jatekter::checkfield(Pont, Pont)");
		
		for (Ososztaly i : objects){
			//javitva, csak merlegnel hivja meg - TG
			if (i.position.compareTo(regihely) && (i instanceof Merleg)){
				i.ertesit(regihely);
			}
			if (i.position.compareTo(ujhely)){
				ujhely = i.ertesit(regihely);
			}				
		}		
		
		System.out.println("<Jatekter::checkfield(Pont, Pont)");
		
		return ujhely;
	}
}
