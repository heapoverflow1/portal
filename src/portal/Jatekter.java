package portal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jatekter {
	List<Ososztaly> objects;
	public Csillagkapu kapumgr;
	public List<Ososztaly> removeQueue;
	int width;
	int height;
	
	/* Konstruktor
	 * A JATEKTER inicializalasa, az objects lista letrehozasa
	 */
	public Jatekter() {		
		objects = new ArrayList<Ososztaly>();
		removeQueue = new ArrayList<Ososztaly>();
		kapumgr = new Csillagkapu();
	}
	
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public void setWidth(int w){width=w;}
	public void setHeight(int h){height=h;}
	
	//!TODO - KOMMENT
	public Doboz getDoboz(Pont innen){

		for (Ososztaly i : objects){
			if (i instanceof Doboz && i.position.compareTo(innen)){
				return (Doboz) i;
			}				
		}
		return null;
	}
	
	public Merleg getMerleg(Pont innen){
		
		for (Ososztaly i : objects){
			if (i instanceof Merleg && i.position.compareTo(innen)){
				return (Merleg) i;
			}				
		}
		return null;
	}
	
	//Új objektum hozzaadasa a JATEKTER-hez
	public void add(Ososztaly uj){
		objects.add(uj);
	}
	
	//Objektum eltavolitasa - ha pl. szakadekba zuhant valami,
	//vagy osszegyujtottek a ZPM-et	
	public void remove(Ososztaly ezt){
		if (objects.contains(ezt))
			objects.remove(ezt);
	}
	
	//!TODO - out of date lett a kommentje
	//Irany iranyban levo mezo ellenorzese
	//nem lenne jobb ha ez static? - TG
	public Pont checkfield(Pont regihely, Pont ujhely, Szereplo sz){
		List<Pont> ellenzok = new ArrayList<Pont>();

		for (Iterator<Ososztaly> it = objects.iterator();it.hasNext(); ){
			Ososztaly i = it.next();
			if (i.position.compareTo(regihely) && (i instanceof Merleg)){
				i.ertesit(regihely,sz);
			}
			if (i.position.compareTo(ujhely)){
				Pont idemutat = i.ertesit(regihely,sz);
				if (!idemutat.compareTo(ujhely)) ellenzok.add(idemutat);
			}
		}
		objects.removeAll(removeQueue);
		removeQueue = new ArrayList<Ososztaly>();
		
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
