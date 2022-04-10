package AmznOAQstns;
import java.util.*;

public class minimumCostQ2 {

    public static long getMinimumCost(List<Integer> parcels, int k){

        int balance = k-parcels.size();
        long minimumCost = 0;

        Set<Integer> newSet = new HashSet<>();
        for (int i : parcels){
            newSet.add(i);
        }

        for (int i=1; i<=1000001; i++){
            if (balance <= 0) break;
            if (!newSet.contains(i)){
                minimumCost += i;
                balance -= 1;
            }
        }
        return minimumCost;
    }

    public static void main(String []args){
        List<Integer> parcels = new ArrayList<>(Arrays.asList(2,3,6,10,11));
        System.out.println(getMinimumCost(parcels,9));
    }

}
