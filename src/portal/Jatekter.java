package portal;

import java.util.ArrayList;
import java.util.List;

import portal.Ezredes.Irany;

public class Jatekter {
	List<Ososztaly> objects;
	
	/* !TODO
	 * Ha ez benne marad, akkor konstruktorban valahogy meg kene kapnia
	 * ATgondolni
	 * -WM
	 */
	Ezredes foszereplo;
	
	/* Konstruktor
	 * A JATEKTER inicializalasa, az objects lista letrehozasa
	 */
	public Jatekter() {
		System.out.println(">Jatekter::konstruktor");	
		objects = new ArrayList<Ososztaly>();
		System.out.println("<Jatekter::konstruktor");
	}
	
	//Új objektum hozzaadasa a JATEKTER-hez
	public void add(Ososztaly uj){
		uj.Add(objects);	//Ezt biztos igy akarjuk? Nekem jo, de olyan fura.
		//Mert hogy objects.add(uj); nekem logikusabb lenne.
		//Az inicializalashoz tartozik, ezert szerintem kiiras nem szükgseges
		
		/** Szerintem ez igy jo:
		 *  objects.add(uj);
		 *  mashogy en sem ertem, szoval akkor az OSOSZTALY beli Add-ot sem ertem
		 *  -WM
		 */
	}
	
	//Irany iranyban levo mezo ellenorzese
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
