package portal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ezredes extends Ososztaly{
	Doboz doboz;
	boolean tolteny_kek;	
	int zpmcount;
	enum Irany{fel, le, jobbra, balra};
	Irany irany;
	static int weight=1;
	private Tolteny t1 = new Tolteny(tolteny_kek, position);
	Merleg m;
	Ajto a;
	

		
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">Ezredes::ertesit(Pont)");
		System.out.println("<Ezredes::ertesit(Pont)");
		return null;
	}
	
	//!TODO - jobban leirni a mukodeset
	/* Ezredes mozgatasa irany iranyba
	 * irany valtozoja beallitasa
	 * Megprobal lepni az ezredes egyet az adott iranyba,
	 * majd megkeri a JATEKTER-et, hogy hivja meg az adott
	 * pozicion levo dolognak az ertesit fuggvenyet, ami visszater egy
	 * adott pozicioval a targytol fuggoen ( ha fal, akkor az a pozicio amit kapott)
	 */
	void move(Irany irany) throws IOException{	
		
		
		System.out.println("Merre fele mozogjon az ezredes ? (F/L/J/B)");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    s=in.readLine();
	    
	    switch(s){	
	    
	    case "f" : System.out.println("Felfele mozdult az ezredes!");
	    			break;
	    			
	    case "l" : System.out.println("Lefele mozdult az ezredes!");
	    			break;
	    
	    case "j" : System.out.println("Jobbra mozdult az ezredes!");
	    			break;
	    			
	    case "b" : System.out.println("Balra mozdult az ezredes!");
					break;
	    
	    
	    
	    }
	    
	    System.out.println("Szakadékbe Léptél ?");
	    s=in.readLine();
	    if( s=="i")
	    	this.fallAndDie();
	    else if ( s=="n")
	    	System.out.println("Az válaszott irányba léptél!");
	    
	    System.out.println("Csillagkapuba léptél ?");
	    s=in.readLine();
	    if(s=="i")
	    	this.teleport();
	    else if (s=="n"){	
	    	System.out.println("Mérlegre léptél ?");
	    	s=in.readLine();
	    	if(s=="i")
	    		m.weighted();
	    	else if (s=="n")
	    		System.out.println("Nem történt semmi különleges akció");
	    		
	    
	    
	    }
	    
	    
	    
		
		
		
		
	}
	
	//!TODO - ezredes.finalize(), meg valahogy a jatek vege
	//Ezredes leesik, ezaltal meghal, vege a jateknak
	void fallAndDie(){
		
		System.out.println(">Ezredes::fallAndDie()");
		
		}
	
	
	//!TODO
	//Tolteny lovese
	/**HIBA: IDE SZERINTEM NEM KELL TOLTENY PARAMETERBEN, mert itt hozzuk letre*/
	void shoot(){
		
		System.out.println(">Ezredes::shoot()");
		
		//ENNEK igy meg semmi ertelme, letrehozzuk majd el is tunik -WM
		//valahogy hasznalni kene
		
		this.t1.shoot();
		
		
	}
	
	//!TODO - picit OUT OF DATE COMMENT
	//Doboz felemelese, kapott doboz isLifted ertekenek beallitasa igazra	
	/***HIBA: atadjuk a dobozt akkor melyik mozog? Mert akkor ugye lemasoljuk, referenciat kene adni
	 * @throws IOException */
	void lift() throws IOException{
		
		System.out.println(">Ezredes::lift()");
		
		//ha mar van a kezeben doboz akkor visszater

		System.out.println("Van a kezünkben már doboz?(I/N)");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    s=in.readLine();
	    if (s=="i")
	    	System.out.println("Nem tudjuk felvenni, már van a kezünkben doboz!");
	    else if (s=="n"){
	    	System.out.println("Mérlegen volt a doboz!");
		
		
		//ha merlegen all, akkor a merleg stackjebol szedje le a legfelsot, egyebkent csak vegye fel a dobozt
		
	    	s=in.readLine();
		if(s == "i"){
			doboz=this.m.removeTopDoboz();
		}
		else if (s=="n"){
			doboz = Jatek.palya.getDoboz(position);
		}
		doboz = Jatek.palya.getDoboz(position);
		
		
			this.doboz.Lift();
		System.out.println("<Ezredes::lift()");	
	}
	}
	
	// Doboz letevese, ezaltal az ezredes DOBOZ valtozojanak NULL-ra allitasa
	// parameter nem kell, ez a doboz az ezredes kezeben van - TG

	void drop() throws Throwable{

		
		System.out.println(">Ezredes::drop(Doboz)");
		
		System.out.println("Letehetem ide a dobozt ?");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    s=in.readLine();
	    if (s=="i"){
	    	System.out.println("Van-e itt valami ? Szakadék? Mérleg? Üres?(s/m/u)");
	    	String s1;	
	    	s1=in.readLine();
	    		switch(s1)
	    		{
	    			
	    		case "s": doboz.destroy();	
	    					break;
	    		case "m" : System.out.println("Mérleg lenyomódott, ajtó kinyílt!");
	    					a.open();
	    				break;
	    		case "u" : doboz.Drop();
	    				break;
	    		}
	    	
	    	
	    	
	    	
	    }
	    
	    else if( s=="n")
	    	System.out.println("Ide nem tudjuk letenni a dobozt!");
	    	
	    	
	    	
	    	
	    	
		
		
		System.out.println("<Ezredes::drop(Doboz)");
	}
	
	//Az ezredes felvett egy ZPM-et, a zpmcount novelese.
	void collectZPM(){
		
		System.out.println(">Ezredes::collectZPM()");		
		zpmcount++;
		System.out.println("Növeltük a ZPM számot!");
		System.out.println("<Ezredes::collectZPM()");
	}
	
	//Visszaadja a ZPMCOUNT erteket
	/**NEM BIZTOS HOGY KELL, de lehet szebb lesz a kod tole -WM*/
	int getZPMcount(){
		
		System.out.println(">Ezredes::getZPMcount()");
		System.out.println("<Ezredes::getZPMcount()");
		return zpmcount;
	}
	
	//Tolteny valtasa
	void changeTolteny(){
		
		System.out.println(">Ezredes::changeTolteny()");
		
		if (tolteny_kek)
			tolteny_kek = false;
		else
			tolteny_kek = true;
		
		System.out.println("<Ezredes::changeTolteny()");
	}
	
	//!TODO
	//Ezredes teleportalasa a masik csillagkapuhoz
	void teleport(){
		
		System.out.println(">Ezredes::teleport(Csillagkapu)");
		
		
		
		System.out.println("<Ezredes::teleport(Csillagkapu)");
		
	}
}
