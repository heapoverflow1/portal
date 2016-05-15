package portal;

import java.util.Random;
import java.util.TimerTask;

public class ReplicatorMover extends TimerTask {

	@Override
	public void run() {
		Random rand = new Random();
		int  n = rand.nextInt(4);
		Irany ir = Irany.BALRA;
		if (n==1) ir = Irany.JOBBRA;
		else if (n==2) ir = Irany.FEL;
		else if (n==3) ir = Irany.LE;
		Jatek.rep.move(ir);
	}
	
}
