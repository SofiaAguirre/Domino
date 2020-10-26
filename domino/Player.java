
package domino;

import java.util.ArrayList;

public class Player {

    private Domino domino;
    private RandomNumber random;
    private ArrayList<String> dominos = new ArrayList<>();


    public Player(Domino domino, RandomNumber random){
        this.domino = domino;
        this.random = random;
        createHand();
    }

    public void createHand(){
        int startingHand = 10;
        for(int i = 0; i < startingHand; i++){
            giveDomino();
        }
    }

    public void giveDomino(){
        int number = RandomNumber.getRandom();
        String piece = domino.getDomino(number);
        dominos.add(piece);
        random.remaining();
    }

    public String getDomino(int chosen){
        return dominos.get(chosen);
    }

    public void removeDomino(int chosen){
        dominos.remove(chosen);
    }

    public int getDominoCount(){
        return dominos.size();
    }

    public String printHand(){
        StringBuilder hand = new StringBuilder();
        for(int i = 0; i < dominos.size(); i++){
            String[] handPiece = dominos.get(i).split("");
            hand.append(i + 1).append(":").append("[").append(handPiece[0]).append("|").append(handPiece[1]).append("]").append(" ");
        }
        return hand.toString();
    }

}
