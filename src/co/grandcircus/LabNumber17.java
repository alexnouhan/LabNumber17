package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class LabNumber17 {

	// Alex Nouhan
	// Grand Circus 2019

	private static ArrayList<Country> countries = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Country List");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();

		while (true) {

			showMenu();

			int choice = Validator.getInt(scan, "What would you like to do?: ", 1, 4);
			System.out.println();

			if (choice == 1) {
				showList();
			} else if (choice == 2) {
				add(scan);
			} else if (choice == 3) {
				remove(scan);
			} else if (choice == 4) {
				break;
			}
		}

		System.out.println("Buh-bye!");
		scan.close();
	}

	public static void showMenu() {
		System.out.println();
		System.out.println("      Menu");
		System.out.println("   ````````````````````");
		System.out.println("   1. List Countries");
		System.out.println("   2. Enter New Country");
		System.out.println("   3. Remove Country");
		System.out.println("   4. Quit");
		System.out.println();
	}

	public static void showList() {
		countries = CountriesTextFile.readFromFile();
		System.out.printf("%-7s%-24s%-12s\n", "#", "Country", "Population");
		System.out.println("```````````````````````````````````````````````````");
		for (Country i : countries) {
			System.out.printf("%-7s%-24s%-12s\n", countries.indexOf(i) + 1, i.getName(), i.getPopulation());
		}
	}

	public static void add(Scanner scan) {
		countries = CountriesTextFile.readFromFile();
		countries.add(new Country(Validator.getLine(scan, "Enter New Country Name: "),
				Validator.getInt(scan, "Enter New Country Population: ", 0, 700000000)));
		CountriesTextFile.writeToFile(countries);
	}

	public static void remove(Scanner scan) {
		showList();
		countries = CountriesTextFile.readFromFile();
		int choice = Validator.getInt(scan, "Which country would you like to remove?: ", 1, countries.size());
		countries.remove(choice - 1);
		CountriesTextFile.writeToFile(countries);
	}

}
