import java.util.*;

public class algorithm {
    /**
     * searchWord method used to find out the word's definition and output it.
     * @param list The words and translations list
     * @param target The user input
     * @return return a translation of target word.
     */
    public static String searchWord(ArrayList<Translation> list, String target){
        /* binarySearch for initial letter of the target */
        ArrayList<String> similar = new ArrayList<>();
        int left = 0;
        int right = list.size()-1;
        int temp = 0;

        while(left <= right){
            int mid = left + (right - left)/2;

            if (list.get(mid).getEnglish().equals(target)) return "The definition is: " + "\n" + list.get(mid).getChinese();

            if ((int)list.get(mid).getEnglish().charAt(0) == (int)target.charAt(0)){
                temp = mid;
                break;
            }else if((int) list.get(mid).getEnglish().charAt(0) > (int) target.charAt(0)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }


        /* Check if the target have second letter. */
        if (target.length() < 2){
            while(temp > 0) {
                temp--;
                if (list.get(temp).getEnglish().equals(target)) return list.get(temp).toString();
            }
        }

        /*Comparing the second letter and traverse the ArrayList in appropriate direction. */
        if ((int) list.get(temp).getEnglish().charAt(1) >(int) target.charAt(1)){
            while(temp > 0) {
                temp--;
                if(T.findSimilarity(list.get(temp).getEnglish(),target)) similar.add(list.get(temp).getEnglish());
                if (list.get(temp).getEnglish().equals(target)) return list.get(temp).toString();
            }
        }else if((int) list.get(temp).getEnglish().charAt(1) < (int) target.charAt(1) && (int) list.get(temp).getEnglish().charAt(1) != 32){
            while(temp < list.size()-1) {
                temp++;
                if(T.findSimilarity(list.get(temp).getEnglish(),target)) similar.add(list.get(temp).getEnglish());
                if (list.get(temp).getEnglish().equals(target)) return list.get(temp).toString();
            }
        }else{
                while(temp > 0) {
                temp--;
                if(T.findSimilarity(list.get(temp).getEnglish(),target)) similar.add(list.get(temp).getEnglish());
                if (list.get(temp).getEnglish().equals(target)) return list.get(temp).toString();
            }
        }


        return "Word not found, maybe you want these?" + similar;
    }


}
