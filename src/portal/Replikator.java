package portal;

public class Replikator extends Szereplo {

	public Replikator(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void fallAndDie() {
		try {
			Jatek.palya.removeQueue.add(this);
			//Jatek.palya.objects.remove(this);
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void ertesit_shoot(Tolteny t) {		
		t.destroy();
		//Jatek.palya.removeQueue.add(this);
		fallAndDie();
	}
	
	public String toString(){
		return "R "+position.toString();
	}
}
