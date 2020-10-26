
package src;

import java.util.Random;

public class RandomNumber {
    
    private static int remain = 0;

    public RandomNumber(int pieces){
        remain = pieces;
    }

    public void remaining(){
        remain--;
    }

    public static int getRandom(){
        Random rand = new Random();
        return rand.nextInt(remain);
    }
    
}
