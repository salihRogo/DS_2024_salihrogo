package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SocialNetwork network = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Loading in the social network...");
        try {
            File file = new File("files/social_network.csv");
            Scanner fileScanner = new Scanner(file);
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(";");
                String user1 = data[0].trim();
                String user2 = data[1].trim();
                int friendshipStrength = Integer.parseInt(data[2].trim());
                Friendship friendship = new Friendship(user1, user2, friendshipStrength);
                network.addFriendship(friendship);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        System.out.println("Network successfully loaded.");
        System.out.println("Total users: " + network.getNumberOfUsers());
        System.out.println("Total friendships: " + network.getNumberOfFriendships());
        System.out.println("============================================================= \n");

        while (true) {
            System.out.print("Enter a name to recommend friends for, or -1 to exit: ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Thank you for using our friendship recommender algorithm.");
                break;
            }

            ArrayList<FriendshipRecommendation> recommendations = network.recommendFriends(input);
            if (recommendations.isEmpty()) {
                System.out.println("The user you are looking for does not exist in the network. \n");
            } else {
                System.out.println("Total recommendations: " + recommendations.size());
                System.out.println("Top 10 recommendations based on friendship strength: ");
                recommendations.stream().limit(10).forEach(System.out::println);
            }
        }
        scanner.close();
    }
}

