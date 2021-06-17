import java.util.Arrays;
import java.util.Random;

public class Planet {

    private Integer[] board;
    private int turn = 0;

    public Planet(String input){
		board = new Integer[input.length()]; 
        for(int i = 0; i <input.length(); i++){
			board[i] = Character.getNumericValue(input.charAt(i)); 
		}
		
    }

    public void printBoard(){
        for(int i = 0; i < board.length; i++){
			System.out.print(board[i] + "  ");
		}
        System.out.print("\n");
    }

    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    //il ritorno lo faccio fare tramite una variabile boolean che serve come controllo
    public boolean lifeOnPlanet(){
    	boolean isAlive = false;
    	
        for(int i = 0; i < board.length; i++){

 			if(board[i] == 1) return true;
 		}
        return false;

    }
    
    // basandosi sul board attuale, lo aggiorna per il successivo turno sequendo le seguenti regole:
    // PER ogni elemento i del board SE:
    //  vicini sono entrambi 1 ed i è 0 -> i diventa 1 (nuova nascita)
    //  vicini sono entrambi 1 ed i è 1 -> i diventa 0 (morte per sovrappopolazione)
    //  vicini sono uno 0 e l'altro 1	 -> i non cambia (sopravvivenza)
    //  vicini sono entrambi 0		 -> i diventa 0 nel 90% dei casi (morte per sottopopolazione) oppure 1 nel 10% (nascita spontanea)
    // Il board va considerato CIRCOLARE (es: il vicino sx di i=0 è i=board.length-1), e il metodo deve anche aggiornare il count del turno
    public void oneTurn(){
    	
    	//creo array copia su cui lavorare
    	Integer[] arraySupporto = Arrays.copyOf(board, board.length);
    	Random rand = new Random(); //creo una variabile Random per valutare il caso 4
    	
    	for(int i = 0; i < arraySupporto.length; i++) {
    		
        	Integer vicinoSx = 0;
        	Integer vicinoDx = 0;
    		
    		if(i == 0) {
    			vicinoSx = board[arraySupporto.length - 1];
            	vicinoDx = board[i + 1];
    			
    		} else if(i == board.length - 1) {
            	vicinoSx = board[i - 1];
    			vicinoDx = board[0];
    		}
    		else if(i > 0 && i < arraySupporto.length - 1){
            	vicinoSx = board[i - 1];
            	vicinoDx = board[i + 1];
    		}
    	
    		
    		 
    		if(vicinoSx == 1 && board[i] == 1 && vicinoDx == 1) arraySupporto[i] = 0;
    		if(vicinoSx == 1 && board[i] == 0 && vicinoDx == 1) arraySupporto[i] = 1;
    		
    		if(vicinoSx == 0 && board[i] == 1 && vicinoDx == 0) arraySupporto[i] = 0;
    		if(vicinoSx == 0 && board[i] == 0 && vicinoDx == 0) {
    				if(rand.nextInt(100) < 90) arraySupporto[i] = 0;
    				else arraySupporto[i] = 1;
    			}
    		
    	}
    	
        
        for(int i = 0; i < arraySupporto.length; i++) board[i] = arraySupporto[i];
		
		turn ++; 
       	

    }


    public int getTurn() {return this.turn;}

}
