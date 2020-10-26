package src;

public class Table {
    
    private static String openLeft = "";
    private static String openRight = "";
    
    public Table(){
        
    }

    public void placeFirst(String first){
        String[] placed = first.split("");
        openLeft = placed[0];
        openRight = placed[1];
    }

    public void placePiece(String side, String piece, Player player, int domino){
        boolean matchL;
        boolean matchR;
        boolean twin;
        String[] played = piece.split("");
        if(side.toLowerCase().equals("izquierda")){
            matchL = (played[0].equals(openLeft));
            matchR = (played[1].equals(openLeft));
            twin = (matchL && matchR);
            if(twin){
                openLeft = played[1];
                player.removeDomino(domino);
            }
            else if(matchL){
                openLeft = played[1];
                player.removeDomino(domino);
            }
            else if(matchR){
                openLeft = played[0];
                player.removeDomino(domino);
            }
            else{
                System.out.println("Pieza invalida, el turno es concedido al siguiente jugador.");
            }
        }
        else if(side.toLowerCase().equals("derecha")){
            matchL = (played[0].equals(openRight));
            matchR = (played[1].equals(openRight));
            twin = (matchL && matchR);
            if(twin){
                openRight = played[1];
                player.removeDomino(domino);
            }
            else if(matchL){
                openRight = played[1];
                player.removeDomino(domino);
            }
            else if(matchR){
                openRight = played[0];
                player.removeDomino(domino);
            }
            else{
                System.out.println("Pieza invalida, el turno es concedido al siguiente jugador.");
            }
        }
        
    }


    public static String getLeft(){
        return openLeft;
    }

    public static String getRight(){
        return openRight;
    }

    public static String openEnds(){
        String open = "";
        open += "Numero disponible izquierdo: " + getLeft() + "\nNumero disponible derecho " + getRight();
        return open;
    }

}
