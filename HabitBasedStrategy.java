/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based.  
*/

public class HabitBasedStrategy implements MatchingStrategy{

    /*
    find the person who has the most common habits with the user
    if more than one match has been found, then compare the sum of the user and the matched person's habits
     */

    @Override
    public int match(Individual user, Individual[] dataBase) {
        int userId = user.getId();
        String[] userHabits = user.getHabits();
        int matchScore=0;
        int[] result = new int[dataBase.length];
        int matchId=0;
        int matchPersonQty =0;
        int nextEval=0;

        for (int i=0; i<dataBase.length;i++){
            result[i]=compareTo(userHabits,dataBase[i].getHabits());
            int habitQty=dataBase[i].getHabits().length;
            // need to rule out user himself/herself
            if (result[i]>matchScore && dataBase[i].getId()!=userId){
                matchScore=result[i];
                matchId=dataBase[i].getId();

            }
            /*
             this is to get the max habit number in the database, which will be used in the next evaluation
             (if more than one match has been found)
             */
            if (habitQty>nextEval){
                nextEval=habitQty;
            }
        }

        // count how many people has the highest match score
        for (int num : result) {
            if (num == matchScore) {
                matchPersonQty++;
            }
        }

        // no need to change matchId if only one person has the highest match score

        /*
         Next Evaluation:
         if more than one person has the highest match score, then consider the qty of the matched person's habits
         the more focused the better ==> the lower qty the better
         */
        if (matchPersonQty>1){
            for (int i=0; i<result.length;i++) {
                if (result[i]==matchScore){
                    if (dataBase[i].getHabits().length<nextEval){
                        nextEval=dataBase[i].getHabits().length;
                        matchId=dataBase[i].getId();
                    }
                }
            }
        }

        return matchId;
    }

    private int compareTo(String[] a, String[] b){
        int aPointer=0;
        int bPointer=0;
        int match=0;

        while (aPointer<a.length) {
            // if b[j] matches with a [i], then i++ j=0
            if (b[bPointer].equals(a[aPointer])) {
                match++;
                aPointer++;
                bPointer = 0;
            }
            // otherwise, j++
            bPointer++;

            // if j = b.length, then i++ and j=0
            if (bPointer==b.length){
                aPointer++;
                bPointer=0;
            }
        }

        return match;
    }
}
