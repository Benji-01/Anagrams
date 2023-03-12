import java.util.Random;

public class letters { 
    public static char[] freqlet = "ETASOINRHDLUCMFYWGPBVKXQJZ".toCharArray();
    public static double[] freq = new double[] {12.02, 9.10, 8.12, 7.68, 7.31, 6.95, 6.29, 6.02, 5.92, 4.32, 3.98, 2.88, 2.71, 2.61, 2.30, 2.11, 2.09, 2.03, 1.82, 1.49, 1.11, 0.69, 0.17, 0.11, 0.10, 0.07};
    public static char[] vowels = "AEIOU".toCharArray();

    public static char[] get_Letters(){
        //char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] letter = new char[6];
        int vowelcount = 0;
        /*for(int i = 0; i<1; i++){
            letter[i] = vowels[rand.nextInt(5)];
        }*/
        for(int i = 0; i<6; i++){
            letter[i] = chooseLetter();
            boolean isVowel = isVowel(letter[i]);
            if(isVowel && vowelcount==3){
                while(isVowel){
                    letter[i] = chooseLetter();
                    isVowel = isVowel(letter[i]);
                }
            }else if(isVowel && vowelcount<3){
                vowelcount++;
            }
        }
        Random rand = new Random();
        if(vowelcount == 0){
            letter[rand.nextInt(6)] = vowels[rand.nextInt(5)];
        }
        return letter;
    }
    public static char chooseLetter(){
        double x = Math.random() *100;
        //System.out.println(x);
            int y = 0;
            while(x > freq[y]){
                x -= freq[y];
                y++;
            }
            return freqlet[y];
    }
    public static boolean isVowel(char c){
            boolean isVowel = false;
            for(char x : vowels){
                if(c == x){
                    isVowel = true;
                }
            }
            return isVowel;
    }
    public static void show(char[] bag){
        for(int i = 0; i<5; i++){
            System.out.print(bag[i] + ", ");
        }
        System.out.println(bag[5]);
    }

}
