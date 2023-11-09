import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class userInteraction {

    /**
     * the doAction method start the main program
     * @param array an ArrayList that contains all Translation type of words extract from csv.
     * @throws InterruptedException to avoid warning by using sleep method.
     */
    public static void doAction(ArrayList<Translation> array) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String answer = "y";
        String target;

        /* While loop check the user action. */
        do {
            System.out.println("Please enter an English word/phrase.");
            target = sc.nextLine().toLowerCase();

            /* Avoiding illegal inputs. */
            try{
                /* root out the surplus blanks. */
                target = mergeBlank(target);
                target  = trim(target);


                Date date = new Date();
                System.out.println(algorithm.searchWord(array, target));
                Date date1 = new Date();
                System.out.println("Time costs: " + (date1.getTime() - date.getTime()) + "ms");
                System.out.println();
            }catch(StringIndexOutOfBoundsException e){
                System.out.println("Illegal character input!(Maybe it is not an English word....)");
                continue;
            }


            /* Continue? */
            Thread.sleep(1000);
            System.out.println("Do you want to continue the searching?(type 'y' for agree or type anything else to exit.)");
            answer = sc.nextLine();
            if(answer.length() > 3){
                System.out.println();
                System.out.println("You seems like type a phrase, plz check again.(type 'y' for continue the searching)");
                answer = sc.nextLine();
            }
        }while(answer.equals("y"));
    }


    /**Find blanks */
    public static int getBlank(String str, int index) {
        if (index < str.length()) {
            if (str.charAt(index) == ' ') {
                return getBlank(str, index + 1) + 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    /**
     * Bleach out surplus blanks between word and word.
     * @param str the string that user want to bleach out surplus blanks from inside a phrase.
     * @return return a new string.
     */
    public static String mergeBlank(String str) {
        int num;
        String a;
        String b;
        for (int i = 0; i < str.length(); i++) {
            num = getBlank(str, i);
            if (num >= 2) {
                a = str.substring(0, i);
                b = str.substring(i + num - 1);
                str = a + b;
            }
        }
        return str;
    }

    /**
     * bleach out surplus blanks.
     * @param str String input.
     * @return new String.
     */
    public static String trim(String str){
        if(str.charAt(0) == ' '){
            str = str.substring(1);
        }

        if (str.charAt(str.length() -1) == ' '){
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }


}
