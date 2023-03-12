import java.io.File;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static boolean okay;
    public static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static int wordcount;
    public static int listcount;
    public static int[] freq;
    public static Scanner scanner;
    public static void main(String[] args) throws Exception {
        
        File myObj = new File("src\\words.txt"); // reads scrabble dictionary and puts into set
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()){
            String data = myReader.nextLine();
            set.add(data);
        }
        myReader.close();

        char[] bag = letters.get_Letters(); // get letters from letters class
        freq = frequency(bag);
        while(wordlist().size() < 40){ // makes possible words at least 40
            bag = letters.get_Letters();
            freq = frequency(bag);
        }
        letters.show(bag); // prints letters
        
        Timer timer = new Timer(); // timer
        timer.schedule(new TimerTask() {
            @Override 
            public void run(){
                okay = true;
                System.out.println("Timer is up!");
                System.out.println("Words: " + wordcount);
                System.out.println("Score: " + Checker.score);
                System.out.println("See all possible words? (yes/no)");
            }
        }, 20000); // delay in miliseconds before run executes

        scanner = new Scanner(System.in); // checking user input guesses
        while(true){
            String guess = scanner.nextLine().toUpperCase();
            boolean correct = Checker.check_word(guess);
            boolean in_bag = Checker.check_anagram(guess);
            
            if(correct && in_bag){
                wordcount++;
            }
            if(guess.equals("YES") && okay){
                for(String s: wordlist()){
                    System.out.println(s);
                }
                System.out.println("Possible Words: " + wordlist().size());
                break;
            }else if(okay){
                break;
            }
        }

        System.out.println("Thanks for playing!");
    }

    public static int[] frequency(char[] bag){ // setting the frequence array from the letter bag
        int[] freq = new int[26];
        for(char c : bag){
            freq[c-'A']++;
        }
        return freq;
    }

    public static LinkedHashSet<String> wordlist(){ // possible words put into a hashset
        LinkedHashSet<String> possible = new LinkedHashSet<>();
        for(String str : set){
            if(str.length() <=2){
                continue;
            }
            if(Checker.check_anagram(str)){
                possible.add(str);
            }
        }
       return possible;
    }
}
