/***********************************************
*	Paolo Bondi - Corso TIC (UF6) - 17/06/21   *
*	Esercizio - Game of life                   *											
***********************************************/

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameOfLife1D {
  
  public static void main(String atgs[]) {
    
    Scanner input = new Scanner(System.in);
    System.out.println("Inserisci status iniziale del pianeta");
    String in = input.nextLine();
    Planet board = new Planet(in);
    System.out.println("**** INIZIO PROGRAMMA ****");
    board.printBoard();
    while(board.lifeOnPlanet()){
      board.oneTurn();
      board.printBoard();
    }
     
    System.out.println("***** FINE PROGRAMMA *****");
    System.out.println("Numero di cicli necessari all'estinzione della vita: " + (board.getTurn()+1));
    input.close();
  }

}
