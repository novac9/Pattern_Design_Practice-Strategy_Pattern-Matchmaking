/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based.  
*/

public interface MatchingStrategy {
    int match(Individual user, Individual... dataBase);
}
