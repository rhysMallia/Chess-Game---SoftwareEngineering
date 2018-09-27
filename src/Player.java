
public class Player {

	private String name;
	private String password;
	private int currentPiece;
	private int score;
	private boolean win;
	private String winner;
	private boolean loggedIn;
	private boolean colour;
	
	public Player(String name,String password)
	{
		this.name=name;
		this.password=password;
		score=0;
		currentPiece=6;
		win=false;
		loggedIn = false;
	}

	public boolean getColour(){
	    return colour;
	}
	
	public String getName() 
	{
		return name;
	}

	public String getPassword() 
	{
		return password;
	}

	public int getCurrentPiece() 
	{
		return currentPiece;
	}
	
	public int getScore() 
	{
		return score;
	}
	
	public boolean getWin() 
	{
		return win;
	}

	public String getWinner()
	{
		return winner;
	}
	
	public static Player chooseFirst(Player player1, Player player2) {
        if(player1.getColour() == true){
            return player1;
        }
        else{
            return player2;
        }
        
    }
	
	public static Player swap(Player current, Player player1, Player player2) {
        //player swap code
        Player temp = null;
        if(current.getColour() == true){
            if(player1.getColour() == true){
                player1 = current;
                current = player2;
                return current;
            }
            else if(player2.getColour() == true){
                player2 = current;
                current = player1;
                return current;
            }
        }
        else if(current.getColour() == false){
            if(player1.getColour() == false){
                player1 = current;
                current = player2;
                return current;
            }
            else if(player2.getColour() == false){
                player2 = current;
                current = player1;
                return current;
            }
        }
        return temp;
        
    }
	
	public boolean getLoggedIn() {return loggedIn;}
	
	public void setCurrentPiece(Piece name[]) 
	{
		
		for(int j=0;j<6;j++)
		{
			if(((Piece)name[j]).getStatus()==false)
			{
				this.currentPiece--;
			}
			else
			{
				this.currentPiece=this.currentPiece;
			}			
		}
		
	}

	public void setScore(int currentPieceOther) 
	{
		int score1=currentPieceOther*5;
		this.score = score1;
	}

	
	public void setWin(boolean win) 
	{
		
		this.win = win;
	}
	
	public void setColour(boolean colour){
	    this.colour = colour;
	}
	
	public boolean newWin(int score1,int score2) 
	{
		if(score1>score2)
		{
			win=true;
		}
		else if(score1<score2)
		{
			win=false;
		}
		else
		{
			win=false;
		}
		return win;
	}
	
	public static String setWinner(boolean winW,boolean winB)
	{
		if(winW==true)
		{
			return "The White player is winner!";
		}
		else if(winB==true)
		{
			return "The Black player is winner!";
		}
		else
		{
			return "This game ended in a draw.";
		}
	}
	
	public void setLoggedIn(boolean b) {loggedIn = b;}
}
