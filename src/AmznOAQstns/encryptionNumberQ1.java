package AmznOAQstns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encryptionNumberQ1 {

    public static String getEncryptedNumber(List<Integer> numbers){

        while (numbers.size()>2){

            List<Integer> newList = new ArrayList<>();

            for (int i=0; i<numbers.size()-1; i++){
                newList.add((numbers.get(i)+numbers.get(i+1))%10);
            }

            numbers = newList;
        }

        return numbers.get(0)+""+numbers.get(1);
    }

    public static void main(String []args){

        List<Integer> arrList = new ArrayList<>(Arrays.asList(4,5,6,7));

        System.out.println(getEncryptedNumber(arrList));

    }

}
