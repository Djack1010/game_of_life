import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameOfLife1D {
  
  public static void main(String atgs[]) {
    
    Scanner input = new Scanner(System.in);
    System.out.println("Inserisci status iniziale del pianeta");
    String in = input.nextLine();
    Planet board = new Planet(in);
    board.printBoard();
    while(board.lifeOnPlanet()){
      board.oneTurn();
      board.printBoard();
      try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
     
  }

}
