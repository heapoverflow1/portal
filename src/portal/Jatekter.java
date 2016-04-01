package portal;

import java.util.ArrayList;
import java.util.List;


//!TODO checkbullet


public class Jatekter {
	List<Ososztaly> objects;
	
	/* Konstruktor
	 * A JATEKTER inicializalasa, az objects lista letrehozasa
	 */
	public Jatekter() {		
		objects = new ArrayList<Ososztaly>();		
	}
	
	
	public Doboz getDoboz(Pont innen){
		return null;
	}
	
	public Merleg getMerleg(Pont innen){
		return null;
	}
	
	//Új objektum hozzaadasa a JATEKTER-hez
	public void add(Ososztaly uj){
	
	}
	

	public Pont checkfield(Pont regihely, Pont ujhely){
		
		System.out.println(">Jatekter::checkfield(Pont, Pont)");
		
		System.out.println("<Jatekter::checkfield(Pont, Pont)");
		
		return ujhely;
	}
	
	public void checkBullet(){
		
		System.out.println(">Jatekter::checkBullet()");
		
		
		System.out.println("<Jatekter::checkBullet()");
	}
}
