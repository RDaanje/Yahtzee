package Yahtzee;

import java.util.*;

public class Speler {

	ArrayList<Integer> worpGeschiedenis = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	int score;

	public Speler() {
		score = 0;
	}

	public void worpToevoegenGeschiedenis(int[] worp) {
		worpGeschiedenis.clear();
		for (int i = 0; i < worp.length; i++) {
			worpGeschiedenis.add(worp[i]);
		}

	}

	public void laatGeschiedenisZien() {
		String s = "";
		for (int i = 0; i < worpGeschiedenis.size(); i++) {
			s += worpGeschiedenis.get(i).toString() + " ";

		}
		System.out.println("De speler zijn laatste worp was: " + s);
	}

	public void speelRonde(ArrayList<Dobbelsteen> stenen, int[] blokkeerArray, Worp gooien) {
		System.out.println("Worp 1:");
		for (Dobbelsteen dobbelsteen : stenen) {
			dobbelsteen.werpen();
		}

		gooien.showUitslag(stenen);
		YahtzeeSpel.game.vastHouden();

		System.out.println("Worp 2:");

		for (int i = 0; i < blokkeerArray.length; i++) {

			if (blokkeerArray[i] != 1) {
				blokkeerArray[i] = 0;
				stenen.get(i).werpen();

			}

		}

		gooien.worpOplsaan(stenen);
		gooien.showUitslag(stenen);

		worpToevoegenGeschiedenis(gooien.worp);
		laatGeschiedenisZien();
	}

	public void scoreBerekenen(Speler speler) {
		speler.score = 0;
		for (int i = 0; i < worpGeschiedenis.size(); i++) {
			speler.score += worpGeschiedenis.get(i);
		}
	}

}
