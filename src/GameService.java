import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameService {

    public void start() throws FileNotFoundException {

        Scanner inputScanner = new Scanner(System.in);

        String word = getRandomWord();
        char[] randomWordArray = word.toCharArray();
        char[] guessingWord = new char[word.length()];
        Arrays.fill(guessingWord,'_');
        int chances = 5;
        int guessedLetters=0;
        guessingWord[0] = randomWordArray[0];
        guessingWord[word.length()-1] = randomWordArray[word.length()-1];

        for(int i=0;i<word.length();i++) {
            if (word.charAt(0) == word.charAt(i) ) {
                guessingWord[i] = randomWordArray[i];
                guessedLetters++;
            }
        }
        for(int i=0;i<word.length();i++) {
            if (word.charAt(word.length()-1) == word.charAt(i) ) {
                guessingWord[i] = randomWordArray[i];
                guessedLetters++;
            }
        }

        System.out.println("Word: " + new String(guessingWord));


        while (chances>0){
            System.out.println("----------------------------------");
            System.out.println("Insert letter: ");

            boolean ok = false;

            char letter = inputScanner.nextLine().charAt(0);

            for(int i=0;i<word.length();i++) {
                if (letter == word.charAt(i)) {
                    ok=true;
                    guessingWord[i] = randomWordArray[i];
                    guessedLetters++;
                    System.out.println(guessedLetters);
                }
            }
            if(!ok){
                chances--;
            }

            System.out.println("Remaining chances: " + chances);
            System.out.println("Word: " + new String(guessingWord));

            if(guessedLetters==word.length()){
                System.out.println("You won !");
                break;
            }
        }
        if(chances==0){
            System.out.println("You lost!");
        }
    }


    private List <String> getWords() throws FileNotFoundException {
        List<String> words = new ArrayList<>();

        File wordsFile = new File("src/words.txt");

        Scanner wordScanner = new Scanner(wordsFile);
        while(wordScanner.hasNextLine()){
            words.add(wordScanner.nextLine());
        }
        return  words;
    }

    private String getRandomWord() throws FileNotFoundException {
        List<String> words = getWords();

        Random randomNumberGenerator = new Random();
        int index = randomNumberGenerator.nextInt(words.size());
        return words.get(index);
    }
}
