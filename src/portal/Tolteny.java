package portal;

import java.io.IOException;

import portal.Ezredes.Irany;

public class Tolteny extends Ososztaly{
	boolean type_kek;
	SpecFal fal;

	public Tolteny(boolean blueType, Pont pos) {		
		type_kek = blueType;
		position = pos;
	}
	
	public Pont ertesit(Pont regi){
		
		System.out.println(">Tolteny::ertesit(Pont)");
		//Értesítésre szükség nincs, de kötelezõ implementálni.
		System.out.println("<Tolteny::ertesit(Pont)");
		return position;
	}
	
	void shoot(Irany irany){
		System.out.println(">Tolteny::shoot()");
		Jatek.palya.checkBullet();
		System.out.println("Specialis falra lottunk?");
        char valasz = 'N';
		try {
			valasz = (char) System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        if (valasz=='I'){
        	try {fal.createCSK();}
        	catch (IOException e){}
        	
        }
        	//Ha nem speciális falra lõttünk, nem jön létre csillagkpau
		System.out.println("<Tolteny::shoot()");
	}
	
	void destroy(){
		System.out.println(">Tolteny::destroy()");
		System.out.println("<Tolteny::destroy()");
	}

}
