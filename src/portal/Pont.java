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
		System.out.println(">Pont::konstruktor");	
		this.x = x;
		this.y = y;
		System.out.println("<Pont::konstruktor");
	}
	
	
	//X beallitasa
	public void setX(int x){
		System.out.println(">Pont::setX");
		this.x = x;
		System.out.println("<Pont::setX");
	}
	
	//Y beallitasa
	public void setY(int y){
		System.out.println(">Pont::setY");
		this.y = y;
		System.out.println("<Pont::setY");
	}
	
	//X visszaadasa
	public int getX(){
		System.out.println(">Pont::getX");
		
		System.out.println("<Pont::getX");
		return x;
	}
	
	//Y visszaadasa
	public int getY(){
		System.out.println(">Pont::getY");
		
		System.out.println("<Pont::getY");
		return y;
	}
	
	public void move(Irany irany){
		switch (irany)
		{
			case jobbra:
				this.y+=1;
			break;
			
			case balra:
				this.y-=1;
			break;
			
			case fel:
				this.x-=1;
			break;
			
			case le:
				this.x+=1;
			break;
			
			default:
			break;
		}
	}
	
	//Mozgatas Y iranyban
	public void moveY(int amount){
		this.y = this.y + amount;
	}
	
	//Mozgatas X iranyban
	public void moveX(int amount){
		this.x = this.x + amount;
	}
	
	
	public boolean compareTo(Pont masik){
		if (masik.x == this.x && masik.y == this.y) return true;
		return false;
	}

	
}
