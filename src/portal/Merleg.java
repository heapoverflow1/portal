package portal;

import java.util.Stack;

public class Merleg extends Ososztaly implements Ertesit{
	Ajto nyitando;
	Stack<Doboz> dobozok=new Stack<Doboz>();
	int currentWeight=0;
	int openWeight;
	
	/* Konstruktor
	 * A MERLEG inicializalasa x, y koordinatakkal
	 */
	public Merleg(int x, int y, Ajto nyitando, int openWeight) {
			
		position = new Pont(x, y);
		this.nyitando = nyitando;
		this.openWeight=openWeight;
	}
	
	//rarak egy dobozt a merlegre, sulyaval noveli
	public void addDoboz(Doboz d){
		dobozok.push(d);
		currentWeight+=Doboz.weight;
		weighted();
		
	}

	//leveszi a legfolso dobozt a merlegrol, csokken a suly
	public Doboz removeTopDoboz(){
		if(!dobozok.empty()){
			currentWeight-=Doboz.weight;
			weighted();
			return dobozok.pop();
		}
		return null;
	}
	
	//ezredes raall a merlegre
	public void ezredesStepsOn(){
		currentWeight+=Jatekos.weight;
		weighted();
	}
	
	//ezredes leszall a merlegrol
	public void ezredesStepsOff(){
			currentWeight-=Jatekos.weight;
			weighted();
	}
	
	public Pont ertesit(Pont regi, Szereplo sz){
		
		System.out.println(">Merleg::ertesit(Pont)");
		if(position.compareTo(regi)){
			//ha lelepnek rola
			ezredesStepsOff();
		}
		else			
			//ha ralepnek
			ezredesStepsOn();
		
		System.out.println("<Merleg::ertesit(Pont)");
		return position;
	}
	
	//megnezi, van-e eleg suly a merlegen az ajto kinyitasahoz
	void weighted(){
		
		System.out.println(">Merleg::weighted(boolean)");
		
		if(currentWeight>=openWeight){
			nyitando.open();		
		}
		else{
			nyitando.close();
		}
		
		System.out.println("<Merleg::weighted(boolean)");
	}


	@Override
	public void ertesit_shoot(Tolteny t) {
		// TODO Auto-generated method stub
		
	}
}
