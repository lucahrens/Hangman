import java.util.*;
import java.util.Scanner;

public class Hangman {
    
    private String secretWord;
    private String correctLetters;
    private String incorrectLetters;
    private boolean gameWon;
    private boolean gameLost;
    
    /************
    *Constructor/
    ************/
    public Hangman()
    {
        //get secretWord from user
        System.out.println("Please enter the secret word.");
        Scanner sc=new Scanner(System.in);  
        secretWord=sc.nextLine();
        //set correctLetters to _ for each character in secretWord
        int letters = secretWord.length();
        int i = 0;
        correctLetters = "";
        String blank = "_  ";
        while ( i < letters ){
            correctLetters = correctLetters + blank; 
            i++;
        }
        //set incorrectLetters to the empty string
        incorrectLetters = "";
    }
    
    /********************************************
    * Play the game until the user wins or loses*
    ********************************************/
    public void playGame()
    {
        while ( !gameOver() ){
        //get guess from user
        char ch;
        System.out.println("Guess one letter.");
        Scanner sc=new Scanner(System.in);  
        ch = sc.nextLine().charAt(0);
        //call the handleGuess method
        handleGuess(ch);
        //call printHangman
        printHangman();
        //print correctLetters
        System.out.println("Correct guesses");
        System.out.println(correctLetters);
        //printincorrectLetters
        System.out.println("Incorrect guesses");
        System.out.println(incorrectLetters);
        //repeat until gameOver
        }
    
    if ( gameWon == true){
    for ( int i = 0; i < 100; i ++){
    System.out.println("You Won!!!!");
    }
    }
    if ( gameLost == true){
        for ( int i = 0; i < 100; i ++){
    System.out.println("You Lost!!!!");
    }
    }
    }
    
    /*********************************************** 
    * Adds ch to correctLetters if in secretWord or* 
    * adds ch to incorrectLetters if not           *
    *                                              *  
    *@param ch to the gussed letter                *
    ***********************************************/
    private void handleGuess(char ch)
    {       
        int i =  0;
        boolean correct = false;
        if ( correctLetters.indexOf(ch) >= 0 || incorrectLetters.indexOf(ch) >= 0 ){
         playGame();   
        }
        else{
        while ( i < secretWord.length() ){
            if ( ch == secretWord.charAt(i) ){
                correctLetters=correctLetters.substring(0,i*3)
                    +ch+correctLetters.substring(i*3+1,correctLetters.length());
                correct = true;
            }
            i ++;
        }
        if ( correct == false ){
            incorrectLetters = incorrectLetters + ch;
        }
        }
    }
    
    /********************************************************
    * Set gameWon to true if all correctLetters are guessed *
    * and gameLost to true if too many wrong guesses.       *
    * Return true if either won or lost and false otehrwise.*
    *                                                       *
    *@return true if game won or lost and false otherwise.  *
    ********************************************************/
    private boolean gameOver()
    {
        int i = 0;
        while ( i < correctLetters.length()){
            if ( correctLetters.charAt(i) == '_' ){
                gameWon = false;
                break;
            }
            else gameWon = true;
            i ++;
        }
        if ( incorrectLetters.length() == 7 ){
            gameLost = true;
        }
        else gameLost = false;
        if ( gameLost == true || gameWon == true ){
            return true;
        }
        else return false;
    }
    
    /*****************************************************
    * Prints the scaffold for the number of wrong guesses*
    *                                                    *
    * @param numWrong number of wrong guesses            *
    *****************************************************/
    private void printHangman()
    {
      int poleLines = 6;  // number of lines for hanging pole
      System.out.println(" ____");
      System.out.println(" |  |");
      
      int badGuesses = this.incorrectLetters.length();
      if(badGuesses == 7) {
          System.out.println(" |  |");
          System.out.println(" |  |");
      }
      
      if (badGuesses > 0) {
          System.out.println(" |  0");
          poleLines = 5;
      }
      if (badGuesses > 1) {
          poleLines = 4;
          if (badGuesses == 2) {
              System.out.println(" |  |");
          } else if (badGuesses == 3 ){
              System.out.println(" | \\|");
          } else if (badGuesses >= 4) {
              System.out.println(" | \\|/");
          }
    }
      if (badGuesses > 4) {
          poleLines = 3;
          if (badGuesses == 5) {
              System.out.println(" | /");
          } else if (badGuesses >= 6) {
              System.out.println(" | / \\");
          }
      }
      if (badGuesses == 7) {
          poleLines = 1;
      }
      
      for (int k = 0; k < poleLines; k++) {
         System.out.println(" |"); 
      }
      System.out.println("_|___");
      System.out.println();
    }
    
}  


    
