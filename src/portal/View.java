package portal;

import java.util.ArrayList;
import java.util.List;

public class View {
	Jatekter jatekter;
	public View(Jatekter j){
		jatekter = j;
	}
	public void Init(){}
	
	public void Update(){
		//TODO!! Jelenítse meg, ne a konzolra írja ki
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = jatekter.getObjects();
		
		char[][] palya = new char[jatekter.getWidth()][jatekter.getHeight()];
		for (int i=0;i<jatekter.getWidth(); i++){
			for (int j=0;j<jatekter.getHeight();j++){
				palya[i][j]=' ';
			}
		}
		
		for (Ososztaly i : ref){
			char abra = ' ';
			if(i.getClass() == Ajto.class){
				abra='a';
			}else if (i.getClass()==Doboz.class){
				abra='d';
			}
			else if (i.getClass()==Jatekos.class){
				abra='J';
			}
			else if (i.getClass()==Szakadek.class){
				abra='x';
			}
			else if (i.getClass()==Merleg.class){
				abra='m';
			}
			else if (i.getClass()==Fal.class){
				abra='O';
			}
			palya[i.position.getX()][i.position.getY()] = abra;
		}
		
		System.out.println("-----------");
		for (int i=0;i<jatekter.getWidth(); i++){
			System.out.print("|");
			for (int j=0;j<jatekter.getHeight();j++){
				System.out.print(palya[j][i]);
			}
			System.out.println("|");
		}
		System.out.println("-----------");
	}
}
