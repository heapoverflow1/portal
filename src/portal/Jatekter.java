package portal;

import java.util.ArrayList;
import java.util.List;

public class Jatekter {
	List<Ososztaly> objects;
	
	/* !TODO
	 * Ha ez benne marad, akkor konstruktorban valahogy meg kene kapnia
	 * ATgondolni
	 * -WM
	 */
	
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
	public Pont checkfield(Pont regihely, Pont ujhely){
		System.out.println(">Jatekter::checkfield");
		
		for (Ososztaly i : objects){
			if (i.position.compareTo(ujhely)){
				ujhely = i.ertesit(regihely);
			}				
		}		
		//Elmozgatjuk az Ezredest, ha nem falba akart menni:
		
		System.out.println("<Jatekter::checkfield");
		
		return ujhely;
	}
}
