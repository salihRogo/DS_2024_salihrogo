package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    // implement the relevant properties, constructor and methods

    private String user;
    private double recomendationStrength;

    public FriendshipRecommendation(String user, double recomendationStrength) {
        this.user = user;
        this.recomendationStrength = recomendationStrength;
    }

    public String getUser() {
        return user;
    }

    public double getRecomendationStrength() {
        return recomendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        return Double.compare(this.recomendationStrength, o.recomendationStrength);
    }

    @Override
    public String toString() {
        return user + " - " + recomendationStrength;
    }
}
