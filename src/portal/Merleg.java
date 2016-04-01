package portal;

import java.io.IOException;

public class Merleg extends Ososztaly{
	Ajto nyitando = new Ajto(1,1);
	//Stack<Doboz> dobozok=new Stack<Doboz>();
	//int currentWeight=0;
	//int openWeight;
	Doboz doboz=new Doboz(1,1);
	
	//rarak egy dobozt a merlegre, sulyaval noveli
	public void addDoboz(Doboz d) throws IOException{
		System.out.println(">Merleg::addDoboz(Doboz)");
		System.out.println("betesszuk a dobozt a Merleg stackjebe");
		System.out.println("noveljuk a merlegen levo jelenlegi sulyt");
		weighted();
		System.out.println("<Merleg::addDoboz(Doboz)");
	}

	//leveszi a legfolso dobozt a merlegrol, csokken a suly
	public Doboz removeTopDoboz() throws IOException{
		/*if(!dobozok.empty()){
			currentWeight-=Doboz.weight;
			weighted();
			return dobozok.pop();
		}*/
		System.out.println(">Merleg::removeTopDoboz()");
		System.out.println("Legyen ures a stack?(i/n)");
		char valasz= (char) System.in.read();
		if(valasz=='i'){
			System.out.println("<Merleg::removeTopDoboz()");
			return null;
		}
		else if(valasz=='n'){
			System.out.println("csokkentem a merlegen levo jelenlegi sulyt");
			weighted();
			System.out.println("<Merleg::removeTopDoboz()");
			return doboz;
		}
		else
			return null;

	}
	
	//ezredes raall a merlegre
	public void ezredesStepsOn() throws IOException{
		System.out.println(">Merleg::ezredesStepsOn()");
		System.out.println("novelem a merlegen levo jelenlegi sulyt");
		weighted();
		System.out.println("<Merleg::ezredesStepsOn()");
	}
	
	//ezredes leszall a merlegrol
	public void ezredesStepsOff() throws IOException{
		System.out.println(">Merleg::ezredesStepsOff()");
		System.out.println("csokkentem a merlegen levo jelenlegi sulyt");
		weighted();
		System.out.println("<Merleg::ezredesStepsOff()");
	}
	
	public Pont ertesit(Pont regi){
		
		System.out.println(">Merleg::ertesit(Pont)");
		System.out.println("<Merleg::ertesit(Pont)");
		return null;
	}
	
	//megnezi, van-e eleg suly a merlegen az ajto kinyitasahoz
	void weighted() throws IOException{
		
		System.out.println(">Merleg::weighted()");
		System.out.println("A merlegen levo suly nagyobb a sulyhatarnal?(i/n)");
		char valasz= (char) System.in.read();
		if(valasz=='i'){
			nyitando.open();
			System.out.println("<Merleg::weighted()");
		}
		else if(valasz=='n'){
			nyitando.close();
			System.out.println("<Merleg::weighted()");
		}
	}
}
