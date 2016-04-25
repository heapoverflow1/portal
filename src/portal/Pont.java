package portal;

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

		
		this.x = x;

	}
	
	//Y beallitasa
	public void setY(int y){
		
		this.y = y;
	}
	
	//X visszaadasa
	public int getX(){
		
		return x;
	}
	
	//Y visszaadasa
	public int getY(){
		
		return y;
	}
	
	//!TODO - KOMMENT
	public void move(Irany irany){
	
		
		switch (irany){
		
			case JOBBRA:
				this.x += 1;
				break;
			
			case BALRA:
				this.x -= 1;
				break;
			
			case FEL:
				this.y -= 1;
				break;
			
			case LE:
				this.y += 1;
				break;
			
			default:
				break;
		}
	}
	
	public boolean compareTo(Pont masik){
		
		if (masik.x == this.x && masik.y == this.y){			
			return true;
		}else{			
			return false;
		}
	}
	
	public String toString(){
		return this.x+","+this.y;
	}

	
}
