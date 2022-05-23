/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based.  
*/

public class Main {

    public static void main(String[] args) {
        try {
            Individual a = new Individual("Female",20,"Hello I want to meet new friends.",
                    "shopping,read,sing",new Coord(3,4));

            Individual b = new Individual("Male",23,"Just graduated from Uni.",
                    "basketball,photography,videogames",new Coord(7,9.5));
            Individual c = new Individual("Female",34,"Hi I'm a software engineer.",
                    "travel,videogames",new Coord(3,5));
            Individual d = new Individual("Male",30,"He/him.",
                    "piano,basketball,videogames",new Coord(20,-3.5));

            Individual e = new Individual("Female",33,"She/her","jog,gardening,ski,biking",
                    new Coord(9,56));

            Individual f = new Individual("Male",31,"Hiya I'm fun to be with.",
                    "basketball,videogames",new Coord(40,5));

            Individual[] dataBase = new Individual[6];
            dataBase[0]=a;
            dataBase[1]=b;
            dataBase[2]=c;
            dataBase[3]=d;
            dataBase[4]=e;
            dataBase[5]=f;

            MatchmakingSystem mySystem = new MatchmakingSystem(a,dataBase,new DistanceBasedStrategy());
            mySystem.match();
            System.out.println(mySystem.getMatchId()); // should be 3

            MatchmakingSystem mySystem1 = new MatchmakingSystem(b,dataBase, new ReverseDistanceBasedStrategy());
            mySystem1.match();
            System.out.println(mySystem1.getMatchId());  // should be 5

            MatchmakingSystem mySystem2 = new MatchmakingSystem(c, dataBase, new ReverseHabitBasedStrategy());
            mySystem2.match();
            System.out.println(mySystem2.getMatchId());  // should be 5

            MatchmakingSystem mySystem3 = new MatchmakingSystem(d, dataBase, new HabitBasedStrategy());
            mySystem3.match();
            System.out.println(mySystem3.getMatchId()); // should be 6
        }

        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
