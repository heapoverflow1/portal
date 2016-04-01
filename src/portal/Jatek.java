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
      System.out.println("0 - kilépés");
=======
			System.out.println("0 - kilépés");
>>>>>>> refs/remotes/origin/wBranch
			System.out.println("1 - mozgás");
			System.out.println("2 - mérlegre lépés / ajtó nyitás");
			System.out.println("3 - mérlegrõl lelépés / ajtó csukás");
			System.out.println("4 - Doboz felemelése");
<<<<<<< HEAD
      System.out.println("5 - Doboz letevése");
=======
			System.out.println("5 - Doboz letevése");
>>>>>>> refs/remotes/origin/wBranch
			System.out.println("6 - doboz mérlegre rakás / ajtó nyitás");
			System.out.println("7 - doboz mérlegrõl levétel / ajtó csukás");
			System.out.println("8 - töltény váltás");
			System.out.println("9 - lövés");
			System.out.println("Melyik esetet szeretné futtatni? Írja be a megfelelõ eset kódját.");
			
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
          
        //mérlegre lépés / ajtó nyitás
		case 2:
			try {
				merleg.ezredesStepsOn();
			} catch (IOException e) {
					e.printStackTrace();
			}
			break;
        
        //mérlegrõl lelépés / ajtó csukás
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
          
        //mérlegre lépés / ajtó nyitás
				case 2:
					try {
						merleg.ezredesStepsOn();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
        
        //mérlegrõl lelépés / ajtó csukás
				case 3:
					try {
						merleg.ezredesStepsOff();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
>>>>>>> refs/remotes/origin/wBranch
          
        //Doboz felemelése
				case 4:
					doboz.Lift();
					break;
				
        //Doboz letevése
       case 5:
<<<<<<< HEAD
			try {
				ezredes.drop();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
          
        //doboz mérlegre rakás / ajtó nyitás
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
          
        //doboz mérlegre rakás / ajtó nyitás
      	case 6:
					doboz.Lift();
					try {
						ezredes.move();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
>>>>>>> refs/remotes/origin/wBranch
        
       //doboz mérlegrõl levétel / ajtó csukás
        case 7:
          try {
            merleg.removeTopDoboz();
          } catch (IOException e) {
            e.printStackTrace();
          }
         
         //töltény váltás
        case 8:
<<<<<<< HEAD
			ezredes.changeTolteny();
			break;
        
        //lövés
        case 9:
=======
					ezredes.changeTolteny();
					break;
        
        //lövés
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
