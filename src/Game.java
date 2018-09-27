import java.util.*;

public class Game extends Chess{
    public Game(){
        super();
    }
    
	Scanner input = new Scanner(System.in);
	
	Player player1 = null;
	Player player2 = null;
	Player current = null;
	Piece tempPiece = null;
	int player1Moves = 0;
	int player2Moves = 0;
	int playerMovesAvg = 0;
	int moveCount = 0;
	boolean gameOver = false;
	
	
	public Player getCurrent(){return current;}
	
	public String getTemp(){
		return tempPiece.getID();
	}
	
	public int getMoveCount(){
		return moveCount;
	}
	
	public Player getP1(){
		return player1;
	}
	public Player getP2(){
		return player2;
	}
	
	public void playGame() {

		initialize();
		setPlayerColour();

		current = Player.chooseFirst(player1,player2);


	}
	public	boolean checkPlayer(){
		int j = 0;
		boolean check = true;
		for(int i = 1;i<PlayerDatabase.getPlayers().size()+1;i++){
			if(PlayerDatabase.getPlayers().get(i- 1).getLoggedIn() && check){
				player1 = PlayerDatabase.getPlayers().get(i - 1);
				check = false;
				j= i;
			}
			
			if(PlayerDatabase.getPlayers().get(i - 1).getLoggedIn()&& i != j){
				player2 = PlayerDatabase.getPlayers().get(i - 1);
				return true;
			}
			
		}
		return false;
	}
	

	
	public void averageMove(int player1Moves,int player2Moves){
	    playerMovesAvg = (player1Moves + player2Moves) / 2;
	    playerMovesAvg = playerMovesAvg *2;
        System.out.println(playerMovesAvg);
	}
	
	public void initialize() {
		board.setGameBoard();
		initPieces();
		putPiecesOnBoard();		
	}

	public String requestPlayerName() {
		String playerName = "";
		System.out.println("Enter Name: ");
		playerName = input.nextLine();
		return playerName;
	}
	
	public String requestPlayerPassword() {
		String playerPassword = "";
		System.out.println("Enter password: ");
		playerPassword = input.nextLine();		
		return playerPassword;
	}
	
	public void setPlayerColour() {
        Random rand = new Random();
        boolean check = true;
        boolean colour = rand.nextBoolean();
        for(int i = 0;i< PlayerDatabase.getPlayers().size();i++){
            if(PlayerDatabase.getPlayers().get(i).getLoggedIn() == true && check) {   
            	PlayerDatabase.getPlayers().get(i).setColour(colour);
                check = false;
                System.out.printf("%s %b\n",PlayerDatabase.getPlayers().get(i).getName(),PlayerDatabase.getPlayers().get(i).getColour());
            }
            else if(PlayerDatabase.getPlayers().get(i).getLoggedIn() == true && !check){
            	PlayerDatabase.getPlayers().get(i).setColour(!colour);
                System.out.printf("%s %b\n",PlayerDatabase.getPlayers().get(i).getName(),PlayerDatabase.getPlayers().get(i).getColour());
            }
        }
    }


	public void initPieces() {
		
		for(int i = 0; i < 6; i++) {
			if(i == 0 || i == 5) {
				(white[i]) = new Piece(i, 5, true);
				(white[i]).setRook();
				(white[i]).setLocation(i, 5);
			} else if(i == 1 || i == 4) {
				(white[i]) = new Piece(i, 5, true);
				(white[i]).setBishop();
				(white[i]).setLocation(i, 5);
			} else if(i == 2 || i == 3) {
				(white[i]) = new Piece(i, 5, true);
				(white[i]).setKnight();
				(white[i]).setLocation(i, 5);
			}
		}
		
		for(int i = 0; i < 6; i++) {
			if(i == 0 || i == 5) {
				(black[i]) = new Piece(i, 0, false);
				(black[i]).setRook();
				(black[i]).setLocation(i, 0);
			} else if(i == 1 || i == 4) {
				(black[i]) = new Piece(i, 0, false);
				(black[i]).setBishop();
				(black[i]).setLocation(i, 0);
			} else if(i == 2 || i == 3) {
				(black[i]) = new Piece(i, 0, false);
				(black[i]).setKnight();
				(black[i]).setLocation(i, 0);
			}
		}
	}
	
