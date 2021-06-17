/***********************************************
*	Paolo Bondi - Corso TIC (UF6) - 17/06/21   *
*	Esercizio - Game of life                   *											
***********************************************/

import java.util.Arrays;
import java.lang.Math;

public class Planet {

    Integer[] board;
    Integer n1=0, n2=0, n3=0;
    int turn;
    int lunghezzaStringa;	// ** Variabile contenente la lunghezza della stringa inserita dall'utente
    int contatore;			// ** variabile che conta quanti 1 ci sono nella stringa
    boolean ceVita;

    // Deve gestire la conversione da 'input' a 'board'
    // ESEMPIO: 'input' = '1001010' -> 'board' = [ 1, 0, 0, 1, 0, 1, 0 ]
    public Planet(String input){
        // TODO: implement
    	this.turn = 0;		// ** Inizializzo turno
    	this.lunghezzaStringa=input.length();    
    	this.board = new Integer[lunghezzaStringa];
    	// System.out.println(lunghezzaStringa);		
    	for(int i=0;i<lunghezzaStringa;i++) {
    		this.board[i]=Character.getNumericValue(input.charAt(i));
    	}
  }

    public void printBoard(){
    	    	
    	for(int z=0;z<10;z++)											//  Routine per generare 
    	{																//  una pausa
    		long timestamp = System.currentTimeMillis();				//   
    		do {														//  
      	    } while (System.currentTimeMillis() < timestamp + 100);		//  -- > la pausa si esprime in millisecondi
    	}			
   	
    	
    	// TODO: implement
    	for(int i=0;i<lunghezzaStringa;i++) {
    		System.out.print(board[i]);
    	}
    	System.out.println();
    }
    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    public boolean lifeOnPlanet(){
    	contatore = 0;
    	for(int i=0;i<lunghezzaStringa;i++) {
    		if(board[i]==1) {
    			contatore++;
    		}
    	}
    	
    	if (contatore > 0) 
    	return true;
    	
        // TODO: implement
    	return false;
    }
    
    // basandosi sul board attuale, lo aggiorna per il successivo turno sequendo le seguenti regole:
    // PER ogni elemento i del board SE:
    //  vicini sono entrambi 1 ed i è 0 -> i diventa 1 (nuova nascita)		            1, 0, 1 -> 1, 1, 1
    //  vicini sono entrambi 1 ed i è 1 -> i diventa 0 (morte per sovrappopolazione)	1, 1, 1 -> 1, 0, 1
    //  vicini sono uno 0 e l'altro 1	 -> i non cambia (sopravvivenza)		        1, 1, 0 -> 1, 1, 0
    //											                                        0, 1, 1 -> 0, 1, 1
    //  vicini sono entrambi 0     -> i diventa 0 nel (morte per sottopopolazione)	    0, 1, 0 -> 0, 0, 0
    //											                                        0, 0, 0 -> 0, 0, 0
    // Il board va considerato CIRCOLARE (es: il vicino sx di i=0 è i=board.length-1), e il metodo deve anche aggiornare il count del turno
    public void oneTurn(){
        // TODO: implement
    	
    Integer[] boardCopia = new Integer[board.length];
    for(int i=0;i<lunghezzaStringa;i++) {
    	boardCopia[i] = board[i];
    }
    
    for(int i=0;i<lunghezzaStringa;i++) {
    	    	
    	if (i==0) {											// gestione caso i=0
    		n1 = boardCopia[lunghezzaStringa-1];
    	}
    	else n1 = boardCopia[i-1];
    	
    	
    	n2 = boardCopia[i];
    	
    	
    	if (i==(lunghezzaStringa-1)) {						// gestione caso i=lunghezza stringa
    		n3 = boardCopia[0];
    	}
    	else n3 = boardCopia[i+1];
    	
    	
    	if (n2==0 && n1==1 && n3==1) {
    		board[i] = 1;
    	}
    	else if ((n2==1 && n1==1 && n3==1)||(n2==1 && n1==0 && n3==0)){
    		board[i] = 0;
    		
    	}
    }
    
      	
    }

    public int getTurn() {return this.turn;}

}
