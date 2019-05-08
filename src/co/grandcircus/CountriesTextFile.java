package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	public static ArrayList<Country> readFromFile() {
		ArrayList<Country> countries = new ArrayList<>();
		String file = "countries.txt";
		Path filePath = Paths.get(file);

		File f = filePath.toFile();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String[] name;

			while (line != null) {
				name = line.split(",");
				line = br.readLine();
				Country sLine = new Country(name[0], Integer.parseInt(name[1]));
				countries.add(sLine);
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		} catch (IOException e) {
			System.out.println("IO error");
		}
		return countries;
	}

	public static void writeToFile(ArrayList<Country> countries) {
		String fileName = "countries.txt";
		Path path = Paths.get(fileName);

		File file = path.toFile();

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("File successfully created");
			} catch (IOException e) {
				System.out.println("Error");
			}
		} else {
			System.out.println();
			System.out.println("Writing to file...");
		}
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(file, false));
			for (Country i : countries)
				output.println(i);
			output.close();
			System.out.println("Success!");
		} catch (FileNotFoundException e) {
			System.out.println("Yoooo, I don't know what's going on");
		}

	}

}
