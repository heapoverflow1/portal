package portal;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jatek {
	static Jatekter palya;
	
	private static View view;
	
	private static final Irany JOBBRA = Irany.JOBBRA;
	static Jatekos E = new Jatekos(1, 2, Szin.KEK);
	static Jatekos Jaffa = new Jatekos(1, 1, Szin.ZOLD);
	static Replikator R = new Replikator(3,3);
	
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
	    
	    boolean palyaLoaded = false;
	    palya = new Jatekter();
	    view = new View(palya);
	    
	    
	    System.out.println("Adja meg a palya nevet! (firstPalya, vagy a tesztek)");
	   
	    //Egyelõre a pályák a teszteseteknek megfelelõek
	    //TODO!! Pályaválasztás most konzolon, ennek is kellene grafikus felület!
	    //TODO!! Pályaválasztás fájlból jöjjön, ne a tesztesetekbõl!
	    	//Prototípus koncepctiója, 8. oldal
	    	// https://docs.google.com/document/d/1AlShs6EGiQgDOT84soCT99QxKwG4psa0ydMddu_yyCU/edit
	    while ((s = in.readLine()) != null && s.length() != 0){ 	    	
	    	
	    	String[] params = s.split(" ");
	    	if (params[0].compareTo("firstPalya")==0){
	    		for (int i=0;i<10;i++){
	    			palya.add(new Fal(i, 0));
	    			palya.add(new Fal(i, 9));
	    		}
	    		for (int j=1;j<9;j++){
	    			palya.add(new Fal(0, j));
	    			palya.add(new Fal(9, j));
	    		}
	    		E.position=new Pont(1, 1);
	    		Jaffa.position=new Pont(8,6);
	    		palya.add(E);
	    		palya.add(Jaffa);
	    		palya.add(new Doboz(3, 2));
	    		SpecFal egyik = new SpecFal(3, 4, palya.kapumgr);
	    		SpecFal masik = new SpecFal(6, 8, palya.kapumgr);
    			palya.add(egyik);
    			palya.add(masik);
    			//palya.kapumgr.SetCsk(egyik, Szin.KEK);
    			//palya.kapumgr.SetCsk(masik, Szin.SARGA);
    			Ajto door = new Ajto(1, 7);
    			palya.add(new Fal(2, 7));
    			palya.add(new Fal(3, 7));
    			palya.add(new Fal(3, 8));
    			palya.add(new ZPM(2, 8));
    			Merleg scale = new Merleg(1,3,door,1);
    			palya.add(door);
    			palya.add(scale);
    			palya.add(new Doboz(1,2,5));
    			palya.add(new Szakadek(6,7));
    			palya.add(new Fal(4,7));
    			palya.add(new Fal(5,7));
    			palya.add(new Fal(7,7));
    			palya.add(new Fal(8,7));
    			palya.add(new Fal(9,7));
    			palya.add(new ZPM(8, 8));
    			palya.add(new ZPM(4, 8));
    			palya.add(new SpecFal(6, 3, palya.kapumgr));
    			palya.add(new SpecFal(8, 4, palya.kapumgr));
    			palyaLoaded=true;
	    	}
    		if (params[0].compareTo("moveTest")==0){
    			//System.out.println("MoveTest loaded!");
    			E.position=new Pont(1, 1);
    			palya.add(E);
    			Jaffa.position = new Pont(1,3);
    			palya.add(Jaffa);
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
    		
    		if (palyaLoaded) break;	
    		else System.out.println("Nem ismerem fel a palya nevet! Probald ujra!");
    	}
		
	    if (!palyaLoaded) return;
	    
	    System.out.println("Palya betoltese...");
	    palya.setHeight(10);
	    palya.setWidth(10);
	    
	    view.Init();
<<<<<<< HEAD
		
//	    //TODO!! NE a konzolon egy ciklusban nézzük az irányítást, hanem rendesen KeyEvent szarokkal!
//	    int pressedKey = ' ';
//	    while (true){
//	    	if (pressedKey=='a'){
//	    		E.move(Irany.BALRA);
//	    	}
//	    	else if (pressedKey=='w'){
//	    		E.move(Irany.FEL);
//	    	}
//	    	else if (pressedKey=='s'){
//	    		E.move(Irany.LE);
//	    	}
//	    	else if (pressedKey=='d'){
//	    		E.move(Irany.JOBBRA);
//	    	}
//	    	
//	    	view.Update();
//	    	pressedKey = in.read();
//	    }
	}
	
=======
	}
	
	
>>>>>>> refs/remotes/origin/master
}
