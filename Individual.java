/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based.  
*/

public class Individual {

    private static int counter;
    private int id;
    private String gender;
    private int age;
    private String intro;
    private String[] habits;
    private Coord coord;

    public Individual(String gender, int age, String intro, String habits, Coord coord){
        counter++;
        id=counter;
        this.gender = gender;
        if (age<18){
            throw new IllegalArgumentException("Age should be over 18.");
        }
        this.age = age;
        this.intro = intro;
        this.habits = habits.split(",");
        this.coord = coord;
    }

    public int getId() {
        return id;
    }

    public String[] getHabits() {
        return habits;
    }

    public Coord getCoord() {
        return coord;
    }
}
