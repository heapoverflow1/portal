package portal;

public class Tolteny extends Ososztaly{
	Szin szin;
	boolean alive = true;
	
	/* Konstruktor
	 * A TOLTENY inicializalasa blueType-ra
	 * !TODO 
	 * ez kell? x, y koordinatakkal -WM
	 * Beletettem, így van kezdopozicioja -WM
	 */
	public Tolteny(Szin sz, Pont pos) {
		
		szin = sz;
		position = pos;
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">Tolteny::ertesit(Pont)");
		System.out.println("<Tolteny::ertesit(Pont)");
		return position;
	}
	
	//!TODO
	void shoot(Irany irany) throws Throwable{
		
		
		//!TODO
		while (alive){
			Pont p= this.position;
			int y =0;
			 switch (irany) {
			 
			 case FEL: 
				 y = p.getY()+1;
				 p.setY(y); 
				 break;
				 
			 case LE:
				 y = p.getY()-1;
				 p.setY(y); 
				 break;
				 
			 case JOBBRA:
				 y = p.getX()+1;
				 p.setX(y); 
				 break;
				 
			 case BALRA:
				 y = p.getX()-1;
				 p.setX(y); 
				 break;
			 }
			
			Ososztaly elem=Jatek.palya.checkfield_shoot(p);
			elem.ertesit_shoot(this);
			
			if (alive)
			 position.move(irany);
			
		
		
		}
		this.finalize();
		
	}
	
	//!TODO
	void destroy(){
		System.out.println(">Tolteny::destroy()");
		
		//!TODO
		
		System.out.println("<Tolteny::destroy()");
		
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
	
	Szin getColor(){
		
		return szin;
	}

}
