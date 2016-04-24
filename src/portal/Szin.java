package portal;

public enum Szin {
	SARGA(0), KEK(1), ZOLD(2), PIROS(3);
	private final int value;
	Szin(final int ertek){
		value = ertek;
	}
	public int getValue(){return value;}
}
