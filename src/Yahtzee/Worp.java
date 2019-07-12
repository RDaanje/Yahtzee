package Yahtzee;

import java.util.*;

public class Worp {

	int[] worp = new int[5];

	//Methode die de uitslag van de worp laat zien.
	public void showUitslag(ArrayList<Dobbelsteen> waardeStenen) {

		System.out.println("1 2 3 4 5\n");
		for (Dobbelsteen dobbelsteen : waardeStenen) {

			dobbelsteen.showResultaat();
		}
		System.out.println("\n");
	}

	//Methode die de uitslag van de worp opslaat in een array.
	public void worpOplsaan(ArrayList<Dobbelsteen> waardeStenen) {

		for (int i = 0; i < worp.length; i++) {
			worp[i] = waardeStenen.get(i).resultaat;
		}

	}

}