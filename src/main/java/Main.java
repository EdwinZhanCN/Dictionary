import java.util.ArrayList;

public class Main {
    /**
     * start program
     * @param args .
     * @throws Exception .
     */
    public static void main(String[] args) throws Exception{
        ArrayList<Translation> translations = new ArrayList<>();
        fileReader.readFile(translations,"English Chinese Translations.csv");
        userInteraction.doAction(translations);
    }
}
