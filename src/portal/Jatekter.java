package portal;

import java.util.ArrayList;
import java.util.List;

public class Jatekter {
	List<Ososztaly> objects;
	public Csillagkapu kapumgr;
	Szereplo sz;
	
	/* Konstruktor
	 * A JATEKTER inicializalasa, az objects lista letrehozasa
	 */
	public Jatekter() {		
		objects = new ArrayList<Ososztaly>();
		kapumgr = new Csillagkapu();
	}
	
	//!TODO - KOMMENT
	public Doboz getDoboz(Pont innen){

		for (Ososztaly i : objects){
			if (i instanceof Doboz && i.position.compareTo(innen)){
				
				System.out.println("<Jatekter::getDoboz(Pont)");
				return (Doboz) i;
			}				
		}
		return null;
	}
	
	public Merleg getMerleg(Pont innen){
		
		System.out.println(">Jatekter::getMerleg(Pont)");
		
		for (Ososztaly i : objects){
			if (i instanceof Merleg && i.position.compareTo(innen)){
				
				System.out.println("<Jatekter::getMerleg(Pont)");
				return (Merleg) i;
			}				
		}
		
		System.out.println("<Jatekter::getMerleg(Pont)");
		return null;
	}
	
	//Új objektum hozzaadasa a JATEKTER-hez
	public void add(Ososztaly uj){
		objects.add(uj);
	}
	
	//Objektum eltavolitasa - ha pl. szakadekba zuhant valami,
	//vagy osszegyujtottek a ZPM-et	
	public void remove(Ososztaly ezt){
		objects.remove(ezt);
	}
	
	//!TODO - out of date lett a kommentje
	//Irany iranyban levo mezo ellenorzese
	//nem lenne jobb ha ez static? - TG
	public Pont checkfield(Pont regihely, Pont ujhely){
		List<Pont> ellenzok = new ArrayList<Pont>();
		for (Ososztaly i : objects){
			//javitva, csak merlegnel hivja meg - TG
			if (i.position.compareTo(regihely) && (i instanceof Merleg)){
				i.ertesit(regihely,sz);
			}
			if (i.position.compareTo(ujhely)){
				Pont idemutat = i.ertesit(regihely,sz);
				if (!idemutat.compareTo(ujhely)) ellenzok.add(idemutat);
			}				
		}
		if (ellenzok.isEmpty())
			return ujhely;
		
		for (Pont i : ellenzok){
			if (!i.compareTo(regihely)) return i;
		}
		return regihely;
		
	}
	
	public void checkfield_shoot (Pont p, Tolteny t){
		for (Ososztaly  i : objects){
			
			if (i.position.compareTo(p))
				i.ertesit_shoot(t);	
		}		
	}
	
	public List<Ososztaly> getObjects(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		for (Ososztaly i : objects){
			ref.add(i);
		}
		return ref;
	}
	
	/*
	 * KENE valahonnan csillagkapu a createCSK-nak 
	 */
	
//	public void checkBullet(Tolteny t){
//		
//		for (Ososztaly i : objects){
//			if(i instanceof Fal){
//				t.destroy();
//			}else if(i instanceof SpecFal){
//				((SpecFal) i).createCSK(t, cs);
//			}
//			
//		}
//		
//	}
}
