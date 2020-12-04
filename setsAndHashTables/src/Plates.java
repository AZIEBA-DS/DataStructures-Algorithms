package setsAndHashTables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Plates {
	private Map<String, Integer> plateMap;

	public Plates() {
		plateMap = new HashMap<String, Integer>();
	}

	public void buildMap() {
		try (BufferedReader reader = new BufferedReader(new FileReader("plates.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				String plates[] = line.split(" ");
				for (String plate : plates) {
					plate = cleanPlate(plate);
					if (plate.length() < 2) {
						continue;
					}
					if (!plateMap.containsKey(plate))
						plateMap.put(plate, 0);
					int counter = plateMap.get(plate);
					plateMap.put(plate, counter + 1);
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("IOException Error.");
		}
	}

	public String cleanPlate(String plate) {
		String clean = "";
		plate = plate.toUpperCase();
		for (Character c : plate.toCharArray()) {
			if (Character.isLetter(c)) {
				clean = clean + c;
			}
		}
		return clean.trim();
	}

	public void printCounts() {
		/* do not edit the implementation of this method */
		System.out.println("Number of Plates: " + plateMap.keySet().size());
		for (String key : plateMap.keySet())
			System.out.printf("%s -> %s%n", key, plateMap.get(key));
	}
}
