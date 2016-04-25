package portal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jatek {
	static Jatekter palya;
	
	public static void main(String[] args) throws IOException{
		palya = new Jatekter();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null && s.length() != 0){
	    	System.out.println(s);
	    	// An empty line or Ctrl-Z terminates the program
	    }	    	
	}
}