	public void putPiecesOnBoard() {
		for(int i = 0; i < 6; i++) {
				board.initCell(i, 0, black[i].getID());
				board.initCell(i, 5, white[i].getID());
		}
	}
	

	public boolean movePiece(double y2,double x2){
//		int origX;
//		int origY;
		double origX;
		double origY;
		Piece toDie = null;
		for (int i = 0;i<6;i++){
		    if (board.getCell((int)x2,(int) y2) == black[i].getID() && black[i].getStatus()){
		        toDie = black[i];
		    }
		    else if (board.getCell((int)x2,(int) y2) == white[i].getID()&& black[i].getStatus()){
                toDie = white[i];
            } 
		}
		
		
		for(int i= 0;i<6;i++){
			//check if landing on white while black
    		if((board.getCell((int)x2,(int) y2)).equals(white[i].getID()) && !(current.getColour())){
    		    toDie.killPiece();
    		    
    		    	origX = tempPiece.getXLocation();
    		    	origY = tempPiece.getYLocation();
    		    	double halfx = (x2 + origX)/2;
    		    	double halfy = (y2 +origY)/2;
    		    
    		    	if(halfx%1.0 == 0.5 || halfy%1.0 == 0.5 ||  tempPiece.getID().toLowerCase() == "k"){
    		    		
    		    	}
    		    	else if(board.getCell((int)((x2 + origX)/2), (int)((y2 +origY)/2)) != "."){
    		    		if(tempPiece != null){
    		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
    		    		}
    		    		System.out.println("Invalid move. Try again!");
    		    		return false;
    		    	}
    		    	
    		    	if(Piece.validateMove(tempPiece, (int)x2,(int) y2)){
    		    		toDie.killPiece();
    		    		board.setCell((int)x2,(int) y2,tempPiece.getID());
    		    		tempPiece.setLocation((int)x2,(int) y2);
    		    		endTurn();
	                    return true;
    		    	}
    		    	else{
    		    		if(tempPiece != null){
    		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
    		    		}
    		    		System.out.println("Invalid move. Try again!");
    		    		return false;
    		    	}

                  
    		}
    		//check if youre moving onto white while white
    		else if(board.getCell((int)x2,(int) y2).equals(white[i].getID()) && current.getColour()){
    			origX = tempPiece.getXLocation();
		    	origY = tempPiece.getYLocation();
		    	double halfx = (x2 + origX)/2;
		    	double halfy = (y2 +origY)/2;
		    	
		    	if(halfx%1.0 == 0.5 || halfy%1.0 == 0.5 ||  tempPiece.getID().toLowerCase() == "k"){}
		    	else if(board.getCell((int)((x2 + origX)/2), (int)((y2 +origY)/2)) != "."){
		    		if(tempPiece != null){
		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
		    		}
		    		System.out.println("Invalid move. Try again!");
		    		return false;
		    	}
    			//combine?
    			System.out.printf("%s\n",board.getCell((int)x2,(int) y2));
    			System.out.printf("One of your pieces is here\n");
    			return false;
    		}
    		//check if black when you are white
    		else if ((board.getCell((int)x2,(int) y2)).equals(black[i].getID()) && current.getColour()) {
    		    toDie.killPiece();
    		    origX = tempPiece.getXLocation();
		    	origY = tempPiece.getYLocation();
		    	double halfx = (x2 + origX)/2;
		    	double halfy = (y2 +origY)/2;
		    	
		    	if(halfx%1.0 == 0.5 || halfy%1.0 == 0.5 ||  tempPiece.getID().toLowerCase() == "k"){
		    		
		    	}
		    	else if(board.getCell((int)((x2 + origX)/2)  , (int)((y2 +origY)/2)) != "."){
		    		if(tempPiece != null){
		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
		    		}
		    		System.out.println("Invalid move. Try again!");
		    		return false;
		    	}
    		    	
    		    	if(Piece.validateMove(tempPiece, (int)x2,(int) y2)){
    		    		toDie.killPiece();
	                    board.setCell((int)x2,(int) y2,tempPiece.getID());
	                    tempPiece.setLocation((int)x2,(int) y2);
	                    endTurn();
	                    return true;
    		    	}
    		    	else{
    		    		if(tempPiece != null){
    		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
    		    		}    		    		
    		    		System.out.println("Invalid move. Try again!");
    		    		return false;
    		    	}
                  
    		    
    		}
    		//check if same piece if black
    		else if(board.getCell((int)x2,(int) y2).equals(black[i].getID()) && !(current.getColour())){
    			origX = tempPiece.getXLocation();
		    	origY = tempPiece.getYLocation();
		    	double halfx = (x2 + origX)/2;
		    	double halfy = (y2 +origY)/2;
		    	
		    	if(halfx%1.0 == 0.5 || halfy%1.0 == 0.5 ||  tempPiece.getID().toLowerCase() == "k"){
		    		
		    	}
		    	else if(board.getCell((int)((x2 + origX)/2), (int)((y2 +origY)/2)) != "."){
		    		if(tempPiece != null){
		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
		    		}
		    		System.out.println("Invalid move. Try again!");
		    		return false;
		    	}
    			//combine?
    			System.out.printf("One of your pieces is here\n");
    			return false;
    		}
    		//check if empty spot and white
    		
    		else if (board.getCell((int)x2,(int) y2).equals(".") && tempPiece.getColour()){
    			origX = tempPiece.getXLocation();
		    	origY = tempPiece.getYLocation();
		    	double halfx = (x2 + origX)/2;
		    	double halfy = (y2 +origY)/2;
		    	if(halfx%1.0 == 0.5 || halfy%1.0 == 0.5 ||  tempPiece.getID().toLowerCase() == "k"){
		    		
		    	}
		    	else if(board.getCell((int)((x2 + origX)/2), (int)((y2 +origY)/2)) != "."){
		    		if(tempPiece != null){
		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
		    		}
		    		System.out.println("Invalid move. Try again!");
		    		return false;
		    	}
    			
    		    	if(Piece.validateMove(tempPiece, (int)x2,(int) y2)){
	                    board.setCell((int)x2,(int) y2,tempPiece.getID());
	                    tempPiece.setLocation((int)x2,(int) y2);
	                    endTurn();	                    
	                    return true;
    		    	}
    		    	else{
    		    		if(tempPiece != null){
    		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
    		    		}
    		    		System.out.println("Invalid move. Try again!");
    		    		return false;
    		    	}
                 
    		}
    		//check if empty spot
    		
    		else if (board.getCell((int)x2,(int) y2).equals(".") && !(tempPiece.getColour())){
    			origX = tempPiece.getXLocation();
		    	origY = tempPiece.getYLocation();
		    	double halfx = (x2 + origX)/2;
		    	double halfy = (y2 +origY)/2;
		    	
		    	if(halfx%1 == 0.5 || halfy%1 == 0.5 ||  tempPiece.getID().toLowerCase() == "k"){
		    		
		    	}
		    	else if(board.getCell((int)((x2 + origX)/2), (int)((y2 +origY)/2)) != "."){
		    		if(tempPiece != null){
		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
		    		}
		    		System.out.println("Invalid move. Try again!");
		    		return false;
		    	}
    			
    		    	if(Piece.validateMove(tempPiece, (int)x2,(int)y2)){
	                    board.setCell((int)x2,(int)y2,tempPiece.getID());
	                    tempPiece.setLocation((int)x2,(int)y2);
	                    endTurn();
	                    return true;
    		    	}
    		    	else{
    		    		if(tempPiece != null){
    		    			board.setCell(tempPiece.getXLocation(), tempPiece.getYLocation(),tempPiece.getID());
    		    		}
    		    		System.out.println("Invalid move. Try again!");
    		    		return false;
    		    	}

                 
    		}
		}
		return true;
	}
	public void endTurn(){
		
        moveCount++;
        checkScore();
        current = Player.swap(current,player1,player2);
        System.out.printf("Player 1 (%s) %d\n",player1.getColour(),	player1.getScore() );
        System.out.printf("Player 2 (%s) %d\n",player2.getColour(), player2.getScore());
		if(moveCount == playerMovesAvg || noSurvivors(white) || noSurvivors(black)) {
			gameOver = true;
			gwinner();
			moveCount = 0;
			
			super.guiDie();
		}
		if(gameOver){
			
		}
	}
	public boolean checkPiece(int y,int x, Player current){
		
		for(int i= 0;i<6;i++){
            if(white[i].getXLocation() == x && white[i].getYLocation() == y && current.getColour() ) {
                
                    tempPiece = white[i];
                    board.setCell(x, y, ".");
                
                 break;
            }
            else if(black[i].getXLocation() == x && black[i].getYLocation() == y && !(current.getColour())){
                
                    tempPiece = black[i];
                    board.setCell(x, y, ".");
                
                 break;
            }
            else if(i == 5) {
            	System.out.printf("This is not your piece...\n");
            	tempPiece = null;
            	return false;
            }
            
        }
		System.out.printf("%s",board.getCell(x, y));
		

		return true;
	}
	
