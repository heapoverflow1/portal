package portal;

public class Ezredes extends Ososztaly{
	Doboz doboz;
	boolean tolteny_kek;	
	int zpmcount;
	enum Irany{fel, le, jobbra, balra};
	Irany irany;	
	
	/* Konstruktor
	 * Az Ezredes a jatek elejen jobbra all es kek toltenye van.
	 * Az EZREDES inicializalasa x, y koordinatakkal
	 */
	public Ezredes(int x, int y) {
		
		position = new Pont(x, y);
		tolteny_kek = true;
		zpmcount = 0;
		irany = Irany.jobbra;
		doboz = null;
		
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">Ezredes::ertesit(Pont)");
		System.out.println("<Ezredes::ertesit(Pont)");
		return position;
	}
	
	//!TODO - jobban leirni a mukodeset
	/* Ezredes mozgatasa irany iranyba
	 * Megprobal lepni az ezredes egyet az adott iranyba,
	 * majd megkeri a JATEKTER-et, hogy hivja meg az adott
	 * pozicion levo dolognak az ertesit fuggvenyet, ami visszater egy
	 * adott pozicioval a targytol fuggoen ( ha fal, akkor az a pozicio amit kapott)
	 */
	void move(Irany irany){	
		
		System.out.println(">Ezredes::move(Irany)");
		
		Pont ujhely = position;
		ujhely.move(irany);
		position = main.palya.checkfield(position, ujhely);
		if (doboz != null) doboz.setPosition(position);
		
		System.out.println("<Ezredes::move(Irany)");
	}
	
	//!TODO - ezredes.finalize(), meg valahogy a jatek vege
	//Ezredes leesik, ezaltal meghal, vege a jateknak
	void fallAndDie(){
		
		System.out.println(">Ezredes::fallAndDie()");
		
		//!TODO
		
		System.out.println("<Ezredes::fallAndDie()");		
	}
	
	
	//!TODO
	//Tolteny lovese
	/**HIBA: IDE SZERINTEM NEM KELL TOLTENY PARAMETERBEN, mert itt hozzuk letre*/
	void shoot(/*Tolteny t*/){
		
		System.out.println(">Ezredes::shoot()");
		
		//ENNEK igy meg semmi ertelme, letrehozzuk majd el is tunik -WM
		//valahogy hasznalni kene
		Tolteny t1 = new Tolteny(tolteny_kek);
		
		System.out.println("<Ezredes::shoot()");
	}
	
	//!TODO - picit OUT OF DATE COMMENT
	//Doboz felemelese, kapott doboz isLifted ertekenek beallitasa igazra	
	/***HIBA: atadjuk a dobozt akkor melyik mozog? Mert akkor ugye lemasoljuk, referenciat kene adni*/
	void lift(){
		
		System.out.println(">Ezredes::lift()");
		
		if (doboz != null){
			System.out.println("<Ezredes::lift()");
			return;		
		}			
		
		doboz = main.palya.getDoboz(position);
		
		if (doboz!=null)
			doboz.Lift();
		System.out.println("<Ezredes::lift()");	
	}
	
	// Doboz letevese, ezaltal az ezredes DOBOZ valtozojanak NULL-ra allitasa	
	void drop(Doboz d){
		
		System.out.println(">Ezredes::drop(Doboz)");
		
		int x = d.position.getX();
		int y = d.position.getY();
		
		//doboz poziciojanak beallitasa, nem tul szep, de mukodik - TG
		if(irany == Irany.jobbra){
			d.position.setY(y + 1);
		}
		else if(irany == Irany.balra){
			d.position.setY(y - 1);
		}
		else if(irany == Irany.le){
			d.position.setX(x + 1);
		}
		else if(irany == Irany.fel){
			d.position.setX(x - 1);
		}		
		d.Drop();
		
		//megkeresem az adott mezo poziciojat, es ertesitest kuldok oda - TG
		for(Ososztaly i:main.palya.objects){
			
			//HIBA: mi van ha nem a mezot talalom meg, hanem a dobozt amit odatettem? - TG
			if(i.position.compareTo(d.position)){
				
				//ez jelenleg csak akkor mukodik ha a doboz felemelesekor a doboz pozicioja megvaltozik
				//pl. ezredes doboz elott all es felveszi a dobozt - TG
				i.ertesit(d.position);
			}
		}
		doboz = null;
		
		System.out.println("<Ezredes::drop(Doboz)");
	}
	
	//Az ezredes felvett egy ZPM-et, a zpmcount novelese.
	void collectZPM(){
		
		System.out.println(">Ezredes::collectZPM()");		
		zpmcount++;
		System.out.println("<Ezredes::collectZPM()");
	}
	
	//Visszaadha a ZPMCOUNT erteket
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
	void teleport(Csillagkapu cs){
		
		System.out.println(">Ezredes::teleport(Csillagkapu)");
		
		//!TODO
		
		System.out.println("<Ezredes::teleport(Csillagkapu)");
		
	}
}
