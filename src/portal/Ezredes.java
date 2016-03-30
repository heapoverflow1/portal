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
	
	public Pont ertesit(Pont regi){
		System.out.println(">Ezredes::ertesit");
		System.out.println("<Ezredes::ertesit");
		return position;
	}
	
	//Ezredes mozgatasa
	void move(Irany irany){	
		System.out.println(">Ezredes::move");
		Pont ujhely = position;
		ujhely.move(irany);
		/*switch (irany)
		{
			case jobbra:
				ujhely.moveY(1);
			break;
			
			case balra:
				ujhely.moveY(-1);
			break;
			
			case fel:
				ujhely.moveX(-1);
			break;
			
			case le:
				ujhely.moveX(1);
			break;
			
			default:
			break;
		}*/
		position = main.palya.checkfield(position, ujhely);		//!TODO Ez jó igy? Pls check
		System.out.println("<Ezredes::move");
	}
	
	//Ezredes leesik, ezaltal meghal, vege a jateknak
	void fallAndDie(){}
	
	//Tolteny lovese
	/**HIBA: IDE SZERINTEM NEM KELL TOLTENY PARAMETERBEN, mert itt hozzuk letre*/
	void shoot(/*Tolteny t*/){
		Tolteny t1 = new Tolteny(tolteny_kek);
	}
	
	//Doboz felemelese, kapott doboz isLifted ertekenek beallitasa igazra	
	/***HIBA: atadjuk a dobozt akkor melyik mozog? Mert akkor ugye lemasoljuk, referenciat kene adni*/
	void lift(Doboz d){
		d.isLifted=true;
		doboz=d;
	}
	
	
	void drop(Doboz d){
		int x=d.position.getX();
		int y=d.position.getY();
		
		//doboz poziciojanak beallitasa, nem tul szep, de mukodik - TG
		if(irany==Irany.jobbra){
			d.position.setY(y+1);
		}
		else if(irany==Irany.balra){
			d.position.setY(y-1);
		}
		else if(irany==Irany.le){
			d.position.setX(x+1);
		}
		else if(irany==Irany.fel){
			d.position.setX(x-1);
		}		
		d.isLifted=false;
		//megkeresem az adott mezo poziciojat, es ertesitest kuldok oda - TG
		for(Ososztaly i:main.palya.objects){
			//HIBA: mi van ha nem a mezot talalom meg, hanem a dobozt amit odatettem? - TG
			if(i.position.compareTo(d.position)){
				//ez jelenleg csak akkor mukodik ha a doboz felemelesekor a doboz pozicioja megvaltozik
				//pl. ezredes doboz elott all es felveszi a dobozt - TG
				i.ertesit(d.position);
			}
		}
	}
	
	//Az ezredes felvett egy ZPM-et, a zpmcount novelese.
	void collectZPM(){
		zpmcount++;
	}
	
	//Visszaadha a ZPMCOUNT erteket
	/**NEM BIZTOS HOGY KELL, de lehet szebb lesz a kod tole -WM*/
	int getZPMcount(){
		return zpmcount;
	}
	
	//Tolteny valtasa
	void changeTolteny(){
		if (tolteny_kek)
			tolteny_kek = false;
		else
			tolteny_kek = true;
	}
	
	//Ezredes teleportalasa a masik csillagkapuhoz
	//!TODO
	void teleport(SpecFal s){}
}
