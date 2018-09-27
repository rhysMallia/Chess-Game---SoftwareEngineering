import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Gui  {
    static PlayerDatabase playerDatabase;
    
    static GameBoard board;
    static Game game;
    
    public Gui(PlayerDatabase playerDatabase, GameBoard board, Game game){
    	this.playerDatabase = playerDatabase;
        this.board = board;
        this.game = game;
    }


}