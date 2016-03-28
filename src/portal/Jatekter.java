package portal;

import java.util.ArrayList;
import java.util.List;

import portal.Ezredes.Irany;

public class Jatekter {
	List<Ososztaly> objects;
	Ezredes foszereplo;
	
	/* Konstruktor
	 * A JATEKTER inicializálása, az objects lista létrehozása
	 */
	public Jatekter() {
		System.out.println(">Jatekter::konstruktor");	
		objects = new ArrayList<Ososztaly>();
		System.out.println("<Jatekter::konstruktor");
	}
	
	//Új objektum hozzáadása a JATEKTER-hez
	public void add(Ososztaly uj){
		uj.Add(objects);	//Ezt biztos így akarjuk? Nekem jó, de olyan fura.
		//Mert hogy objects.add(uj); nekem logikusabb lenne.
		//Az inicializáláshoz tartozik, ezért szerintem kiírás nem szükgséges
		
		/** Szerintem ez így jó:
		 *  objects.add(uj);
		 *  máshogy én sem értem, szóval akkor az OSOSZTALY beli Add-ot sem értem
		 *  -WM
		 */
	}
	
	//Irany irányban levõ mezõ ellenõrzése
	public void checkfield(Irany erre){
		System.out.println(">Jatekter::checkfield");
		Pont ellenorizendo = foszereplo.position;
		switch (erre){
			case jobbra:
				ellenorizendo.moveY(1);
			break;
			
			case balra:
				ellenorizendo.moveY(-1);
			break;
			
			case fel:
				ellenorizendo.moveX(-1);
			break;
			
			case le:
				ellenorizendo.moveX(1);
			break;
			
			default:
			break;
		}
		
		boolean falvolt = false;
		
		for (Ososztaly i : objects){
			if (i.position.compareTo(ellenorizendo)){
				if (i instanceof Fal) falvolt = true;
				else if (i instanceof Merleg) ((Merleg) i).weighted();//TODO!!!
			}				
		}
		
		//Elmozgatjuk az Ezredest, ha nem falba akart menni:
		if (!falvolt) foszereplo.position = ellenorizendo;
		
		System.out.println("<Jatekter::checkfield");
	}
}
