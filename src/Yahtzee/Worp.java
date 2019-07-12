package Yahtzee;

import java.util.*;

public class Worp {

	int[] worp = new int[5];

	public void showUitslag(ArrayList<Dobbelsteen> waardeStenen) {

		System.out.println("1 2 3 4 5\n");
		for (Dobbelsteen dobbelsteen : waardeStenen) {

			dobbelsteen.showResultaat();
		}
		System.out.println("\n");
	}

	public void worpOplsaan(ArrayList<Dobbelsteen> waardeStenen) {

		for (int i = 0; i < worp.length; i++) {
			worp[i] = waardeStenen.get(i).resultaat;
		}

	}

}