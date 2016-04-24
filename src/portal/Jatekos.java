package portal;

public class Jatekos extends Ososztaly{
	Doboz doboz;
	boolean tolteny_kek;	
	int zpmcount;
	enum Irany{fel, le, jobbra, balra};
	Irany irany;
	static int weight=1;
	
	/* Konstruktor
	 * Az Ezredes a jatek elejen jobbra all es kek toltenye van.
	 * Az EZREDES inicializalasa x, y koordinatakkal
	 */
	public Jatekos(int x, int y) {
		
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
	 * irany valtozoja beallitasa
	 * Megprobal lepni az ezredes egyet az adott iranyba,
	 * majd megkeri a JATEKTER-et, hogy hivja meg az adott
	 * pozicion levo dolognak az ertesit fuggvenyet, ami visszater egy
	 * adott pozicioval a targytol fuggoen ( ha fal, akkor az a pozicio amit kapott)
	 */
	void move(Irany irany){	
		
		System.out.println(">Ezredes::move(Irany)");
		
		this.irany=irany;
		
		Pont ujhely = position;
		ujhely.move(irany);
		position = Jatek.palya.checkfield(position, ujhely);
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
		Tolteny t1 = new Tolteny(tolteny_kek, position);
		t1.shoot(irany);
		
		System.out.println("<Ezredes::shoot()");
	}
	
	//!TODO - picit OUT OF DATE COMMENT
	//Doboz felemelese, kapott doboz isLifted ertekenek beallitasa igazra	
	/***HIBA: atadjuk a dobozt akkor melyik mozog? Mert akkor ugye lemasoljuk, referenciat kene adni*/
	void lift(){
		
		System.out.println(">Ezredes::lift()");
		
		//ha mar van a kezeben doboz akkor visszater
		if (doboz != null){
			System.out.println("<Ezredes::lift()");
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
		System.out.println("<Ezredes::lift()");	
	}
	
	// Doboz letevese, ezaltal az ezredes DOBOZ valtozojanak NULL-ra allitasa
	// parameter nem kell, ez a doboz az ezredes kezeben van - TG
	void drop(/*Doboz d*/){
		
		System.out.println(">Ezredes::drop(Doboz)");

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
		
		System.out.println("<Ezredes::drop(Doboz)");
	}
	
	//Az ezredes felvett egy ZPM-et, a zpmcount novelese.
	void collectZPM(){
		
		System.out.println(">Ezredes::collectZPM()");		
		zpmcount++;
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
	void teleport(Csillagkapu cs){
		
		System.out.println(">Ezredes::teleport(Csillagkapu)");
		
		//!TODO
		
		System.out.println("<Ezredes::teleport(Csillagkapu)");
		
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