	public String gwinner(){

		if(player1.getWin()){
			return player1.getName() + " has won!";
		}
		else{
			return player2.getName() + " has won!";
		}
	}
	public boolean noSurvivors(Piece[] p) {
		boolean noSurvivors = true;
		for(int i = 0; i < p.length; i++) {
			if(p[i].getStatus()) {
				noSurvivors = false;
				break;
			}
		}
		return noSurvivors;
	}
	
	public void checkScore(){
		int whiteCount = 0;
	    int blackCount = 0;
	    for(int i = 0;i<6;i++){
            if(white[i].getStatus() == false){
                whiteCount++;
            }
            if(black[i].getStatus() == false){
                blackCount++;
            }
        }
	    
	    
        if(current.getColour())
        {
        	if(current==player1)
        	{
		  		current.setScore(blackCount);
		  		
		  		player2.setScore(whiteCount);
		  		
        	}
        	else
        	{
        		current.setScore(blackCount);
		  		player1.setScore(whiteCount);
        	}
        }
        else
        {
        	if(current==player1)
        	{
        		player2.setScore(blackCount);
		  		current.setScore(whiteCount);
        	}
        	else
        	{
        		player1.setScore(blackCount);
		  		current.setScore(whiteCount);
        	}
        		
        }

	    
        if(player1.getScore()>player2.getScore())
        {
        	player1.setWin(true);
        	player2.setWin(false);
        	
        	
        }
        else if(player2.getScore()>player1.getScore())
        {
        	player2.setWin(true);
        	player1.setWin(false);
        	
        }
        
        
	}

    public boolean logout(String playerName) {
    	boolean out = false;
        for(int i = 0; i<PlayerDatabase.getPlayers().size();i++){
            if(playerName.equals(PlayerDatabase.getPlayers().get(i).getName()) && 
            		PlayerDatabase.getPlayers().get(i).getLoggedIn() == true){
            	PlayerDatabase.getPlayers().get(i).setLoggedIn(false);
            	PlayerDatabase.decrementNumPlayers();
                System.out.printf("%s has logged out\n", playerName);
                out = true;
            } else {
            	System.out.printf("%s was never logged in\n", playerName);
            }
        }
        return out;
        
    }

    
	
}
