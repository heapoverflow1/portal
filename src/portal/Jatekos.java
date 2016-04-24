package portal;

public class Jatekos extends Ososztaly{
	Doboz doboz;
	Szin tolteny_szin;	
	int zpmcount;	
	Irany irany;
	static int weight = 1;
	
	/* Konstruktor
	 * Az Ezredes a jatek elejen jobbra all es kek toltenye van.
	 * Az EZREDES inicializalasa x, y koordinatakkal
	 */
	public Jatekos(int x, int y) {
		
		position = new Pont(x, y);
		tolteny_szin = Szin.KEK;
		zpmcount = 0;
		irany = Irany.JOBBRA;
		doboz = null;
		
	}
		
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		
		return position;
	}
	
	//!TODO - jobban leirni a mukodeset
	/* Ezredes mozgatasa irany iranyba
	 * irany valtozoja beallitasa
	 * Megprobal lepni az ezredes egyet az adott iranyba,
	 * majd megkeri a JATEKTER-et, hogy hivja meg az adott
	 * pozicion levo dolognak az ertesit fuggvenyet, ami visszater egy
	 * adott pozicioval a targytol fuggoen ( ha fal, akkor az a pozicio amit kapott)
	 */
	void move(Irany irany){	
		
		this.irany = irany;
		
		Pont ujhely = position;
		ujhely.move(irany);
		position = Jatek.palya.checkfield(position, ujhely);
		if (doboz != null) doboz.setPosition(position);
		
		
	}
	
	//!TODO - ezredes.finalize(), meg valahogy a jatek vege
	//Ezredes leesik, ezaltal meghal, vege a jateknak
	void fallAndDie(){
		
		
		
		//!TODO
		
			
	}
	
	
	//!TODO
	//Tolteny lovese
	/**HIBA: IDE SZERINTEM NEM KELL TOLTENY PARAMETERBEN, mert itt hozzuk letre
	 * @throws Throwable */
	void shoot(/*Tolteny t*/) throws Throwable{
		
		
		
		//ENNEK igy meg semmi ertelme, letrehozzuk majd el is tunik -WM
		//valahogy hasznalni kene
		Tolteny t1 = new Tolteny(tolteny_szin, position);
		t1.shoot(irany);
		
		
	}
	
	//!TODO - picit OUT OF DATE COMMENT
	//Doboz felemelese, kapott doboz isLifted ertekenek beallitasa igazra	
	/***HIBA: atadjuk a dobozt akkor melyik mozog? Mert akkor ugye lemasoljuk, referenciat kene adni*/
	void lift(){
		
		
		
		//ha mar van a kezeben doboz akkor visszater
		if (doboz != null){
			
			return;		
		}			
		
		//ha merlegen all, akkor a merleg stackjebol szedje le a legfelsot, egyebkent csak vegye fel a dobozt
		Merleg m = Jatek.palya.getMerleg(position);
		if(m != null){
			doboz=m.removeTopDoboz();
		}
		else{
			doboz = Jatek.palya.getDoboz(position);
		}
		doboz = Jatek.palya.getDoboz(position);
		
		if (doboz!=null)
			doboz.Lift();
		
	}
	
	// Doboz letevese, ezaltal az ezredes DOBOZ valtozojanak NULL-ra allitasa
	// parameter nem kell, ez a doboz az ezredes kezeben van - TG
	void drop(/*Doboz d*/){
		
		

		Pont newPosition=doboz.position;
		
		//a dobozt arra szeretnem elmozditani, amerre az ezredes nez
		newPosition.move(irany);
		
		//megnezem hogy merlegre teszi-e a dobozt
		Merleg m = Jatek.palya.getMerleg(newPosition);
		
		//ha falba akarnank tenni a dobozt, visszater
		//ha van mar doboz az uj pozicioban, es az nem merlegen all, akkor visszater
		//zpm-re se tegyuk
		for (Ososztaly i : Jatek.palya.objects){
			if (i.position.compareTo(newPosition) && (i instanceof Fal)){
				return;
			}
			else if(i.position.compareTo(newPosition) && (i instanceof Doboz) && (m == null)){
				return;
			}
			else if(i.position.compareTo(newPosition) && (i instanceof ZPM)){
				return;
			}
		}
		
		//ha eljutott idaig akkor mar biztos az uj pozicioba fog kerulni
		doboz.position=newPosition;
		
		//ha merlegre tesszuk, akkor hozzaadjuk a merleg stackjehez
		if(m != null){
			m.addDoboz(doboz);
		}
		
		doboz.Drop();
		doboz = null;
		
		
	}
	
	//Az ezredes felvett egy ZPM-et, a zpmcount novelese.
	void collectZPM(){
		
			
		zpmcount++;
		
	}
	
	//Visszaadja a ZPMCOUNT erteket
	/**NEM BIZTOS HOGY KELL, de lehet szebb lesz a kod tole -WM*/
	int getZPMcount(){
		
		
		return zpmcount;
	}
	
	//Tolteny valtasa
	void changeTolteny(){
		
		
		
		if (tolteny_szin ==  Szin.KEK)
			tolteny_szin = Szin.SARGA;
		

		if (tolteny_szin ==  Szin.SARGA)
			tolteny_szin = Szin.KEK;
		

		if (tolteny_szin ==  Szin.PIROS)
			tolteny_szin = Szin.ZOLD;
		

		if (tolteny_szin ==  Szin.ZOLD)
			tolteny_szin = Szin.PIROS;
		
		
		
	
	}
	
	//!TODO
	//Ezredes teleportalasa a masik csillagkapuhoz
	void teleport(Csillagkapu cs){
		
		
		
		//!TODO
		
		
		
	}

	@Override
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		// TODO Auto-generated method stub
		
	}
}
