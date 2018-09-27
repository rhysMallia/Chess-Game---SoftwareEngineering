//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.junit.Test;
//
//public class AnthonyGameTest {
//
//	@Test
//	public void testGetNumPlayers() {
//		Game game = new Game();
//		game.registerPlayer("bob", "abc");
//		game.registerPlayer("steve", "123");
//		game.playerLogin("bob", "abc");
//		game.playerLogin("steve", "123");
//		assertEquals(2, game.getNumPlayers());
//	}
//
//	@Test
//	public void testRegisterPlayer() {
//		Game game = new Game();
//		assertTrue(game.registerPlayer("Bob", "1234"));
//	}
//	
//	@Test
//	public void testRegisterPlayerDuplicate() {
//		Game game = new Game();
//		game.registerPlayer("Bob", "abcd");
//		assertFalse(game.registerPlayer("Bob", "1234"));
//	}
//
//	@Test
//	public void testPlayerLogin() {
//		Game game = new Game();
//		game.registerPlayer("Bob", "abcd");
//		assertTrue(game.playerLogin("Bob", "abcd"));
//	}
//	
//	@Test
//	public void testPlayerLoginPlayerNotRegistered() {
//		Game game = new Game();
//		assertFalse(game.playerLogin("Bob", "abcd"));
//	}
//	
//	@Test
//	public void testPlayerLoginTwice() {
//		Game game = new Game();
//		game.registerPlayer("Bob", "abcd");
//		game.playerLogin("Bob", "abcd");
//		assertFalse(game.playerLogin("Bob", "abcd"));
//	}
//
//	@Test
//	public void testInitPieces() {
//		Game game = new Game();
//		boolean noNull = true;
//		Piece test[] = game.getWhitePieces();
//		game.initPieces();
//		for(int i = 0; i < 6; i++) {
//			if(test[i] == null) {
//				noNull = false;
//				break;
//			}
//		}
//		assertTrue(noNull);
//		
//	}
//
//	@Test
//	public void testPutPiecesOnBoard() {
//		Game game = new Game();
//		boolean noDot = true;
//		game.initPieces();
//		game.putPiecesOnBoard();
//		for(int i = 0; i < 6; i++) {
//			if(game.getBoard().getCell(i, 0).equals(".") || game.getBoard().getCell(i, 5).equals(".")) {
//				noDot = false;
//				break;
//			}
//		}
//		assertTrue(noDot);	
//	}
//
//	@Test
//	public void testLogout() {
//		Game game = new Game();
//		game.registerPlayer("Bob", "abcd");
//		game.playerLogin("Bob", "abcd");
//		assertTrue(game.logout("Bob"));
//	}
//
//}
