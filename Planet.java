import java.util.Arrays;
import java.lang.Math;

public class Planet {

    Integer[] board;
    int turn;

    public Planet(String input){
        // TODO: implement
    }

    public void printBoard(){
        // TODO: implement
    }

    // restituisce true se c'è almeno un 1 nel board, altrimenti false
    public boolean lifeOnPlanet(){
        // TODO: implement
    }
    
    // basandosi sul board attuale, lo aggiorna per il successivo turno sequendo le seguenti regole:
    // PER ogni elemento i del board SE:
    //  vicini sono entrambi 1 ed i è 0 -> i diventa 1 (nuova nascita)
    //  vicini sono entrambi 1 ed i è 1 -> i diventa 0 (morte per sovrappopolazione)
    //  vicini sono uno 0 e l'altro 1	 -> i non cambia (sopravvivenza)
    //  vicini sono entrambi 0		 -> i diventa 0 nel 90% dei casi (morte per sottopopolazione) oppure 1 nel 10% (nascita spontanea)
    // Il board va considerato CIRCOLARE (es: il vicino sx di i=0 è i=board.length-1), e il metodo deve anche aggiornare il count del turno
    public void oneTurn(){
        // TODO: implement
    }

    public int getTurn() {return this.turn;}

}
