import static org.junit.Assert.*;

import org.junit.Test;

public class TheresaGameTestTest {

	@Test
	public void testPlayer() 
	{
		try
		{
			Player a=new Player("Bob","123");
			Player b=new Player("Lily","abc");
		}
		catch(Exception e)
		{
			System.out.printf("some errors");
		}
		
	}

	@Test
	public void testGetColour() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		b.setColour(false);
		a.setColour(true);
		assertEquals(true,a.getColour());
		assertEquals(false,b.getColour());
	}

	@Test
	public void testGetName() 
	{
		Player a=new Player("123","123");
		Player b=new Player("abc","abc");
		assertEquals("123",a.getName());
		assertEquals("abc",b.getName());
	}

	@Test
	public void testGetPassword() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		assertEquals("123",a.getPassword());
		assertEquals("abc",b.getPassword());
	}

	@Test
	public void testGetCurrentPiece() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		assertEquals(6,a.getCurrentPiece());
		assertEquals(6,b.getCurrentPiece());
	}

	@Test
	public void testGetScore() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		assertEquals(0,a.getScore());
		assertEquals(0,b.getScore());
	}

	@Test
	public void testGetWin() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		assertEquals(false,a.getWin());
		assertEquals(false,b.getWin());
	}

	@Test
	public void testGetWinner() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		assertFalse("Bob"==a.getWinner());
		assertFalse("Lily"==b.getWinner());
	}

	@Test
	public void testChooseFirst() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		b.setColour(false);
		a.setColour(true);
		assertEquals(a,Player.chooseFirst(a,b));
		//assertEquals(false,b.getWin());
	}

	@Test
	public void testSwap() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		b.setColour(false);
		a.setColour(true);
		Player c=Player.chooseFirst(a,b);
		assertEquals(b,Player.swap(c,a,b));
		
	}

	@Test
	public void testGetLoggedIn() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		assertTrue(false==a.getLoggedIn());
		assertTrue(false==b.getLoggedIn());

	}

	@Test
	public void testSetCurrentPiece() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		Piece white[] = new Piece[6];
		Piece black[] = new Piece[6];
		//Game.initPiece
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
		a.setCurrentPiece(white);
		b.setCurrentPiece(black);
		assertEquals(6,a.getCurrentPiece());
		assertEquals(6,b.getCurrentPiece());
	}

	@Test
	public void testSetScore() 
	{
		Player a=new Player("123","123");
		Player b=new Player("abc","abc");
		a.setScore(3);
		b.setScore(2);
		assertEquals(15,a.getScore());
		assertEquals(10,b.getScore());	
	}

	@Test
	public void testSetWin() 
	{
		Player a=new Player("123","123");
		Player b=new Player("abc","abc");
		a.setWin(true);
		b.setWin(false);
		assertEquals(true,a.getWin());
		assertEquals(false,b.getWin());
	}

	@Test
	public void testSetColour() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		b.setColour(false);
		a.setColour(true);
		assertEquals(true,a.getColour());
		assertEquals(false,b.getColour());
	}

	@Test
	public void testNewWin() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		a.newWin(5, 10);
		b.newWin(10, 5);
		assertEquals(true,b.getWin());
		assertEquals(false,a.getWin());
	}

	@Test
	public void testSetWinner() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		a.newWin(5, 10);
		b.newWin(10, 5);
		assertFalse(""==Player.setWinner(a.getWin(),b.getWin()));
	}

	@Test
	public void testSetLoggedIn() 
	{
		Player a=new Player("Bob","123");
		Player b=new Player("Lily","abc");
		a.setLoggedIn(true);
		b.setLoggedIn(false);
		assertTrue(true==a.getLoggedIn());
		assertTrue(false==b.getLoggedIn());
	}

}
