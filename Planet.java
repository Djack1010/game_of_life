import java.util.Arrays;
import java.lang.Math;

public class Planet {
    
    // incapsulamento degli attributi della classe
    private Integer[] board;
    private int turn;

    public Planet(String input){
        
        board = new Integer[input.length()];
        char c;
        //inizializzo board con l'input ricevuto
        for (int i=0; i<input.length(); i++) {
            c = input.charAt(i);
            board[i] = Character.getNumericValue(c);
        }
            //board[i] = Integer.parseInt(input.substring(i, 1));
        
        // inizializzo il turno del gioco
        turn = 0;
        
    }

    public void printBoard(){

        // stampo la situazione attuale di board
        for (int i=0; i<board.length; i++)
            System.out.print(board[i] +" ");
        System.out.println();
    }

    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    public boolean lifeOnPlanet(){
        
        // se almeno un elemento di board e' 1 esco dal metodo
        for (int i=0; i<board.length; i++) {
            if (board[i] == 1)
                return true;
        }
        return false;
    }
    
    // basandosi sul board attuale, lo aggiorna per il successivo turno sequendo le seguenti regole:
    // PER ogni elemento i del board SE:
    //  vicini sono entrambi 1 ed i è 0 -> i diventa 1 (nuova nascita)      1, 0, 1 -> 1, 1, 1
    //  vicini sono entrambi 1 ed i è 1 -> i diventa 0 (morte per sovrappopolazione)    1, 1, 1 -> 1, 0, 1
    //  vicini sono uno 0 e l'altro 1    -> i non cambia (sopravvivenza)        1, 1, 0 -> 1, 1, 0
    //                                          0, 1, 1 -> 0, 1, 1
    //  vicini sono entrambi 0     -> i diventa 0 nel (morte per sottopopolazione)  0, 1, 0 -> 0, 0, 0
    //                                          0, 0, 0 -> 0, 0, 0
    // Il board va considerato CIRCOLARE (es: il vicino sx di i=0 è i=board.length-1), e il metodo deve anche aggiornare il count del turno
    public void oneTurn(){
        // TODO: implement
    }

    public int getTurn() {return this.turn;}

}