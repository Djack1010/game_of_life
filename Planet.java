import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class Planet {
	List<Integer> board = new ArrayList<Integer>(); //meglio la lista array
    int turn;
    

    // Deve gestire la conversione da 'input' a 'board'
    // ESEMPIO: 'input' = '1001010' -> 'board' = [ 1, 0, 0, 1, 0, 1, 0 ]
    public Planet(String in){
    	int input = Integer.parseInt(in);    //converto la stringa in int
    	//int length = String.valueOf(in).length();
    	while (input > 0) {
   	     board.add(0, input%10);  // senza lo 0 l'array verrebbe al contrario
   	     input/=10;
   	 }
    	//System.out.println(board.size());
    }

    public void printBoard(){
    	int length = board.size();
        int i = 0;
        String boardditesto = "";
        while (i < length) {
        	boardditesto += board.get(i);
        	i++;
        }
        System.out.println(boardditesto);
        
    }

    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    public boolean lifeOnPlanet(){
    	int length = board.size();
    	int i = 0;
        while (i < length) {
        	if(board.get(i) == 1) {
        		return true;
        	}
        	else {
        	i++;
        }
      }
        System.out.println("non trovo nulla");
    	return false;  //ritorna falso se alla fine del ciclo non trova nessun 1
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