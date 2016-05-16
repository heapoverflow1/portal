package portal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Jatekter {
	List<Ososztaly> objects;
	public Csillagkapu kapumgr;
	public List<Ososztaly> removeQueue;
	int width;
	int height;
	private boolean ZPMspawn = false;
	
	/* Konstruktor
	 * A JATEKTER inicializalasa, az objects lista letrehozasa
	 */
	public Jatekter() {		
		objects = new ArrayList<Ososztaly>();
		removeQueue = new ArrayList<Ososztaly>();
		kapumgr = new Csillagkapu();
		ZPMspawn=false;
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
		for (Ososztaly o : removeQueue){
			if (o.getClass()==ZPM.class) ZPMCollected();
		}
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
	
	public void removeAll(){
		objects.removeAll(objects);
		removeQueue.removeAll(removeQueue);
		ZPMspawn=false;
	}
	
	private boolean IsEmpty(Pont pos){
		for (Ososztaly i : objects){
			if (i.position.compareTo(pos)) return false;
		}
		return true;
	}
	
	public void ZPMCollected(){
		if (ZPMspawn){
			Random rand = new Random();
			int randX;
			int randY;
			do{
				randX = rand.nextInt(width);
				randY = rand.nextInt(height);
			}while(!IsEmpty(new Pont(randX, randY)));
			add(new ZPM(randX, randY));
			ZPMspawn=false;
		}
		else{
			ZPMspawn=true;
		}
	}
}
