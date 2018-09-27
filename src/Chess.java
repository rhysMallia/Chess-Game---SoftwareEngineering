import java.io.IOException;
import java.util.*;

public class Chess {
	private static PlayerDatabase playerDatabase = new PlayerDatabase();
	 static Piece white[] = new Piece[6];
	 static Piece black[] = new Piece[6];
	 static GameBoard board = new GameBoard();
	 static Gui gui;
    public Chess(){}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	    try{
	       
	    
	    Game game = new Game();
	    GuiMenu menu = new GuiMenu();
	    game.initialize();
	    gui = new Gui(playerDatabase, board, game);
	    //gui.setGUI();
//		Scanner selection = new Scanner(System.in);
//		String option = null;
//		boolean quit = false;
		
		try{
		    PlayerDatabase.loadPlayers();
		}catch(IOException e){
		    
		}
		
		System.out.println("Welcome to Not Quite Chess!\n");
//		do {
			System.out.printf("1. Register new player\n");
			System.out.println("2. Login");
			System.out.println("3. Play Game");
			System.out.println("4. Logout");
			System.out.printf("5. Quit\n");
			System.out.printf("Please select an option: ");
			
//			option = selection.nextLine();
//
//			if(option.equals("1")) {
//				if(!PlayerDatabase.registerPlayer(game.requestPlayerName(), game.requestPlayerPassword())) {
//					System.out.println("Player registration unsuccessful, Player name must be unique!");
//				} else {
//					System.out.println("Player registration successful!");
//				}
//				
//			} else if(option.equals("2")) {
//				
//				PlayerDatabase.playerLogin(game.requestPlayerName(), game.requestPlayerPassword());
//				
//			} else if(option.equals("3")) {
//				if(PlayerDatabase.getNumPlayers() == 2) {
//					game.playGame();
//				} else {
//					System.out.println("Not enough players!");
//				}
//			} else if(option.equals("5")) {
//			
//				quit = true;
//				System.out.println("Game has been quit");
//				
//			}else if(option.equals("4")){
//			   boolean  log = game.logout(game.requestPlayerName());
//			   if(log == true){
//			       System.out.println("Player logout successful!");
//			   }
//			   else{
//			       System.out.println("Player is logged out or does not exist!");
//			   }
//			}
//			else {
//				System.out.println("Invalid selection, try again!");
//			}
//			
//		} while(!quit);
//		
//		selection.close();
	}



	public void guiDie() {
		Play.killFrame();	
		
	}

}
