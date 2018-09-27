//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class LiamGameTest {
//
//	    
//	    Piece white[] = new Piece[6];
//	    Piece black[] = new Piece[6];
//	    private GameBoard board = new GameBoard();
//	    //Player player = new Player();
//	    Game game = new Game();
//	    
//	    @Test
//	    public void boardTest() {
//	        board.setGameBoard();
//	            
//	        assert(board.getCell(0, 0) == ".");
//	        assert(board.getCell(4, 3) == ".");
//	        assert(board.getCell(5, 5) == ".");
//	    }
//	    
//	    @Test
//	    public void initPiecesTest(){
//	        board.setGameBoard();
//	        game.initPieces();
//	        
//	        
//	    }
//	    @Test
//	    public void boardTest2(){
//	        
//	        game.initialize();
//	        game.board.printBoard();
//	        assert(game.board.getCell(0,0) == "r");
//	        assert(game.board.getCell(1,0) == "b");
//	        assert(game.board.getCell(2,0) == "k");
//	        assert(game.board.getCell(3,0) == "k");
//	        assert(game.board.getCell(4,0) == "b");
//	        assert(game.board.getCell(5,0) == "r");
//	        
//	        assert(game.board.getCell(0,5) == "R");
//	        assert(game.board.getCell(1,5) == "B");
//	        assert(game.board.getCell(2,5) == "K");
//	        assert(game.board.getCell(3,5) == "K");
//	        assert(game.board.getCell(4,5) == "B");
//	        assert(game.board.getCell(5,5) == "R");
//	        
//	    }
//	    @Test
//	    public void makeMoveTest(){
//	        System.out.println("test of move");
//	        Player player = new Player("hm", "hm");
//	        Player player1 = new Player("a","a");
//	        player.setColour(true);
//	        game.initialize();
//	        game.makeMove(player);
//	        assertEquals(game.board.getCell(5, 4), "R");
//	        game.makeMove(player1);
//	        System.out.printf("\n");
//	        assertEquals(game.board.getCell(2,1), "k");
//	        
//	    }
//	    
//	    
//	    
//	    @Test
//	    public void makeMoveTest2(){
//	        System.out.println("test of death");
//	        Player player = new Player("hm", "hm");
//	        Player player1 = new Player("a","a");
//	        player.setColour(true);
//	        game.initialize();
//	        game.makeMove(player);
//	        assert(game.board.getCell(5, 3) == "R");
//	        game.makeMove(player1);
//	        System.out.printf("\n");
//	        assert(game.board.getCell(5,2) == "r");
//	        game.makeMove(player);
//	        System.out.printf("\n");
//	        assert(game.board.getCell(5, 2) == "R");
//	        assert(game.black[5].getStatus() == false);
//	    }
//	    
//	    @Test
//	    public void falseMove(){
//	        System.out.println("test of false move");
//	        Player player = new Player("hm", "hm");
//	        Player player1 = new Player("a","a");
//	        player.setColour(true);
//	        game.initialize();
//	        assertFalse(game.makeMove(player));
//	        
//	    }
//	
//
//
//
//
//}
