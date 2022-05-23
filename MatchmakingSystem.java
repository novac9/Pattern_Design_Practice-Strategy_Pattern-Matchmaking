/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based. 
*/

public class MatchmakingSystem {
    private Individual user;
    private Individual[] dataBase;
    private MatchingStrategy strategy;
    private int matchId;

    public MatchmakingSystem(Individual user, Individual[] dataBase,MatchingStrategy strategy){
        this.user=user;
        this.dataBase=dataBase;
        this.strategy=strategy;
    }

    public void match(){
        matchId=strategy.match(user,dataBase);
    }

    public int getMatchId() {
        return matchId;
    }
}
