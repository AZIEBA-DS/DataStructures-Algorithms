package aSetsAndHashTables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		Main run = new Main();

		// getAllUsers
		System.out.println("All Users: " + run.getAllUsers() + "\n");

		// getLikes
		System.out.println("Users who like Mike: " + run.getLikes("Mike"));
		System.out.println("Users who like Kristen: " + run.getLikes("Kristen"));
		System.out.println("Users who like Bill: " + run.getLikes("Bill"));
		System.out.println("Users who like Sara: " + run.getLikes("Sara") + "\n");

		// getLikedBy
		System.out.println("Users that Mike likes: " + run.getLikedBy("Mike"));
		System.out.println("Users that Kristen likes: " + run.getLikedBy("Kristen"));
		System.out.println("Users that Bill likes: " + run.getLikedBy("Bill"));
		System.out.println("Users that Sara likes: " + run.getLikedBy("Sara") + "\n");

		// Testing case sensitivity
		System.out.println("Users who like mike: " + run.getLikes("mike"));
		System.out.println("Users that mike likes: " + run.getLikedBy("mike"));

	}

	public List<String> getAllUsers() {
		List<String> userList = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				String users[] = line.split(": |\\, ");
				for (String user : users) {
					if (!userList.contains(user)) {
						userList.add(user);
					}
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("IOException Error.");
		}
		return userList;
	}

	public List<String> getLikes(String person) {
		List<String> userLikes = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				if (line.startsWith(person)) {
					String users[] = line.split(": |\\, ");
					for (String user : users) {
						if (!user.equals(person)) {
							userLikes.add(user);
						}
					}
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("IOException Error.");
		}
		return userLikes;
	}

	public List<String> getLikedBy(String person) {
		List<String> userLikedBy = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				if (!line.startsWith(person)) {
					String users[] = line.split(": |\\, ");
					for (String user : users) {
						if (user.equals(person)) {
							userLikedBy.add(users[0]);
						}
					}
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("IOException Error.");
		}
		return userLikedBy;
	}
}
