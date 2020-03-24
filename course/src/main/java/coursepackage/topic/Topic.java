package coursepackage.topic;

public class Topic {
    private String id;
    private String name;
    private String descritpion;
    private int score;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public int getScore() {
        return score;
    }

    public Topic(String id, String name, String descritpion, int score) {
        this.id = id;
        this.name = name;
        this.descritpion = descritpion;
        this.score = score;
    }
}
