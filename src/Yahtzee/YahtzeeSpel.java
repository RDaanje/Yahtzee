package Yahtzee;

import java.util.*;

public class YahtzeeSpel {

	static YahtzeeSpel game = new YahtzeeSpel();
	Worp gooien = new Worp();
	Speler speler1 = new Speler();
	Speler speler2 = new Speler();

	Scanner scanner = new Scanner(System.in);

	ArrayList<Dobbelsteen> stenen = new ArrayList<Dobbelsteen>();
	char[] controleArray = new char[5];
	int[] blokkeerArray = { 0, 0, 0, 0, 0 };

	boolean exitGame;
	int aantalSpelers;

	public static void main(String[] args) {

		System.out.println("Welkom bij Yahtzee!");
		game.aantalSpelers();

	}

	public YahtzeeSpel() {

		stenen.add(new Dobbelsteen());
		stenen.add(new Dobbelsteen());
		stenen.add(new Dobbelsteen());
		stenen.add(new Dobbelsteen());
		stenen.add(new Dobbelsteen());

	}

	public void spelen() {

		System.out.println("Druk op 's' om te beginnen of op 'q' om te stoppen");
		String s2 = scanner.nextLine();

		do {

			if (!(s2.equals("q"))) {

				if (aantalSpelers == 1) {
					System.out.println("Speler 1 begint!");
					speler1.speelRonde(stenen, blokkeerArray, gooien);
					speler1.scoreBerekenen(speler1);
					// check winnaar
					System.out.println("Als je alleen speelt dan win je altijd ;)");
				} else if (aantalSpelers == 2) {
					System.out.println("Speler 1 begint!");
					speler1.speelRonde(stenen, blokkeerArray, gooien);
					speler1.scoreBerekenen(speler1);
					System.out.println("Score speler 1: " + speler1.score);

					System.out.println("Speler 2 begint!");
					speler2.speelRonde(stenen, blokkeerArray, gooien);
					speler2.scoreBerekenen(speler2);
					System.out.println("Score speler 2: " + speler2.score);

					// check winnaar
					if (speler1.score > speler2.score) {
						System.out.println("Speler 1 wint");
					} else if (speler1.score < speler2.score) {
						System.out.println("Speler 2 wint");
					} else {
						System.out.println("Het is gelijkspel!");
					}

					System.out.println("Willen beide spelers verder spelen? (y/n)");
					verderSpelen();
				} else {
					System.out
							.println("Als er geen spelers zijn kan het spel niet beginnen. Het spel zal nu afsluiten.");
					exitGame = true;
				}

			}

			else {

				exitGame = true;
				scanner.close();

			}
		} while (exitGame == false);
		scanner.close();
		System.out.println("Exit game");

	}

	public void vastHouden() {

		System.out.println("Welke posities wilt u vasthouden? 0 voor geen anders bv 124 ");
		String scan = scanner.nextLine();
		String input = scan.replaceAll("\\s+", ""); // spaties worden uit de input gehaald.

		/**
		 * Afzonderlijke getallen in de string maken
		 **/
		input.getChars(0, input.length(), controleArray, 0); // de String wordt gesplitst in afzonderlijke
																// getallen(chars) en
																// in de controleArray gezet.

		for (int i = 0; i < controleArray.length; i++) {

			switch (controleArray[i]) { // de waarde in de controleArray bepaald welke dobbelsteen gehoud moet worden
										// op die plek wordt ook de blokkeerArray op 1 gezet.

			case '1':
				blokkeerArray[0] = 1;
				break;

			case '2':
				blokkeerArray[1] = 1;
				break;

			case '3':
				blokkeerArray[2] = 1;
				break;

			case '4':
				blokkeerArray[3] = 1;
				break;

			case '5':
				blokkeerArray[4] = 1;
				break;

			default:

			}
		}
	}

	public void verderSpelen() {
		String input1 = scanner.nextLine();
		if (input1.equals("y")) {
			System.out.println("Het spel begint opnieuw");
			spelen();
		} else if (input1.equals("n")) {
			System.out.println("Willen beide spelers stoppen? (y/n)");
			String input2 = scanner.nextLine();
			if (input2.equals("y")) {
				System.out.println("Het spel zal nu stoppen");
				exitGame = true;
			} else if (input2.equals("n")) {
				spelen();
			} else {
				System.out.println("Ongeldige invoer");
				System.out.println("Willen beide spelers verder spelen? (y/n)");
			}
		} else {
			System.out.println("Voer aub 'y' of 'n' in");
			verderSpelen();
		}
	}

	public void aantalSpelers() {
		System.out.println("Hoeveel mensen willen er spelen? (1 of 2)");
		String s1 = scanner.nextLine();
		if (s1.equals("1")) {
			System.out.println("Er is nu 1 speler!");
			this.aantalSpelers = 1;
			spelen();
		} else if (s1.equals("2")) {
			System.out.println("Er zijn nu 2 spelers!");
			this.aantalSpelers = 2;
			spelen();
		} else {
			System.out.println("Voer aub 1 of 2 in");
			spelen();
		}

	}

}
