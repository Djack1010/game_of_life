import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;
// Author Edoardo
public class Planet {
	List<Integer> board = new ArrayList<Integer>();//meglio la lista array
    int turn;
    

    // Deve gestire la conversione da 'input' a 'board'
    // ESEMPIO: 'input' = '1001010' -> 'board' = [ 1, 0, 0, 1, 0, 1, 0 ]
    public Planet(String in){
    	turn = 0;  //al momento della creazione indicizzo il turno 0
    	//int input = Integer.parseInt(in);    //converto la stringa in int
    	//int length = String.valueOf(in).length();
    	int i = 0;
    	while (i < in.length()) {
   	     board.add(((int) in.charAt(i)) - 48);  // -48 per indicizzare lo 0 nella scala ASCII
   	     i++;
   	 }
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
        System.out.println("Tutta la popolazione e' morta xD");
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
    	List<Integer> boardBackup = new ArrayList<>(board); //faccio si che analizzo la boardBackup ma cambio la board;
        int i = 0;
        while (i < boardBackup.size()) {
        	if (i == 0) {
        		//checkPopolazione(boardBackup.size() -1, boardBackup.get(i), boardBackup.get(i +1));
        		board.set(i, checkPopolazione(boardBackup.get(boardBackup.size() -1), boardBackup.get(i), boardBackup.get(i +1)));
        	}
/*else*/	if (i == boardBackup.size() -1) {
        		board.set(i, checkPopolazione(boardBackup.get(i -1), boardBackup.get(i), boardBackup.get(0)));
        	}
        	 
        	 if ((i > 0) &&(i < (boardBackup.size()-1))) {
        	 board.set(i, checkPopolazione(boardBackup.get(i -1), boardBackup.get(i), boardBackup.get(i +1)));
        	 //i++;
        	 }
        	      i++; 	
        }
        turn++;
    }
    
    public int checkPopolazione(int prima, int i, int dopo) {
    	if (prima == 1 && i == 0 && dopo == 1) {
    		return 1;
    	}
    	if (prima == 1 && i == 1 && dopo == 1) {
    		return 0;
    	}
    	if ((prima == 1 && dopo == 0) || (prima == 0 && dopo == 1)) {
    		return i;
    	}
    	if (prima == 0 &&  dopo == 0) {
    		return 0;
    	}
    		return 0; //se anche ultimo metodo non va, magari valore inserito erroneamente, ritorna 0 comunque.
    }

    public int getTurn() {return this.turn;}

}