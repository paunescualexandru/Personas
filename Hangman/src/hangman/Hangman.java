
package hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class Hangman {
    
    String mysteryWord;
    StringBuilder currentGuess;
    ArrayList<Character> previousGuessess =  new ArrayList<>();
    
    int maxTries = 6;
    int currentTry = 0;
    
    ArrayList<String> dictionary =  new ArrayList<>();
    private static FileReader fileReader;
    private static BufferedReader bufferedFileReader;
    
    public Hangman() throws IOException {
        initializeStreams();
        mysteryWord = pickWord();
        currentGuess = initializeCurrentGuess();
    }
    
    public void initializeStreams() throws IOException {
        try {
            File inFile = new File("C:\\Users\\Dinamo\\Documents\\NetBeansProjects\\SideProject\\SideProject\\src\\hangmanapplication\\dictionary.txt");
            fileReader = new FileReader(inFile);
            bufferedFileReader = new BufferedReader(fileReader);
            String currentLine = bufferedFileReader.readLine();
            while (currentLine != null) {
                dictionary.add(currentLine);
                currentLine = bufferedFileReader.readLine();
            }
            bufferedFileReader.close();
            fileReader.close();
        } catch(IOException e) {
            System.out.println("Could not init streams");
    }
    }
    public String pickWord() throws IOException, ArithmeticException{
        Random rand =  new Random();
        int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
        return dictionary.get(wordIndex);
    }
    
    //  _A_ _ _ _ _ 
    
    public StringBuilder initializeCurrentGuess(){
        StringBuilder current = new StringBuilder();
        for( int i = 0; i < mysteryWord.length() *2; i++){
            if(i % 2 == 0){
                current.append("_");
            }else{
                current.append(" ");
            }
        }
        return current;
    }
    
    // _ _A_ _B_
    public String getFormalCurrentGuess(){
        return "Current Guess: " + currentGuess.toString();
    }
    
    public boolean gameOver(){
        if(didWeWin()){
            System.out.println("");
            System.out.println("Congrats! You won! You guessed the right word");
            return true;
        }else if(didWeLose()){
            System.out.println("");
            System.out.println("Sorry, you lost. You spent all your 6 tries."
                    + "The word was " + mysteryWord + ".");

            return true;
        }
        return false;
    }
    
    public boolean didWeLose(){
        return currentTry >= maxTries;
    }
    
    
    public boolean didWeWin(){
        String guess = getCondensedCurrentGuess();
        return guess.equals(mysteryWord);
    
    }
    
    public String getCondensedCurrentGuess(){
        String guess = currentGuess.toString();
        return  guess.replace(" ", "");
    }
    
    public boolean isGuessedAlready(char guess){
        return previousGuessess.contains(guess);
    }
    
    public boolean playGuess(char guess){
       boolean isItAGoodGuess  = false;
       for(int i = 0; i < mysteryWord.length(); i++){
           if(mysteryWord.charAt(i) == guess){
               currentGuess.setCharAt(i *2, guess);
               isItAGoodGuess = true;
               previousGuessess.add(guess);
           }
       }
       
       if (!isItAGoodGuess){
           currentTry++;
       }
       return isItAGoodGuess;
    }
    
//" - - - - -\n"+
//"|        |\n"+
//"|        O\n" +
//"|      / | \\ \n"+
//"|        |\n" +
//"|       / \\ \n" +
//"|\n" +
//"|\n";
    
    public String drawPicture(){
        switch(currentTry){
            case 0: return noPersonDraw();
            case 1: return addHeadDraw();
            case 2: return addBodyDraw();
            case 3: return addOneArmDraw();
            case 4: return addSecondArmDraw();
            case 5: return addFristLegDraw();
            case 6: return fullPersonDraw();
            default: return fullPersonDraw();
        }
    }

    private String noPersonDraw() {
       return   " - - - - -\n"+
                "|        |\n"+
                "|        \n" +
                "|      \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addHeadDraw() {
       return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        \n"+
                "|        \n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addBodyDraw() {
       return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|        |  \n"+
                "|        |\n" +
                "|       \n" +
                "|\n" +
                "|\n";
    }

    private String addOneArmDraw() {
       return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|       /|  \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addSecondArmDraw() {
       return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }
    
     private String addFristLegDraw() {
               return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       /  \n" +
                "|\n" +
                "|\n";
    }

    private String fullPersonDraw() {
              
       return   " - - - - -\n"+
                "|        |\n"+
                "|        O\n" +
                "|      / | \\ \n"+
                "|        |\n" +
                "|       / \\ \n" +
                "|\n" +
                "|\n";
    }

   
    
}
