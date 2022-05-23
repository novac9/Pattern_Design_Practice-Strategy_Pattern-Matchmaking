/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based.  
*/

public class ReverseDistanceBasedStrategy  implements MatchingStrategy {
    @Override
    public int match(Individual user, Individual... dataBase) {

        double x1=user.getCoord().getX();
        double y1=user.getCoord().getY();
        int matchId = 0;
        double largest =Math.sqrt(Math.pow((dataBase[0].getCoord().getY()-y1),2)
                +Math.pow((dataBase[0].getCoord().getX()-x1),2));

        for (int i=0; i<dataBase.length;i++) {
            double x2 = dataBase[i].getCoord().getX();
            double y2 = dataBase[i].getCoord().getY();
            double calculation =Math.sqrt(Math.pow((y2-y1),2)+Math.pow((x2-x1),2));
            // need to rule out user himself/herself
            if (calculation>largest && dataBase[i].getId()!=user.getId()){
                largest=calculation;
                matchId= dataBase[i].getId();
            }
        }

        return matchId;
    }
}
