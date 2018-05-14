import javax.swing.JOptionPane;

public class Game {

	static int _zeilen = 3;
	static int _spalten = 3;
	static String[][] minenfeld = spielfeldAnlegen(_zeilen, _spalten, true);
	static String[][] spielfeld = spielfeldAnlegen(_zeilen, _spalten, false);
	static int minen = 0;
	static int versuche = 0;

	public static void main(String[] args) {
		boolean ende = false;
		while (ende == false) {
			spielfeldAnzeigen();
			int posZeile = eingeben("Bitte Zeile wählen", (_zeilen-1));
			int posSpalte = eingeben("Bitte Spalte wählen", (_spalten-1));
			ende = spielfeldPruefen(posZeile, posSpalte);
		}
	}

	public static boolean spielfeldPruefen(int zeile, int spalte) {
		if (minenfeld[zeile][spalte] == "[x]") {
			spielfeld[zeile][spalte] = "-X-";
			spielfeldAnzeigen();
			System.out.println("Bummm - Du hast leider die Mine erwischt...");
			System.out.println("GAME OVER..x");
			return true;
		} else {
			spielfeld[zeile][spalte] = "[*]";
			return false;
		}
	}

	public static int eingeben(String hinweis, int max) {

		String eingabe = JOptionPane.showInputDialog(hinweis);
		int zahl = Integer.parseInt(eingabe);
		
		if (zahl > max || zahl < 0) {
			System.out.println(" Bitte einen nummer zwischen 0 und " + max + " eingeben!!!");
			String eingabe1 = JOptionPane.showInputDialog(hinweis);
			zahl = Integer.parseInt(eingabe1);
		}
		
		return zahl;

	}

	public static void spielfeldAnzeigen() {
		for (int z = 0; z < _zeilen; z++) {
			for (int s = 0; s < _spalten; s++) {
				System.out.print(spielfeld[z][s]);
			}
			System.out.println();
		}
		System.out.println("::::::::::");
	}

	public static String[][] spielfeldAnlegen(int zeilen, int spalten, boolean mienenAnlegen) {
		String[][] minenField = new String[zeilen][spalten];
		for (int z = 0; z < zeilen; z++) {
			for (int s = 0; s < spalten; s++) {
				minenField[z][s] = "[ ]";
			}
		}
		if (mienenAnlegen) {
			minenField[(zeilen - 1)][0] = "[x]";
			minenField[(zeilen - 1)][(spalten - 1)] = "[x]";
			minenField[0][(spalten - 1)] = "[x]";
			minen = 3;
		}
		return minenField;
	}

}