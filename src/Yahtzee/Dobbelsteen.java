package Yahtzee;

import java.util.*;

public class Dobbelsteen {

	Random random = new Random();

//	Dobbelsteen dobbelsteen = new Dobbelsteen();

	int resultaat;

	public Dobbelsteen() {

	}

	public void werpen() {

		int worp = random.nextInt(6) + 1;

		resultaat = worp;

//		System.out.println(worp);

	}

	public void showResultaat() {

		System.out.print(resultaat + " ");
	}

}
