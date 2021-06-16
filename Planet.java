import java.util.Arrays;
import java.lang.Math;

public class Planet {

    Integer[] board;
    int turn;
    int lunghezzaStringa;	// ** Variabile contenente la lunghezza della stringa inserita dall'utente

    // Deve gestire la conversione da 'input' a 'board'
    // ESEMPIO: 'input' = '1001010' -> 'board' = [ 1, 0, 0, 1, 0, 1, 0 ]
    public Planet(String input){
        // TODO: implement
    	lunghezzaStringa=input.length();    
    	board = new Integer[lunghezzaStringa];
    	// System.out.println(lunghezzaStringa);		
    	for(int i=0;i<lunghezzaStringa;i++) {
    		board[i]=Character.getNumericValue(input.charAt(i));
    	}
    	    	
    }

    public void printBoard(){
        // TODO: implement
    	for(int i=0;i<lunghezzaStringa;i++) {
    		System.out.print(board[i]);
    		
    		
    	}
    	
    	
    	
    }

    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    public boolean lifeOnPlanet(){
        // TODO: implement
    	return true;
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
