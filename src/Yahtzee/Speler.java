package Yahtzee;

import java.util.*;

public class Speler {

	ArrayList<Integer> worpGeschiedenis = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	int score;

	//Constructor van de speler. De score van de speler wordt default op 0 gezet.
	public Speler() {
		score = 0;
	}

	//De uislag van de worp (in de array) wordt toegevoegd aan de worpgeschiedenis van de speler.
	public void worpToevoegenGeschiedenis(int[] worp) {
		worpGeschiedenis.clear();
		for (int i = 0; i < worp.length; i++) {
			worpGeschiedenis.add(worp[i]);
		}

	}

	//Deze methode laat de worpgeschiedenis zien.
	public void laatGeschiedenisZien() {
		String s = "";
		for (int i = 0; i < worpGeschiedenis.size(); i++) {
			s += worpGeschiedenis.get(i).toString() + " ";

		}
		System.out.println("De speler zijn laatste worp was: " + s);
	}

	//Deze methode laat een speler een ronde Yathzee spelen.
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

	//Deze methode berekent de score van de speler (nu nog heel simpel het totaal van het aantal dobbelstenen)
	public void scoreBerekenen(Speler speler) {
		speler.score = 0;
		for (int i = 0; i < worpGeschiedenis.size(); i++) {
			speler.score += worpGeschiedenis.get(i);
		}
	}

}
