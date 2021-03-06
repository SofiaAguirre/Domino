
package src;

import java.util.Scanner;

public class Game {
    
    private static int dominoPieces = 28;
    private static boolean canPlay = true;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Domino domino = new Domino();
        RandomNumber random = new RandomNumber(dominoPieces);
        Player player1 = new Player(domino, random);
        Player player2 = new Player(domino, random);
        Table table = new Table();
        //Luego de que ambos jugadores tengan sus respectivas manos quedaran 14 fichas
        dominoPieces = 14;
        int turn = 1;
        System.out.println();
        System.out.println("Jugador1: Elija una pieza para comenzar el juego:");
        System.out.println(player1.printHand());
        int start = input.nextInt();
        input.nextLine();
        start--;
        String firstPiece = player1.getDomino(start);
        player1.removeDomino(start);
        table.placeFirst(firstPiece);
        turn++;
        
        //booleanos, demuestra si los jugadores tienen fichas para jugar
        boolean playerOnePieces = true;
        boolean playerTwoPieces = true;

        while(canPlay && playerOnePieces && playerTwoPieces){
            
            if(player1.getDominoCount() <= 0){
                playerOnePieces = false;
            }
            else if(player2.getDominoCount() <= 0){
                playerTwoPieces = false;
            }
            if(turn % 2 == 1){
                //Jugador1
                int type = 1;
                turn = playTurn(input, player1, table, turn, type);
            } else if(turn % 2 == 0){
                //Jugador2
                int type = 2;
                turn = playTurn(input, player2, table, turn, type);
            }
        }
        winner(player1, player2);
    }

    private static int playTurn(Scanner input, Player player, Table table, int turn, int type) {
        System.out.println(Table.openEnds());
        System.out.println(player.printHand());
        System.out.println("Jugador" + type + ": \n 1-Seleccionar pieza \n 2-Pasar");
        choice(input, player, table);
        turn++;
        return turn;
    }

    private static void choice(Scanner input, Player player, Table table){
        int choice;
        choice = input.nextInt();
        if(choice == 2){
            pass(player);
        }
        else if(choice == 1){
            place(input, player, table);
        }
        else{
            System.out.println("Elección inválida, el turno es concedido al siguiente jugador.");
        }
    }

    private static void pass(Player player){
        dominoPieces--;
        if(dominoPieces > 0){
            player.giveDomino();
            System.out.println("Se ha agarrado una pieza aleatoria de las restantes.");
        }
        else{
            System.out.println("No quedan más piezas disponibles.");
            canPlay = false;
        }
    }

    private static void place(Scanner input, Player player, Table table){
        System.out.println("Seleccione una pieza: ");
        int domino = input.nextInt();
        input.nextLine();
        domino--;
        String piece = "" + player.getDomino(domino);
        System.out.println("En qué lado de la tabla le gustaría posicionarla? Escriba 'izquierda' o 'derecha':");
        String side = input.nextLine();
        table.placePiece(side, piece, player, domino);
    }

    private static void winner(Player player1, Player player2){
        if(player1.getDominoCount() < player2.getDominoCount()){
            System.out.println("Jugador1 es el ganador!");
            System.out.println("Con: " + player1.getDominoCount() + " piezas!");
        } else if(player1.getDominoCount() > player2.getDominoCount()){
            System.out.println("Jugador2 es el ganador!");
            System.out.println("Con: " + player2.getDominoCount() + " piezas!");
        } else{
            System.out.println("Empate");
        }
    }
    
}
