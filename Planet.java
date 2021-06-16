import java.util.Arrays;
import java.lang.Math;

public class Planet {

    Integer[] board;
    int turn;

    // Deve gestire la conversione da 'input' a 'board'
    // ESEMPIO: 'input' = '1001010' -> 'board' = [ 1, 0, 0, 1, 0, 1, 0 ]
    public Planet(String input){
        board = new Integer[input.length()]; 
        for(int i = 0; i <input.length(); i++){
			board[i] = Character.getNumericValue(input.charAt(i)); 
		}
	}

    public void printBoard(){
        for(int i = 0; i < board.length; i++){
			System.out.print(board[i] + " - ");
		}
    }

    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    // il ritorno lo faccio fare tramite una variabile boolean che serve come controllo
    public boolean lifeOnPlanet(){
    	boolean isAlive = false;
    	
        for(int i = 0; i < board.length; i++){

 			if(board[i] == 1) isAlive = true;
 		}
        return isAlive;

    }
    
    // basandosi sul board attuale, lo aggiorna per il successivo turno sequendo le seguenti regole:
    // PER ogni elemento i del board SE:
    //  vicini sono entrambi 1 ed i è 0 -> i diventa 1 (nuova nascita)		1, 0, 1 -> 1, 1, 1
    //  vicini sono entrambi 1 ed i è 1 -> i diventa 0 (morte per sovrappopolazione)	1, 1, 1 -> 1, 0, 1
    //  vicini sono uno 0 e l'altro 1	 -> i non cambia (sopravvivenza)		1, 1, 0 -> 1, 1, 0
    //											0, 1, 1 -> 0, 1, 1
    //  vicini sono entrambi 0     -> i diventa 0 nel (morte per sottopopolazione)	0, 1, 0 -> 0, 0, 0
    //											0, 0, 0 -> 0, 0, 0
    // Il board va considerato CIRCOLARE (es: il vicino sx di i=0 è i=board.length-1), e il metodo deve anche aggiornare il count del turno
    public void oneTurn(){
        // TODO: implement
    }

    public int getTurn() {return this.turn;}

}
