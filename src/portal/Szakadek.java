package portal;

public class Szakadek extends Ososztaly {

	/*
	 * Konstruktor A SZAKADEK inicializalasa x, y koordinatakkal
	 */
	public Szakadek(int x, int y) {
		this.position = new Pont(x, y);
	}

	// Doboz megsemmisitése, ha beleesett
	void destroy(Doboz d) throws Throwable {
		Jatek.palya.remove(d);
		d.destroy();
	}

	// Ezredes megsemmisitése, ha beleesett
	void kill(Szereplo e) throws Throwable {
		Jatek.palya.remove(e);
		if (e.getClass().getSimpleName() == "Replikator") {
			e.fallAndDie();
			Jatek.palya.remove(this);
			this.finalize();
			//Replikator eseten megsemmisulunk
		} else {
			e.fallAndDie();
		}
	}

	//Ha rank kiserlne meg lepni egy szereplo, eltavolitjuk a jatekbol
	public Pont ertesit(Pont regi, Szereplo sz) {
		try {
			kill(sz);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return position;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		//A toltenyt nem semmisitjuk meg
	}
}
