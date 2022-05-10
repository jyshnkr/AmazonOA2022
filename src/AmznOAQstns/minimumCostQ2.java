package AmznOAQstns;
import java.util.*;

/*
Why did we use HashSet?
1. We could use given data structure in the problem i.e., arraylist. It would be a feasible solution for a finite set of numbers/ finite parcels size.
But, if the parcels size is larger, then it would take a much longer time to execute the program, which leads to bigger time complexity.
Arraylist needs to search for the element that doesn't contain inside the truck everytime we run the program, which would take O(n) time.
Additinally, it would take another O(n) time to to perform the operation (adding the missing parcel, as it needs to calculate all the preceeding elements).
Approximately, it would take O(n^2) time complexity internally, should we use arraylist.

2. HashSet is a data structure that performs add, remove and search operations in O(1) constant time complexity, as it internally implements hashtable mechanism.
Either the input size is finite numbers or a large set of integers, it would hash all the inputs and inserts them into hashing addresses. It would take O(1) time,
to search for the element and add the missing element to the truck. We are trading space to obtain the best time complexity possible

Time complexity: O(n) - As we are iterating through large set of elements (for loop - iterating from 1 to 10^6), it would O(n) time complexity
Space Complexity: O(n) - We took additional data structure - hashSet which is of size 'n'

*/

public class minimumCostQ2 {

    public static long getMinimumCost(List<Integer> parcels, int k){

        //1. Declared and initialized a variable to get the remaining space left inside the truck
        int balance = k-parcels.size();
        
        //2. Declared and initialized a variable to return the result in long integer type
        long minimumCost = 0;

        //3. Declared and initialized HashSet and stored the elements in parcels array in it.
        Set<Integer> newSet = new HashSet<>(); //Space complexity : O(n) - Added elements of size 'n'
        for (int i : parcels){  //Time complexity : O(n) - Adding 'n' elements from parcels to HashSet
            newSet.add(i);
        }

        //4. As mentioned in the constraints, the parcels ranges from 1 to infinity (~ 10^6), we iterate through all the parcels,
        // and add the parcels which are not present in parcels array (i.e., parcels not contained inside the truck) and reduce the balance.
        // Should we find that balance is equals or less than zero, we immediately break the loop and return the answer in long int type.
        for (int i=1; i<=1000001; i++){ //Time complexity : O(n) - iterating from 1 to 10^6
            if (balance <= 0) break; //Broke the loop as per given in the instructions
            if (!newSet.contains(i)){ //Time complexity : O(1) - Searching in HashSet
                minimumCost += i;
                balance -= 1;
            }
        }
        
        //Overall time complexity : O(n)+O(1) = O(n) [reduced to higher polynomial degree of '1']
        return minimumCost;
    }

    public static void main(String []args){
        List<Integer> parcels = new ArrayList<>(Arrays.asList(2,3,6,10,11));
        System.out.println(getMinimumCost(parcels,9));
    }

}
