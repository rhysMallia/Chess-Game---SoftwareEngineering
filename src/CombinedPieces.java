
public class CombinedPieces extends Piece {

    private Piece firstPiece;
    private Piece secondPiece;
    
    public CombinedPieces(Piece firstPiece, Piece secondPiece, int xLocation, int yLocation, boolean colour) {
        super(xLocation, yLocation, colour);
        this.firstPiece = firstPiece;
        this.secondPiece = secondPiece;
    }

    public void setFirstPiece(Piece firstPiece)
    {
        this.firstPiece = firstPiece;
    }
    
    public Piece getFirstPiece()
    {
        return firstPiece;
    }
    
    public void setSecondPiece(Piece secondPiece)
    {
        this.secondPiece = secondPiece;
    }
    
    public Piece getSecondPiece()
    {
        return secondPiece;
    }
    
    //If function returns true, valid. If false, invalid. if null, objects empty
    public Boolean validateMove(int x, int y)
    {
        String first = this.firstPiece.getID();
        String second = this.secondPiece.getID();
        int xL = this.firstPiece.getXLocation();
        int yL = this.secondPiece.getYLocation();
        
        first.toLowerCase();
        second.toLowerCase();
        
        if(this.firstPiece == null  && this.secondPiece == null)
            return null;
        
        //Knight + Rook - Has movement of both knight and rook combined independantly 
        if((first == "k" && second == "r") || (first == "r" && second == "k"))
        {
            if(y == yL - 2)
                return true;
            else if(x == xL + 1 && y == yL - 1)
                return true;
            else if(x == xL + 2)
                return true;
            else if(x == xL +1 && y == yL +1)
                return true;
            else if(y == yL +2)
                return true;
            else if(x == xL -1 && y == yL +1)
                return true;
            else if(x == xL -2)
                return true;
            else if(x == xL - 1 && y == yL - 1)
                return true;
            else
                return false;
        }
        //Knight + Bishop - can move 3 diagonal
        else if((first == "k" && second == "b") || second == "b" && first == "k")
        {
            if(y == yL - 3)
                return true;
            else if(x == xL+ 3)
                return true;
            else if(y == yL + 3)
                return true;
            else if(x == xL -3)
                return true;
            else
                return false;
        }
        //Rook + Bishop - has directional movement of rook and a bishop independantly
        else if(first == "r" && second == "b" || first == "b" && second == "r")
        {
            if(y == yL -2)
                return true;
            else if(x == xL +2 && y == yL -2)
                return true;
            else if(x == xL + 2)
                return true;
            else if(x == xL +2 && y == yL +2)
                return true;
            else if(y == yL + 2)
                return true;
            else if(x == xL -2 && y == yL +2)
                return true;
            else if(x == xL -2)
                return true;
            else if(x == xL -2 && y == yL -2)
                return true;
            else
                return false;
        }
        
        else
            return null; 
    }
}
