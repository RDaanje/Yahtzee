package Yahtzee;

import java.util.*;

public class Dobbelsteen {

	Random random = new Random();
	int resultaat;

	//Deze methode werpt de dobbelsteen met als uitkomst een random nummer tussen 1 en 6.
	public void werpen() {

		int worp = random.nextInt(6) + 1;

		resultaat = worp;
	}

	public void showResultaat() {

		System.out.print(resultaat + " ");
	}

}
