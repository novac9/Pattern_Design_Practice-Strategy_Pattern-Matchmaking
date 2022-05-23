/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based. 
*/

public class ReverseHabitBasedStrategy implements MatchingStrategy{

    /*
    find the person who has the least common habits with the user
    if more than one match has been found, then compare the sum of user habits and matched person's habits
    */

    @Override
    public int match(Individual user, Individual... dataBase) {
        int userId = user.getId();
        String[] userHabits = user.getHabits();
        int matchScore=userHabits.length;
        int[] result = new int[dataBase.length];
        int matchId=0;
        int matchPersonQty =0;

        for (int i=0; i<dataBase.length;i++){
            result[i]=compareTo(userHabits,dataBase[i].getHabits());
            // need to rule out user himself/herself
            if (result[i]<matchScore && dataBase[i].getId()!=userId){
                matchScore=result[i];
                matchId=dataBase[i].getId();
            }
        }

        // count how many person has the same lowest match score
        for (int num : result){
            if (num==matchScore){
                matchPersonQty++;
            }
        }

        // no need to change matchId if only one person has the lowest match score

        /*
         Next Evaluation:
         if more than one person has the lowest match score, then consider the qty of the matched person's habits
         the more diverse the better ==> the higher qty the better
         */
        int nextEval=0;
        if (matchPersonQty>1){
            for (int i=0; i<result.length;i++) {
                if (result[i]==matchScore){
                    if (dataBase[i].getHabits().length>nextEval){
                        nextEval=dataBase[i].getHabits().length;
                        matchId=dataBase[i].getId();
                    }
                }
            }
        }

        return matchId;
    }

    public int compareTo(String[] a, String[] b){
        int aPointer=0;
        int bPointer=0;
        int match=0;

        while (aPointer<a.length){
            // if b[j]==a[i], then i++ and j=0
            if (b[bPointer].equals(a[aPointer])){
                match++;
                aPointer++;
                bPointer=0;
            }
            // otherwise j++
            bPointer++;

            // if j=b.length, then i++, j=0
            if(bPointer==b.length){
                aPointer++;
                bPointer=0;
            }
        }
        return match;
    }
}
