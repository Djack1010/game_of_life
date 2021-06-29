import java.util.Arrays;
import java.lang.Math;

public class Planet {

    Integer[] board;
    int turn;

    public Planet(String input){
        turn = 0;
        board = new Integer[input.length()];
        for(int i=0;i<input.length();i++){
            board[i] = Character.getNumericValue(input.charAt(i));
        }
    }

    public void printBoard(){
        for(int i=0;i<this.board.length;i++){
            System.out.print(board[i]);
        }
        System.out.println();
    }

    public boolean lifeOnPlanet(){
        for(int i=0;i<this.board.length;i++){
            if (this.board[i]==1){
                return true;
            }
        }
        return false;
    }

    public void oneTurn(){
        // Copio la situazione di board al turno precedente
        Integer[] previousTurn = Arrays.copyOf(this.board, this.board.length);

        // itero su previousTurn per costruire il board successivo
        for (int i=0;i<previousTurn.length;i++){

            // mi salvo la situazione della casella sx, se i==0 prendo l'ultima
            int left = previousTurn[previousTurn.length-1];
            if (i!=0)
              left = previousTurn[i-1];

            // mi salvo la situazione della casella dx, se i==ultima prendo zero
            int right = previousTurn[0];
            if (i!=previousTurn.length-1)
              right = previousTurn[i+1];
            
            // se a sx e dx c'è 0, metto 0
            // caso fine sottopopolazione (010->000)
            if (left == 0 && right == 0){
                  this.board[i] = 0;
                              
            // se a sx e dx c'è 1, metto 1 se c'era 0 e viceversa
            // caso nascita (101->111) e fine sovrappopolazione (111->101)
            } else if (left == 1 && right == 1)
              if (this.board[i] == 1)
                this.board[i] = 0;
              else
                this.board[i] = 1;
                
            // tutte le altre casistiche, lascio invariata la situazione
            
        }

        this.turn += 1;
    }

    public int getTurn() {return this.turn;}

}
