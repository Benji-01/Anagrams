import java.util.Arrays;
import java.util.HashSet;

public class Checker {
    public static int[] points = {100, 400, 1200, 2000};
    public static int score = 0;
    public static HashSet<String> used = new HashSet<String>(); 

    public static boolean check_word(String guess){
        if(guess.length() <= 2){
            return false;
        }
        if(Main.set.contains(guess)){
            if(used.contains(guess)){
                System.out.println("This has already been used!");
                return false;
            }else{
            score += points[guess.length()-3];
            used.add(guess);
            return true; 
            }
            
        }
        return false;
    }

    public static boolean check_anagram(String guess){
        int[] freq2 = Arrays.copyOf(Main.freq, 26);
        for(char c : guess.toCharArray()){ 
            freq2[c-'A']--;
            if(freq2[c-'A'] < 0){
                return false;
            }
        }
        return true;
    }
}
