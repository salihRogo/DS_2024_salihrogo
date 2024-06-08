package homework4;

import java.util.*;

public class SocialNetwork {
    private int V;
    private int E;

    private HashMap<String, ArrayList<Friendship>> adj;

    public SocialNetwork() {
        // implement the actual logic
        this.V = 0;
        this.E = 0;
        adj = new HashMap<String, ArrayList<Friendship>>();
    }

    public SocialNetwork(Scanner in) {
        // implement the actual logic
        in.nextLine();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(";");
            if (data.length == 3) {
                String friend1 = data[0];
                String friend2 = data[1];
                int friendshipStrength = Integer.parseInt(data[2]);
                addFriendship(new Friendship(friend1, friend2, friendshipStrength));
            }
        }
    }

    public void addUser(String user) {
        // implement the actual logic
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }

    public void addFriendship(Friendship f) {
        // implement the actual logic
        if (!adj.containsKey(f.getFriend1())) {
            addUser(f.getFriend1());
        }
        if (!adj.containsKey(f.getFriend2())) {
            addUser(f.getFriend2());
        }
        adj.get(f.getFriend1()).add(f);
        adj.get(f.getFriend2()).add(f);
        E++;
    }

    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        // implement the actual logic (remove next line)
        if (!adj.containsKey(user)) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> potentialFriends = new HashMap<>();
        ArrayList<Friendship> userFriendships = adj.get(user);

        String friend;
        for (Friendship f : userFriendships) {
            if (f.getFriend1().equals(user)) {
                friend = f.getFriend2();
            } else {
                friend = f.getFriend1();
            }

            // ff - friend friends
            String potentialFriend = null;
            for (Friendship ff : adj.get(friend)) {
                if (ff.getFriend1().equals(friend)) {
                    potentialFriend = ff.getFriend2();
                } else {
                    potentialFriend = ff.getFriend1();
                }

                if (potentialFriends.equals(user) || containsFriendship(user, potentialFriend)) {
                    continue;
                }

                int currentStrength = Math.min(f.getFriendshipStrength(), ff.getFriendshipStrength());
                potentialFriends.merge(potentialFriend, currentStrength, Integer::sum);
            }
        }

        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : potentialFriends.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }

        Collections.sort(recommendations);
        Collections.reverse(recommendations);

        return recommendations;
    }

    private boolean containsFriendship(String user, String potentialFriend) {
        // Checks if two users are already friends
        return adj.get(user).stream().anyMatch(f -> f.getFriend1().equals(potentialFriend) || f.getFriend2().equals(potentialFriend));
    }

    public int getNumberOfUsers() {
        return V;
    }

    public int getNumberOfFriendships() {
        return E;
    }
}
