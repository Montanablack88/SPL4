import javax.swing.JOptionPane;

public class Game {

	static int _zeilen = 3;
	static int _spalten = 3;
	static String [][] mienenfeld = spielfeldAnlegen(_zeilen, _spalten, true);
	static String [][] spielfeld = spielfeldAnlegen(_zeilen, _spalten, false);
	static int mienen = 0;
	static int versuche = 0;

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
		if (mienenfeld[Zeile][Spalte] == "[X]") {
			spielfeld[Zeile][Spalte] = "[X]";
			System.out.println("Bummmm - du hast Leider die Mine erwischt!!!!");
			System.out.println("GAME OVER...");
			return true;
		}else {
			spielfeld[Zeile][Spalte] = "[*]";
			return false;
		}

	}
	
	public static int eingeben(String hinweis) {
		String eingabe = JOptionPane.showInputDialog(hinweis);
		return Integer.parseInt(eingabe);
	}

	public static void spielfeldAnzeigen() {
		for (int z = 0; z < _zeilen; z++) {
			for (int s = 0; s < _spalten; s++) {
				System.out.print(spielfeld[z][s]);
			}

			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
	public static String[][] spielfeldAnlegen(int Zeilen, int Spalten, boolean mienenanlegen) {
		String[][] minefield = new String[Zeilen][Spalten];
		for (int z = 0; z < Zeilen; z++) {
			for (int s = 0; s < Spalten; s++) {
				minefield[z][s] = "[ ]";
			}
		}
		if (mienenanlegen == true) {
			
		
		minefield[2][0] = "[X]";
		minefield[2][2] = "[X]";
		minefield[0][2] = "[X]";
		mienen = 3;
		}
		return minefield;
	}
	

}
