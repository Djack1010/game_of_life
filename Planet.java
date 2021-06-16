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
    //  vicini sono entrambi 1 ed i è 0 -> i diventa 1 (nuova nascita)
    //  vicini sono entrambi 1 ed i è 1 -> i diventa 0 (morte per sovrappopolazione)
    //  vicini sono uno 0 e l'altro 1	 -> i non cambia (sopravvivenza)
    //  vicini sono entrambi 0		 -> i diventa 0 nel 90% dei casi (morte per sottopopolazione) oppure 1 nel 10% (nascita spontanea)
    // Il board va considerato CIRCOLARE (es: il vicino sx di i=0 è i=board.length-1), e il metodo deve anche aggiornare il count del turno
    public void oneTurn(){
    	Integer[] arraySupporto = new Integer[board.length];
    	Random rand = new Random(); //creo una variabile Random per valutare il caso 4
    	//creo array copia su cui lavorare
    	for(int i = 0; i < board.length; i++) {
    		arraySupporto[i] = board[i];
    	}
    	
        for(int i = 0; i < arraySupporto.length; i++) {
        	
        	//caso in cui i sia alla prima posizione dell'array
        	if(i == 0) {
        		if (arraySupporto[arraySupporto.length - 1] == 1 & arraySupporto[i + 1] ==1) {
        			if(arraySupporto[i] == 1) arraySupporto[i] = 0;
        			else arraySupporto[i] = 1;
        		}
        		if (arraySupporto[arraySupporto.length - 1] == 0 & arraySupporto[i + 1] == 0) {
        			if(rand.nextInt(100) <= 90) arraySupporto[i] = 0;
        			else arraySupporto[i] = 1;
        		}
        		
            	if(arraySupporto[arraySupporto.length - 1] == 0 ^ arraySupporto[i + 1] == 0) arraySupporto[i] = arraySupporto[i];

        		
        	}	
        	//caso in cui i sia nel mezzo dell'array
        	if(i != 0 & i != arraySupporto.length - 1) {
        		if(arraySupporto[i - 1] == 1 && arraySupporto[i + 1] == 1) {
        			if(arraySupporto[i] == 1) arraySupporto[i] = 0;
        			else arraySupporto[i] = 1;
        		}
        		
        		if(arraySupporto[i - 1] == 0 ^ arraySupporto[i + 1] == 0) arraySupporto[i] = arraySupporto[i];
        		
        		
        		
        		if (arraySupporto[i - 1] == 0 & arraySupporto[i + 1] == 0) {
        			if(rand.nextInt(100) <= 90) arraySupporto[i] = 0;
        			else arraySupporto[i] = 1;
        		}
        	}
        		
        	//caso in cui i sia all'ultima posizione dell'array
            if(i == arraySupporto.length - 1) {
            	if (arraySupporto[i - 1] == 1 & arraySupporto[0] == 1) {
            		if(arraySupporto[i] == 1) arraySupporto[i] = 0;
            		else arraySupporto[i] = 1;
            	}
            		
           		if (arraySupporto[i - 1] == 0 & arraySupporto[0] == 0) {
           			if(rand.nextInt(100) < 90) arraySupporto[i] = 0;
           			else arraySupporto[i] = 1;
           		}
           		
            	if(arraySupporto[i - 1] == 0 ^ arraySupporto[0] == 0) arraySupporto[i] = arraySupporto[i];

           	}
        }
        
        for(int i = 0; i < arraySupporto.length; i++) board[i] = arraySupporto[i];
		
		turn ++;
    }

    public int getTurn() {return this.turn;}

}
