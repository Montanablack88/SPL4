
public class Game {

	public static void main(String[] args) {
		String[][] feld = spielfeldanlegen(3,3);
		//feld = mineSetzen(0,3);
		speilfeldanzeigen(feld);
		}
	public static String[][] spielfeldanlegen(int Zeilen, int Spalten) {
		String[][] minefield = new String[Zeilen][Spalten];
		for(int z = 0; z < Zeilen; z++) {
			for(int s = 0; s < Spalten; s++) {
				minefield[z][s] = "[ ]";
			}
		}
		return minefield;
	}

	
}
