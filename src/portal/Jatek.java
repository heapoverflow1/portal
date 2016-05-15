package portal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Jatek {
	static Jatekter palya;
	
	private static View view;
	
	private static final Irany JOBBRA = Irany.JOBBRA;
	static Jatekos E = new Jatekos(1, 2, Szin.KEK);
	static Jatekos Jaffa = new Jatekos(1, 1, Szin.ZOLD);
	static Replikator R = new Replikator(3,3);
	
	public static void listSzereplo(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Szereplok:");
		for (Ososztaly i : ref){
			if(i.getClass() == Jatekos.class || i.getClass()== Replikator.class)
				System.out.println(i.toString());		
		}
	}
	public static void listZPM(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("ZPM-ek:");
		for (Ososztaly i : ref){
			if(i.getClass() == ZPM.class)
				System.out.println(i.position.toString());		
		}
	}
	public static void listFal(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Falak:");
		for (Ososztaly i : ref){
			if(i.getClass() == Fal.class){
				System.out.println(i.position.toString());
			}
		}			
	}
	
	public static void listSpecfal(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Specfalak:");
		for (Ososztaly i : ref){
			if(i.getClass() == SpecFal.class){
				System.out.println(i.position.toString());
			}
		}			
	}
	
	public static void listDoboz(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Dobozok:");
		for (Ososztaly i : ref){
			if(i.getClass() == Doboz.class){
				System.out.println(i.position.toString());
			}
		}			
	}
	
	public static void listSzakadek(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Szakadekok:");
		for (Ososztaly i : ref){
			if(i.getClass() == Szakadek.class){
				System.out.println(i.position.toString());
			}
		}			
	}
	
	public static void listMerlegek(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Meglegek:");
		for (Ososztaly i : ref){
			if(i.getClass() == Merleg.class){
				System.out.println(i.position.toString());
			}
		}			
	}
	
	public static void listAjto(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Ajtok:");
		for (Ososztaly i : ref){
			if(i.getClass() == Ajto.class){
				System.out.println(i.toString());
			}
		}			
	}
	
	public static void listCsillagkapu(){
		System.out.println("Csillagkapuk:");
		System.out.println(palya.kapumgr.toString());
	}
	
	public static Irany getDirFromString(String pms){
		Irany dir = Irany.JOBBRA;
		if (pms.compareToIgnoreCase("j")==0){
			dir = Irany.JOBBRA;
		}else if (pms.compareToIgnoreCase("b")==0){
			dir = Irany.BALRA;
		}else if (pms.compareToIgnoreCase("f")==0){
			dir = Irany.FEL;
		}else if (pms.compareToIgnoreCase("l")==0){
			dir = Irany.LE;
		}
		return dir;
	}
	
	public static Szin getColorFromString(String pms){
		Szin clr = Szin.KEK;
		if (pms.compareToIgnoreCase("s")==0){
			clr = Szin.SARGA;
		}else if (pms.compareToIgnoreCase("z")==0){
			clr = Szin.ZOLD;
		}else if (pms.compareToIgnoreCase("p")==0){
			clr = Szin.PIROS;
		}else if (pms.compareToIgnoreCase("k")==0){
			clr = Szin.KEK;
		}
		return clr;		
	}
	
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    
		//TODO!! Pályaválasztás most konzolon, ennek is kellene grafikus felület!
	    
	    boolean palyaLoaded = false;
	    palya = new Jatekter();
	    view = new View(palya);
	    palya.setHeight(10);
	    palya.setWidth(10);
	    
	    //Egyelõre a pályák a teszteseteknek megfelelõek
	    while ((s = in.readLine()) != null && s.length() != 0){
	    	if (palyaLoaded) break;
	    	
	    	String[] params = s.split(" ");
    		if (params[0].compareTo("moveTest")==0){
    			//System.out.println("MoveTest loaded!");
    			E.position=new Pont(1, 1);
    			palya.add(E);
    			palya.add(new Fal(1, 2));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("shootAndHitTest")==0){
    			E.position=new Pont(1, 1);
    			palya.add(E);
    			palya.add(new Fal(0, 1));
    			palya.add(new SpecFal(1, 3, palya.kapumgr));
    			palya.add(new SpecFal(1, 0, palya.kapumgr));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("cratePickUpTest")==0){
    			E.position=new Pont(0, 1);
    			palya.add(E);
    			palya.add(new Doboz(1, 2));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("crateDropDownTest")==0){
    			E.position=new Pont(0, 1);
    			palya.add(E);
    			palya.add(new Doboz(1, 2));
    			palya.add(new Fal(1, 4));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("teleportTest")==0){
    			E.position=new Pont(1, 3);
    			palya.add(E);
    			SpecFal egyik = new SpecFal(1, 4, palya.kapumgr);
    			SpecFal masik = new SpecFal(1, 0, palya.kapumgr);
    			palya.add(egyik);
    			palya.add(masik);
    			palya.kapumgr.SetCsk(egyik, Szin.KEK);
    			palya.kapumgr.SetCsk(masik, Szin.SARGA);
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("dieTest")==0){
    			E.position=new Pont(1, 1);
    			Jaffa.position=new Pont(3,3);
    			palya.add(E);
    			palya.add(Jaffa);
    			palya.add(new Szakadek(1, 2));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("cratedestroyTest")==0){
    			E.position=new Pont(1, 0);
    			palya.add(E);
    			palya.add(new Szakadek(1, 3));
    			palya.add(new Doboz(1, 2));
    			palya.add(new Doboz(3, 3));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("scalePushDoorOpenTest")==0){
    			E.position=new Pont(1, 1);
    			palya.add(E);
    			Ajto door = new Ajto(1, 7);
    			Merleg scale = new Merleg(1,3,door,1);
    			palya.add(door);
    			palya.add(scale);
    			palya.add(new Doboz(1,2,5));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("zpmTest")==0){
    			E.position=new Pont(1, 1);
    			palya.add(E);
    			palya.add(new ZPM(1,2));
    			palya.add(new ZPM(1,9));
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("replicatorShotTest")==0){
    			E.position=new Pont(1, 1);
    			palya.add(E);
    			R.position=new Pont(1,3);
    			palya.add(R);
    			palyaLoaded = true;
    		}
    		else if (params[0].compareTo("replicatorFallTest")==0){
    			E.position=new Pont(1, 1);
    			palya.add(E);
    			R.position=new Pont(3,3);
    			palya.add(R);
    			palya.add(new Szakadek(1,2));
    			palya.add(new Szakadek(3,5));
    			palyaLoaded = true;
    		}
    	}
		
	    if (!palyaLoaded) return;
	    
	    view.Init();
		
	    int pressedKey = in.read();
	    while (true){
	    	//System.out.println(pressedKey);
	    	if (pressedKey=='a'){
	    		E.move(Irany.BALRA);
	    	}
	    	else if (pressedKey=='w'){
	    		E.move(Irany.FEL);
	    	}
	    	else if (pressedKey=='s'){
	    		E.move(Irany.LE);
	    	}
	    	else if (pressedKey=='d'){
	    		E.move(Irany.JOBBRA);
	    	}
	    	
	    	view.Update();
	    	pressedKey = in.read();
	    }
	}
	
	public void keyPressed(KeyEvent e){
		//TODO!!		
		view.Update();
	}
}
