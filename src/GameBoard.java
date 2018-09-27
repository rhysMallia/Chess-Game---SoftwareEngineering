
public class GameBoard {

private String[][] boardArray = new String[6][6];
	

	public GameBoard() {
		
	}
	
	public void setGameBoard(){
	
        for(int i = 0;i<6;i++){
            for(int j = 0;j<6;j++){
                boardArray[i][j] = ".";
            }
        }
    
	}
	
	

	public void printBoard() {
		System.out.println("   | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("============================");
		System.out.printf( " 1 | %s | %s | %s | %s | %s | %s |\n", 
		boardArray[0][0], boardArray[0][1], boardArray[0][2], boardArray[0][3], boardArray[0][4], boardArray[0][5]);
		System.out.println("============================");
		System.out.printf( " 2 | %s | %s | %s | %s | %s | %s |\n", 
		boardArray[1][0], boardArray[1][1], boardArray[1][2], boardArray[1][3], boardArray[1][4], boardArray[1][5]);
		System.out.println("============================");
		System.out.printf( " 3 | %s | %s | %s | %s | %s | %s |\n", 
		boardArray[2][0], boardArray[2][1], boardArray[2][2], boardArray[2][3], boardArray[2][4], boardArray[2][5]);
		System.out.println("============================");
		System.out.printf( " 4 | %s | %s | %s | %s | %s | %s |\n", 
		boardArray[3][0], boardArray[3][1], boardArray[3][2], boardArray[3][3], boardArray[3][4], boardArray[3][5]);
		System.out.println("============================");
		System.out.printf( " 5 | %s | %s | %s | %s | %s | %s |\n", 
		boardArray[4][0], boardArray[4][1], boardArray[4][2], boardArray[4][3], boardArray[4][4], boardArray[4][5]);
		System.out.println("============================");
		System.out.printf( " 6 | %s | %s | %s | %s | %s | %s |\n", 
		boardArray[5][0], boardArray[5][1], boardArray[5][2], boardArray[5][3], boardArray[5][4], boardArray[5][5]);
		System.out.println("============================");
				
	}
	
	public String getCell(int x, int y){
	    return boardArray[y][x];
	}
	
	public void setCell (int x, int y, String s) {
	    boardArray[y][x] = s;	
	}
	
	public void initCell (int x, int y, String s) {
            boardArray[y][x] = s;
            
    }

	

	
	public String[][] getBoard(){
	    return boardArray;
	}
}
