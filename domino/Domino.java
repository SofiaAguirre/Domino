
package domino;

import java.util.ArrayList;

public class Domino {

    private static ArrayList<String> set = new ArrayList<>();

    public Domino (){
        createSet();
    }

    public ArrayList createSet(){
        int[][] createSet = new int[7][];
        for(int i = 0; i < createSet.length; i++){
            int[] pieces = new int[i+1];
            for(int j = 0; j <= i; j++){
                pieces[i] = j;
            }
            createSet[i] = pieces;
        }
        for(int i = 0; i < createSet.length; i++){
            for(int j = 0; j < createSet[i].length; j++){
                String domino = "" + j + i;
                set.add(domino);
            }
        }
        return set;
    }

    public static String getDomino(int number){
        String picked = set.get(number);
        set.remove(number);
        return picked;
    }

}
