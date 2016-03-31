package portal;

import portal.Ezredes.Irany;

public class Pont {
	private int x, y;
	
	/* DEFAULT Konstruktor
	 * A PONT inicializalasa -1, -1 koordinatakkal
	 */
	public Pont(){
		x = -1;
		y = -1;
	}
	
	/* Konstruktor
	 * A PONT inicializalasa x, y koordinatakkal
	 */
	public Pont(int x, int y){		
		this.x = x;
		this.y = y;		
	}
	
	
	//X beallitasa
	public void setX(int x){
		
		System.out.println(">Pont::setX(int)");
		
		this.x = x;
		
		System.out.println("<Pont::setX(int)");
	}
	
	//Y beallitasa
	public void setY(int y){
		
		System.out.println(">Pont::setY(int)");
		
		this.y = y;
		
		System.out.println("<Pont::setY(int)");
	}
	
	//X visszaadasa
	public int getX(){
		
		System.out.println(">Pont::getX()");		
		System.out.println("<Pont::getX()");
		
		return x;
	}
	
	//Y visszaadasa
	public int getY(){
		
		System.out.println(">Pont::getY()");		
		System.out.println("<Pont::getY()");
		return y;
	}
	
	//!TODO - KOMMENT
	public void move(Irany irany){
		
		System.out.println(">Pont::move(Irany)");
		
		switch (irany){
		
			case jobbra:
				this.y += 1;
				break;
			
			case balra:
				this.y -= 1;
				break;
			
			case fel:
				this.x -= 1;
				break;
			
			case le:
				this.x += 1;
				break;
			
			default:
				break;
		}
		
		System.out.println("<Pont::move(Irany)");
	}
	
	public boolean compareTo(Pont masik){
		System.out.println(">Pont::compareTo(Pont)");
		
		if (masik.x == this.x && masik.y == this.y){			
			System.out.println("<Pont::compareTo(Pont)");		
			return true;
		}else{			
			System.out.println("<Pont::compareTo(Pont)");
			return false;
		}
	}

	
}
