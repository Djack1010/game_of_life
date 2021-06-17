import java.util.Arrays;
import java.lang.Math;

public class Planet {

  Integer[] board;
    Integer [] newBoard;
    int turn;
    int l=0;
    boolean life =true;

// Deve gestire la conversione da 'input' a 'board'
// ESEMPIO: 'input' = '1001010' -> 'board' = [ 1, 0, 0, 1, 0, 1, 0 ]
    
    public Planet(String input){
    	this.turn = 0;
    	this.l =input.length();
    	this.board = new Integer[l];
    	this.newBoard = new Integer[l];
    	
		for (int i=0; i < l; i++) {
			char a = input.charAt(i);
			this.board[i]= Character.getNumericValue(a);
			this.newBoard[i]= Character.getNumericValue(a);	
			}	
	}


	public void printBoard(){
        for (int i = 0; i < this.board.length; i++) {
        	System.out.print(this.board[i] + "  ");
        }
        System.out.println();
    }


    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    public boolean lifeOnPlanet(){
  	
    	for (int i = 0; i<l;i++) {
    		if (this.board[i]==1) 
    			return true;
    		}
        return false;
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
   	
    	int left,central, right;
    	for (int i= 0; i < board.length; i++){
// se indice del elmento centrale pari a 0, left sarà l'ultimo elemento array
    		if(i== 0) {
    			left = board.length-1;
    			central = i;
    			right = i+1;
    		}
 // se elemento centrale è predultimo elemento, indice di elemento left è length-2, right avrà indice a 0
    		else if(i== board.length-1) {
    			left = board.length-2;
    			central = board.length-1;
    			right = 0;
    		}    		
    		else {
    			left = i-1;
    			central = i;
    			right = i+1;
    		}
    		
  //  vicini sono entrambi 1 ed i è 0 -> i diventa 1 (nuova nascita)		1, 0, 1 -> 1, 1, 1    		
    		if (board[left] ==1 && board[central]==0 && board[right]==1){
    			newBoard[central]=1;
    		}
//  vicini sono entrambi 1 ed i è 1 -> i diventa 0 (morte per sovrappopolazione)	1, 1, 1 -> 1, 0, 1   	
    		if (board[left] ==1 && board[central]==1 && board[right]==1) {
    			newBoard[central]=0;}
    		 		
//  vicini sono entrambi 0     -> i diventa 0 nel (morte per sottopopolazione)	0, 1, 0 -> 0, 0, 0    / 0, 0, 0 -> 0, 0, 0		
    		if ((board[left] ==0 && board[central]==1 && board[right]==0) ||
    			(board[left] ==0 && board[central]==0 && board[right]==0)){
    			newBoard[central]=0;}
    	}

// copia array modificato in originala
    	
	for (int j = 0; j<board.length; j++) {
    		board[j]= newBoard[j];
    	}
    	this.turn++;
    }

    public int getTurn() {return this.turn;}

}
