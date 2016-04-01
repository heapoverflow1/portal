package portal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jatek {
	static Jatekter palya;
	static Ezredes ezredes;
	static Ajto ajto;
	static Doboz doboz;
	static Fal fal;
	static Merleg merleg;
	static SpecFal specfal;
	static Szakadek szakadek;
	static Tolteny tolteny;
	static ZPM zpm;
	
	public static void main(String[] args){
		palya = new Jatekter();
		ezredes = new Ezredes();
		ajto = new Ajto(1, 1);
		doboz = new Doboz(1, 1);
		fal = new Fal(1, 1);
		merleg = new Merleg();
		specfal = new SpecFal(1,1 );
		szakadek = new Szakadek(1, 1);
		tolteny = new Tolteny(false, new Pont());
		zpm = new ZPM(1, 1);
		
		System.out.println("SZKELETON - heapoverflow");
    
		while (true){
			
<<<<<<< HEAD
      System.out.println("0 - kil�p�s");
=======
			System.out.println("0 - kil�p�s");
>>>>>>> refs/remotes/origin/wBranch
			System.out.println("1 - mozg�s");
			System.out.println("2 - m�rlegre l�p�s / ajt� nyit�s");
			System.out.println("3 - m�rlegr�l lel�p�s / ajt� csuk�s");
			System.out.println("4 - Doboz felemel�se");
<<<<<<< HEAD
      System.out.println("5 - Doboz letev�se");
=======
			System.out.println("5 - Doboz letev�se");
>>>>>>> refs/remotes/origin/wBranch
			System.out.println("6 - doboz m�rlegre rak�s / ajt� nyit�s");
			System.out.println("7 - doboz m�rlegr�l lev�tel / ajt� csuk�s");
			System.out.println("8 - t�lt�ny v�lt�s");
			System.out.println("9 - l�v�s");
			System.out.println("Melyik esetet szeretn� futtatni? �rja be a megfelel� eset k�dj�t.");
			
			int valasz = 0;
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String s = "0";
	        try {
            s=in.readLine();
          } catch (IOException e1) {
            e1.printStackTrace();
         	}
	        valasz = Integer.parseInt(s);
	        
			switch (valasz){
      
      	//kilepes
      	case 0:
<<<<<<< HEAD
        	return;  
        
        //mozgas
		case 1:
          try {
            ezredes.move();
          } catch (IOException e) {
              e.printStackTrace();
          }
          break;
          
        //m�rlegre l�p�s / ajt� nyit�s
		case 2:
			try {
				merleg.ezredesStepsOn();
			} catch (IOException e) {
					e.printStackTrace();
			}
			break;
        
        //m�rlegr�l lel�p�s / ajt� csuk�s
		case 3:
			try {
				merleg.ezredesStepsOff();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
=======
        	return; 
        
        //mozgas
				case 1:
          try {
            ezredes.move();
            } catch (IOException e) {
              e.printStackTrace();
            }
					break;
          
        //m�rlegre l�p�s / ajt� nyit�s
				case 2:
					try {
						merleg.ezredesStepsOn();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
        
        //m�rlegr�l lel�p�s / ajt� csuk�s
				case 3:
					try {
						merleg.ezredesStepsOff();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
>>>>>>> refs/remotes/origin/wBranch
          
        //Doboz felemel�se
				case 4:
					doboz.Lift();
					break;
				
        //Doboz letev�se
       case 5:
<<<<<<< HEAD
			try {
				ezredes.drop();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
          
        //doboz m�rlegre rak�s / ajt� nyit�s
      	case 6:
			doboz.Lift();
			try {
				ezredes.move();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
=======
					try {
						ezredes.drop();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
          
        //doboz m�rlegre rak�s / ajt� nyit�s
      	case 6:
					doboz.Lift();
					try {
						ezredes.move();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
>>>>>>> refs/remotes/origin/wBranch
        
       //doboz m�rlegr�l lev�tel / ajt� csuk�s
        case 7:
          try {
            merleg.removeTopDoboz();
          } catch (IOException e) {
            e.printStackTrace();
          }
         
         //t�lt�ny v�lt�s
        case 8:
<<<<<<< HEAD
			ezredes.changeTolteny();
			break;
        
        //l�v�s
        case 9:
=======
					ezredes.changeTolteny();
					break;
        
        //l�v�s
        case 9:
					ezredes.shoot();
					break;
>>>>>>> refs/remotes/origin/wBranch
          
      	default:
          break;
        
        
			}
			
		}
	}
}
