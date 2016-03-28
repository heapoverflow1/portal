package portal;

public class Ezredes extends Ososztaly{
	Doboz doboz;
	boolean tolteny_kek;	
	int zpmcount;
	enum Irany{fel, le, jobbra, balra};
	Irany irany;	
	
	/* Konstruktor
	 * Az Ezredes a j�t�k elej�n jobbra �ll �s k�k t�lt�nye van.
	 * Az EZREDES inicializ�l�sa x, y koordin�t�kkal
	 */
	public Ezredes(int x, int y) {
		
		position = new Pont(x, y);
		tolteny_kek = true;
		zpmcount = 0;
		irany = Irany.jobbra;
		doboz = null;
		
	}
	
	//Ezredes mozgat�sa
	void move(Irany irany){	
		System.out.println(">Ezredes::move");
		main.palya.checkfield(irany);		//!TODO Ez j� �gy? Pls check
		System.out.println("<Ezredes::move");
	}
	
	//Ezredes leesik, ez�ltal meghal, v�ge a j�t�knak
	void fallAndDie(){}
	
	//T�lt�ny l�v�se
	/**HIBA: IDE SZERINTEM NEM KELL TOLTENY PARAMETERBEN, mert itt hozzuk letre*/
	void shoot(/*Tolteny t*/){
		Tolteny t1 = new Tolteny(tolteny_kek);
	}
	
	//Doboz felemel�se, kapott doboz isLifted �rt�k�nek be�ll�t�sa igazra	
	/***HIBA: �tadjuk a dobozt akkor melyik mozog? Mert akkor ugye lem�soljuk, referenci�t k�ne adni*/
	void lift(Doboz d){
		d.isLifted=true;
	}
	
	
	void drop(Doboz d){
		d.isLifted=false;
	}
	
	//Az ezredes felvett egy ZPM-et, a zpmcount n�vel�se.
	void collectZPM(){
		zpmcount++;
	}
	
	//T�lt�ny v�lt�sa
	void changeTolteny(){
		if (tolteny_kek)
			tolteny_kek = false;
		else
			tolteny_kek = true;
	}
	
	//Ezredes teleport�l�sa a m�sik csillagkapuhoz
	void teleport(SpecFal s){}
}
