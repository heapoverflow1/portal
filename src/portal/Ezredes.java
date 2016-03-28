package portal;

public class Ezredes extends Ososztaly{
	Doboz doboz;
	boolean tolteny_kek;	
	int zpmcount;
	enum Irany{fel, le, jobbra, balra};
	Irany irany;	
	
	//Konstruktor
	public Ezredes() {
		tolteny_kek = true;
		zpmcount = 0;
		irany = Irany.jobbra;
		doboz = null;
		/*Az Ezredes a játék elején jobbra áll és kék tölténye van.*/
	}
	
	//Ezredes mozgatása
	void move(Irany irany){	
		
	}
	
	//Ezredes leesik, ezáltal meghal, vége a játéknak
	void fallAndDie(){}
	
	//Töltény lövése
	/**HIBA: IDE SZERINTEM NEM KELL TOLTENY PARAMETERBEN, mert itt hozzuk letre*/
	void shoot(/*Tolteny t*/){
		Tolteny t1 = new Tolteny(tolteny_kek);
	}
	
	//Doboz felemelése, kapott doboz isLifted értékének beállítása igazra	
	/***HIBA: átadjuk a dobozt akkor melyik mozog? Mert akkor ugye lemásoljuk, referenciát kéne adni*/
	void lift(Doboz d){
		d.isLifted=true;
	}
	
	
	void drop(Doboz d){
		d.isLifted=false;
	}
	
	//Az ezredes felvett egy ZPM-et, a zpmcount növelése.
	void collectZPM(){
		zpmcount++;
	}
	
	//Töltény váltása
	void changeTolteny(){
		if (tolteny_kek)
			tolteny_kek = false;
		else
			tolteny_kek = true;
	}
	
	//Ezredes teleportálása a másik csillagkapuhoz
	void teleport(SpecFal s){}
}
