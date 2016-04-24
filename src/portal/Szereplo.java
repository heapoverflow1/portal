package portal;

public abstract class Szereplo extends Ososztaly {
	Irany irany;	
	
	public Szereplo(int x, int y){
		position = new Pont(x, y);
		irany = Irany.JOBBRA;
	}
	
	public void move (Irany i){		
			
	}
	
	public void fallAndDie(){
		
		
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
