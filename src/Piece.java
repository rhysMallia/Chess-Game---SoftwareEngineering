
public class Piece {
	
	private String id;
    private int xLocation;
    private int yLocation;
    private boolean inPlay;
    private boolean colour;
    final int BOARD_HEIGHT = 8;
    final int BOARD_WIDTH = 8;

    public Piece(int xLocation, int yLocation, boolean colour)
    {
        this.id = "";
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.colour = colour;
        this.inPlay = true;
    }

    public void setKnight()
    {
	    if(colour) {
	    	this.id = "K";
	    } else {
	    	this.id = "k";
	    }
    }

	public void setRook()
	{
		if(colour) {
	    	this.id = "R";
	    } else {
	    	this.id = "r";
	    }
	}

	public void setBishop()
	{
		if(colour) {
	    	this.id = "B";
	    } else {
	    	this.id = "b";
	    }
	}

	public String getID()
	{
	    return this.id;
	}
	
	public void setWhite() {
	        this.colour = true;
	}
	
	public void setBlack() {
	        this.colour = false;
	}
	
	public boolean getColour() {
	        return colour;
	}
	
	public void setLocation(int x, int y)
	{
	    this.xLocation = x;
	    this.yLocation = y;
	}
	
	public int getXLocation()
	{
	    return this.xLocation;
	}
	
	public int getYLocation()
	{
	    return this.yLocation;
	}
	
	public boolean getStatus(){ return this.inPlay;}
	
	public void killPiece()
	{
	    this.inPlay = false;
	}
	
	public boolean validatePiece()
	{
	    return this.inPlay;
	}
	
	    
	public static boolean validateMove(Piece id, int x, int y) {
	    if (id.getID() == "K" || id.getID() == "k" ) {
	        if (x == ((id.getXLocation()) - 1) && y == ((id.getYLocation() - 2))) {
	            return true;
	        } else if (x == ((id.getXLocation()) + 1) && y == ((id.getYLocation() - 2))) {
	            return true;
	        } else if (x == ((id.getXLocation()) + 2) && y == ((id.getYLocation() - 1))) {
	            return true;
	        } else if (x == ((id.getXLocation()) + 2) && y == ((id.getYLocation() + 1))) {
	            return true;
	        } else if (x == ((id.getXLocation()) + 1) && y == ((id.getYLocation() + 2))) {
                return true;
	        } else if (x == ((id.getXLocation()) - 1) && y == ((id.getYLocation() + 2))) {
                return true;
	        } else if (x == ((id.getXLocation()) - 2 ) && y == ((id.getYLocation() +1))) {
                return true;
	        } else if (x == ((id.getXLocation()) - 2) && y == ((id.getYLocation() -1))) {
                return true;
	        } else
	            return false;
	    }
	
	    if (id.getID() == "R" || id.getID() == "r" )
	    {
	        if( x == (id.getXLocation() - 1) && y == (id.getYLocation()) || x == (id.getXLocation() - 2) && y == id.getYLocation() )
	            return true;
	        else if(x == (id.getXLocation() + 1) && y == id.getYLocation() || x == (id.getXLocation() + 2) &&  y == id.getYLocation())
	            return true;
	        else if(y == (id.getYLocation() - 1) && x == id.getXLocation() || y == (id.getYLocation() - 2) &&  x == id.getXLocation() )
	            return true;
	        else if(y == (id.getYLocation() + 1) && x == id.getXLocation() || y == (id.getYLocation() + 2) &&  x == id.getXLocation() )
	            return true;
	        else
	            return false;
	        
	    }
	
	    if (id.getID() == "B" || id.getID() == "b" )
	    {
	        if(x == (id.getXLocation() - 1) && y == (id.getYLocation()- 1))
	            return true;
	        else if(x == (id.getXLocation() - 2) && y == (id.getYLocation() - 2))
	            return true;
	        else if(x == (id.getXLocation() + 1) && y == (id.getYLocation() + 1))
	            return true;
	        else if(x == (id.getXLocation() + 2) && y == (id.getYLocation() + 2))
	            return true;
	        else if(x == (id.getXLocation() - 1) && y == (id.getYLocation() + 1))
	            return true;
	        else if(x == (id.getXLocation() - 2) && y == (id.getYLocation() + 2))
	            return true;
	        else if(x == (id.getXLocation() + 1) && y == (id.getYLocation() - 1))
	            return true;
	        else if(x == (id.getXLocation() + 2) && y == (id.getYLocation() - 2))
	            return true;
	        else
	            return false;
	    }
	    return false;
	}
	public CombinedPieces createCombo(Piece first, Piece second)
    {
        int xX = second.getXLocation();
        int yY = second.getYLocation();
        Boolean colour = second.getColour();
        
        CombinedPieces temp = new CombinedPieces(first, second, xX, yY, colour);
        return temp;
    }
	
	
}
