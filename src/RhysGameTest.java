import static org.junit.Assert.*;

import org.junit.Test;

public class RhysGameTest {

	@Test
    public void testObject() throws Exception{
        Piece test = new Piece(4,5, true);
        test.setBishop();
        assertEquals("B", test.getID());
        assertEquals(4, test.getXLocation());
        assertEquals(5, test.getYLocation());
        assertTrue(test.validatePiece());

    }

    @Test
    public void updateObject(){
        Piece test = new Piece(4,5, false);

        test.setBishop();
        test.setLocation(5,4);
        test.killPiece();

        test.setKnight();

        assertEquals("k", test.getID());
        assertEquals(5, test.getXLocation());
        assertEquals(4, test.getYLocation());
        assertFalse(test.validatePiece());

    }

    @Test
    public void setAndGetLocation() throws Exception{
        //testing a set location via the getters!
        Piece test = new Piece(4,5,true);
        test.setLocation(5,6);

        assertEquals(5,test.getXLocation());
        assertEquals(6, test.getYLocation());
    }

    @Test
    public void setAndCheckColour() throws Exception{
        Piece test = new Piece(4,5,true);
        test.setKnight();
        test.setBlack();

        assertFalse(test.getColour());
        assertEquals("K", test.getID());
    }

    @Test
    public void checkPieceAndKill() throws Exception{
        Piece test = new Piece(4,5,true);
        assertTrue(test.getStatus());

        test.killPiece();

        assertFalse(test.getStatus());
    }

    @Test
    public void testBishopMove() throws Exception {
        Piece test = new Piece( 4, 5, true);
        test.setBishop();
        assertTrue(test.validateMove(test, 6, 3));
        assertFalse(test.validateMove(test, 4,4));
    }

    @Test
    public void testKnightMove() throws Exception{
        Piece test = new Piece( 4, 5, true);
        test.setKnight();
        assertTrue(test.validateMove(test, 3, 6));
        assertFalse(test.validateMove(test, 4,4));
    }

    @Test
    public void testRookMove() throws Exception{
        Piece test = new Piece( 4, 5, true);
        test.setRook();
        assertTrue(test.validateMove(test, 4, 7));
        assertFalse(test.validateMove(test, 4,8));
    }



}
