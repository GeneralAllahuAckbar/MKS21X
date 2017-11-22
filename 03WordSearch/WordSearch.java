import java.util.*;
import java.io.*;
public class WordSearch{
    private char[][]data;
    public ArrayList<String> wordsToAdd = new ArrayList<String>();
    public ArrayList<String> wordsAdded = new ArrayList<String>();
    private Random rand;
    private char[][] solution;
    private int seed;
    static Random woah = new Random();


    public WordSearch(int rows,int cols, String fileName){
	     this(rows,cols,fileName, Math.abs(woah.nextInt()));
    }

    public WordSearch(int rows,int cols, String fileName, int randSeed) {
      data = new char[rows][cols];
      solution = new char[rows][cols];
      rand = new Random(randSeed);
      seed = randSeed;
      clear();
      try{
        Scanner in = new Scanner(new File(fileName));
        while (in.hasNext()) {
          wordsToAdd.add(in.next());
        }
      }catch(FileNotFoundException e){
        System.out.println("File not found: " + fileName);
        //e.printStackTrace();
        System.exit(1);
      }
      addAllWords();
      addFiller();
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int i = 0; i < data.length; i++) {
        for (int a = 0; a < data[i].length;a++) {
          data[i][a] = '_';
        }
      }
    }
    /* Returns a string of a grid */
    public String toString(){
      String s = " ";
      //Adding numbers as an outlline for the grid
      for (int a = 0; a < data[0].length; a++) {
        s += " " + a%10 + " ";
      }
      for (int i = 0; i < data.length; i++) {
        s += "\n" + i%10;
        for (int a = 0; a < data[i].length; a++){
          s += " " + data[i][a] + " ";
        }
      }
      return s + "\nSeed:" + seed + "\nWords To Find:\n" + wordsAdded;
    }

    private boolean addWord(String word,int row, int col, int rowInc, int colInc){
      if (rowInc == 0 && colInc == 0) { //False to prevent infinite looping
        return false;
      }
      for (int i = 0; i < word.length(); i++) {
        //Put in a try catch to check that size fits and that letters match in a single loop
        try {
          if (data[row+(rowInc * i)][col+(colInc * i)] != word.charAt(i) && data[row+(rowInc * i)][col+(colInc * i)] != '_') {
            return false;
          }
        }catch(ArrayIndexOutOfBoundsException e) {
          return false;
        }
      //If it gets up to here, the word fits and method proceeds to add the word
      }
      for (int i = 0; i < word.length(); i++) {
        data[row+(rowInc * i)][col+(colInc * i)] = Character.toUpperCase(word.charAt(i));
      }
      return true;
    }

    private boolean addWord(String word, int row, int col) {
      //Math.abs(rand.nextInt()) % 3 returns a value from 0 to 2 inclusive. 1 - the number gives a number from -1 to 1
	     return addWord(word,row,col,1 - (Math.abs(rand.nextInt()) % 3), 1 - (Math.abs(rand.nextInt()) % 3));
    }

    private boolean addAllWords() {
      int a = wordsToAdd.size();
      for (int i = 0; i < a * 8; i++) {
        try {
	         int b = Math.abs(rand.nextInt()) % wordsToAdd.size();
           //Calls addWord with a random initial spot
           if(addWord(wordsToAdd.get(b),Math.abs(rand.nextInt()) % data.length,Math.abs(rand.nextInt()) % data[0].length)) {
             wordsAdded.add(wordsToAdd.remove(b));
           }
           //Update solution
           for (int c = 0; c < data.length; c++) {
             solution[c] = data[c].clone();
           }
        }catch(ArithmeticException e){}
        catch(NullPointerException f){};
      }
      return true;
    }
    //Loops through data and replaces "_"s with random letters
    private void addFiller() {
      for (int i = 0; i < data.length; i++) {
        for (int a = 0; a < data[i].length;a++) {
          if (data[i][a] == '_') {
	           data[i][a] = Character.toUpperCase("abcdefghijklmnopqrstuvwxyz".charAt(Math.abs(rand.nextInt()) % 26));
          }
        }
      }
    }

    public String getSolution() {
      String s = " ";
      //Numbers to outline string - purely aesthetic
      for (int a = 0; a < data[0].length; a++) {
        s += " " + a%10 + " ";
      }
      for (int i = 0; i < solution.length; i++) {
        s += "\n" + i%10;
        for (int a = 0; a < solution[i].length; a++){
          //Removes "_"s to make solution easier to read
          if (solution[i][a] == '_') {
            s += "   ";
          }else{
          s += " " + solution[i][a] + " ";
        }}
      }
      return "==========Solution==========\n" + s;
    }

    public static void main(String[] args) {
      String toPrint = "\n"; //Prints all at once to prevent printing things then having exception occur.
      try {
	  if (args.length == 0) {
	         System.out.println("\n3 Minumum Arguments Required. Proper Usage: java WordSearch [int rows, int cols, String filename [int seed [String key]]]");

	  }
        if (args[0].equals("0") || args[1].equals("0")) {
          System.out.println("You silly buffoon! Making me do all this extra work! How can you possibly have a grid with length/width of 0?!!??!");
        }
	     if (args.length < 4) {
         WordSearch a = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
         toPrint += a + "\n";
       } else if (args.length <= 5) {
         WordSearch a = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
         toPrint += a + "\n";
         if (args[4].equals("key")) {
           toPrint += a.getSolution() + "\n";
         }
       }
     } catch(NumberFormatException e) {
       System.out.println("\n3 Minumum Arguments Required. Proper Usage: java WordSearch [int rows, int cols, String filename [int seed [String key]]]");
       System.exit(1);
     } catch(ArrayIndexOutOfBoundsException e) {
     }
     System.out.println(toPrint);
  }
//just a test for ssh!

}
