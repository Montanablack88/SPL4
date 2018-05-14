import javax.swing.JOptionPane;

public class Game {

	static int _zeilen = 3;
	static int _spalten = 3;
	static String [][] feld = spielfeldAnlegen(_zeilen, _spalten);

	public static void main(String[] args) {

		
		boolean ende = false;
		while (ende == false) {
			spielfeldAnzeigen();
			int posZeile = eingeben("Bitte Zeile eingeben!");
			int posSpalte = eingeben("Bitte Spalte eingeben!");
			ende = spielfeldprüfen(posZeile, posSpalte);
		}
	}
	public static boolean spielfeldprüfen(int Zeile, int Spalte) {
		if (feld[Zeile][Spalte] == "[X]") {
			System.out.println("Bummmm - du hast Leider die Mine erwischt!!!!");
			System.out.println("GAME OVER");
			return true;
		}
		return false;
	}
	
	public static int eingeben(String hinweis) {
		String eingabe = JOptionPane.showInputDialog(hinweis);
		return Integer.parseInt(eingabe);
	}

	public static void spielfeldAnzeigen() {
		for (int z = 0; z < _zeilen; z++) {
			for (int s = 0; s < _spalten; s++) {
				System.out.print(feld[z][s]);
			}

			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}
	public static String[][] spielfeldAnlegen(int Zeilen, int Spalten) {
		String[][] minefield = new String[Zeilen][Spalten];
		for (int z = 0; z < Zeilen; z++) {
			for (int s = 0; s < Spalten; s++) {
				minefield[z][s] = "[ ]";
			}
		}
		minefield[2][0] = "[X]";
		minefield[2][2] = "[X]";
		minefield[0][2] = "[X]";
		return minefield;
	}

}
