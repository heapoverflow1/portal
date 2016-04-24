package portal;

public class Jatek {
	static Jatekter palya;
	
	public static void main(String[] args){
		palya = new Jatekter();
		
		/*  EZREDESt hozunk letre (a SARGA szin meghatarozza)
		 *  es hozzadjuk a palyalistahoz
		 */
		palya.add(new Jatekos(1,1, Szin.SARGA));
		
		/*  JAFFAt hozunk letre (a ZOLD szin meghatarozza)
		 *  es hozzaadjuk a palyalistahoz
		 */
		palya.add(new Jatekos(2,2, Szin.ZOLD));
		
		/*  REPLIKATORt hozunk letre
		 *  es hozzaadjuk a palyalistahoz
		 */
		palya.add(new Replikator(3, 3));
		
		//!TODO - JATEKTER VÉGTELEN CIKLUSAT MEGIRNI
		
	}
}
