import java.io.*;
import java.util.*;

public class fileReader {
    /** csv import*/
    public static void readFile(ArrayList<Translation> array, String fileName){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            int position = 0;

            while((line = br.readLine()) != null){
                String[] lineData = line.split(",");
                String English = lineData[0].replace("\"","");
                String Chinese = "";
                for(int i = 1; i < lineData.length; i++){
                    Chinese += lineData[i] .replace("\"", "");
                }
                Translation T = new Translation(English.toLowerCase(), Chinese,position);
                array.add(T);
                position++;
            }

        }catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }catch (IOException e){
            System.out.println("ERR");
            System.exit(0);
        }
    }

}
