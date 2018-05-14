
public class Game {

	static int _zeilen = 3;
	static int _spalten = 3;

	public static void main(String[] args) {
		String[][] feld = spielfeldanlegen(3, 3);
		// feld = mineSetzen(0,3);
		spielfeldanzeigen(feld, _zeilen, _spalten);
	}

	public static void spielfeldanzeigen(String[][] feld, int Zeilen, int Spalten) {
		for (int z = 0; z < Zeilen; z++) {
			for (int s = 0; s < Spalten; s++) {
				System.out.print(feld[z][s]);
			}
			System.out.println();
		}
	}

	public static String[][] spielfeldanlegen(int Zeilen, int Spalten) {
		String[][] minefield = new String[Zeilen][Spalten];
		for (int z = 0; z < Zeilen; z++) {
			for (int s = 0; s < Spalten; s++) {
				minefield[z][s] = "[ ]";
			}
		}
		return minefield;
	}

}
