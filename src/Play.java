import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Play extends Gui implements ActionListener{
	 Player current;
	    private String[][] boardArray = new String[6][6];
	    static JFrame frame;
	    JPanel panel = new JPanel();
	    JButton[][] grid = new JButton[6][6];
	    ActionListener buttonListener;
	    boolean flag,update = true,validMove;
	    static Score score;
	    
	public Play(Score score){
		super(playerDatabase, board, game);
			this.score = score;
			frame = new JFrame();
        	frame.setSize(600,600);
	        frame.setLocationRelativeTo(null);
	        frame.setBackground(Color.LIGHT_GRAY);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLayout(new GridLayout(6,6));
	        setGUI();
	       
	        
	}
	 public void setGUI() {
		 
		 
        boardArray = board.getBoard();
        //buttonPress();
        
        String s;
        if(update){
	        for (int i=0; i<6; i++) {
	            for (int j=0; j<6; j++) {
	                
	                JButton btn = new JButton();
	               
	               btn.setMaximumSize(new Dimension(100, 100));
	                if(i%2 == 0){
	                    if(j%2 ==0){
	                        btn.setBackground(Color.WHITE);
	                    }
	                    else{
	                        btn.setBackground(Color.BLACK);
	                    }
	                }
	                else{
	                    if(j%2==0){
	                        btn.setBackground(Color.BLACK);
	                    }
	                    else{
	                        btn.setBackground(Color.WHITE);
	                    }
	                    
	                }
	            
	            s = boardArray[i][j];
	            grid[i][j] = btn;
//	            if(!s.equals(".")){
//	                grid[i][j].setText(s);
//	            }
	            if(s.equals("k")){
                    try {
                        Image img = ImageIO.read(getClass().getResource("/BlackKnightSMOL.png"));
                        grid[i][j].setIcon(new ImageIcon(img));
                      } catch (Exception ex) {
                        System.out.println(ex);
                      }
                }
                else if(s.equals("b")){
                    try {
                        Image img = ImageIO.read(getClass().getResource("/BlackBishopSMOL.png"));
                        grid[i][j].setIcon(new ImageIcon(img));
                      } catch (Exception ex) {
                        System.out.println(ex);
                      }
                }
                else if(s.equals("r")){
                    try {
                        Image img = ImageIO.read(getClass().getResource("/BlackRookSMOL.png"));
                        grid[i][j].setIcon(new ImageIcon(img));
                      } catch (Exception ex) {
                        System.out.println(ex);
                      }
                }
                else if(s.equals("K")){
                    try {
                        Image img = ImageIO.read(getClass().getResource("/WhiteKnightSMOL.png"));
                        grid[i][j].setIcon(new ImageIcon(img));
                      } catch (Exception ex) {
                        System.out.println(ex);
                      }
                }
                else if(s.equals("B")){
                    try {
                        Image img = ImageIO.read(getClass().getResource("/WhiteBishopSMOL.png"));
                        grid[i][j].setIcon(new ImageIcon(img));
                      } catch (Exception ex) {
                        System.out.println(ex);
                      }
                }
                else if(s.equals("R")){
                    try {
                        Image img = ImageIO.read(getClass().getResource("/WhiteRookSMOL.png"));
                        grid[i][j].setIcon(new ImageIcon(img));
                      } catch (Exception ex) {
                        System.out.println(ex);
                      }
                }

	            grid[i][j].setForeground(Color.RED);
	            grid[i][j].addActionListener(this);
	            frame.add(grid[i][j]);
	            
	        
	            }
	            update = false;
	        }
	        frame.setVisible(true);
        }
        else if(!update){
        	for (int i=0; i<6; i++) {
                for (int j=0; j<6; j++) {
                	grid[i][j].setIcon(null);
                	grid[i][j].setBorder(BorderFactory.createEmptyBorder());
                }
        	}
                
        	 for (int i=0; i<6; i++) {
                 for (int j=0; j<6; j++) {
		        	s = boardArray[i][j];

		        	if(s.equals("k")){
	                    try {
	                        Image img = ImageIO.read(getClass().getResource("/BlackKnightSMOL.png"));
	                        grid[i][j].setIcon(new ImageIcon(img));
	                      } catch (Exception ex) {
	                        System.out.println(ex);
	                      }
	                }
	                else if(s.equals("b")){
	                    try {
	                        Image img = ImageIO.read(getClass().getResource("/BlackBishopSMOL.png"));
	                        grid[i][j].setIcon(new ImageIcon(img));
	                      } catch (Exception ex) {
	                        System.out.println(ex);
	                      }
	                }
	                else if(s.equals("r")){
	                    try {
	                        Image img = ImageIO.read(getClass().getResource("/BlackRookSMOL.png"));
	                        grid[i][j].setIcon(new ImageIcon(img));
	                      } catch (Exception ex) {
	                        System.out.println(ex);
	                      }
	                }
	                else if(s.equals("K")){
	                    try {
	                        Image img = ImageIO.read(getClass().getResource("/WhiteKnightSMOL.png"));
	                        grid[i][j].setIcon(new ImageIcon(img));
	                      } catch (Exception ex) {
	                        System.out.println(ex);
	                      }
	                }
	                else if(s.equals("B")){
	                    try {
	                        Image img = ImageIO.read(getClass().getResource("/WhiteBishopSMOL.png"));
	                        grid[i][j].setIcon(new ImageIcon(img));
	                      } catch (Exception ex) {
	                        System.out.println(ex);
	                      }
	                }
	                else if(s.equals("R")){
	                    try {
	                        Image img = ImageIO.read(getClass().getResource("/WhiteRookSMOL.png"));
	                        grid[i][j].setIcon(new ImageIcon(img));
	                      } catch (Exception ex) {
	                        System.out.println(ex);
	                      }
	                }
                 }
            }
        }
        
        flag = false;
    }
	 
	 public void helpMove(int i,int j){
		 String s = game.getTemp();
		 if(s.toLowerCase().equals("r")){
			 if(i-2>=0)
				 grid[i-2][j].setBorder(BorderFactory.createLineBorder(Color.RED));
			 if(i+2<=5)
				 grid[i+2][j].setBorder(BorderFactory.createLineBorder(Color.RED));
			 if(i-1>=0)
				 grid[i-1][j].setBorder(BorderFactory.createLineBorder(Color.RED));
			 if(i+1<=5)
				 grid[i+1][j].setBorder(BorderFactory.createLineBorder(Color.RED));
			 if(j-2>=0)
				 grid[i][j-2].setBorder(BorderFactory.createLineBorder(Color.RED));
			 if(j+2<=5)
				 grid[i][j+2].setBorder(BorderFactory.createLineBorder(Color.RED));
			 if(j-1>=0)
				 grid[i][j-1].setBorder(BorderFactory.createLineBorder(Color.RED));
			 if(j+1<=5)
				 grid[i][j+1].setBorder(BorderFactory.createLineBorder(Color.RED)); 
         }
         else if(s.toLowerCase().equals("b")){
        	 if(i-2>=0 && j-2>=0)
            	 grid[i-2][j-2].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i-1>=0 && j-1>=0)
            	 grid[i-1][j-1].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+2<=5 && j+2<=5)
            	 grid[i+2][j+2].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+1<=5 && j+1<=5)
            	 grid[i+1][j+1].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i-2>=0 && j+2<=5)
            	 grid[i-2][j+2].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i-1>=0 && j+1<=5)
            	 grid[i-1][j+1].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+2<=5 && j-2>=0)
            	 grid[i+2][j-2].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+1<=5 && j-1>=0)
            	 grid[i+1][j-1].setBorder(BorderFactory.createLineBorder(Color.RED));
         }
         else if(s.toLowerCase().equals("k")){
        	 if(i-2>=0 && j-1>=0)
            	 grid[i-2][j-1].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i-2>=0 && j+1<=5)
            	 grid[i-2][j+1].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+2<=5 && j-1>=0)
            	 grid[i+2][j-1].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+2<=5 && j+1<=5)
            	 grid[i+2][j+1].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 
        	 if(i-1>=0 && j+2<=5)
            	 grid[i-1][j+2].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+1<=5 && j+2<=5)
            	 grid[i+1][j+2].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i-1>=0 && j-2>=0)
            	 grid[i-1][j-2].setBorder(BorderFactory.createLineBorder(Color.RED));
        	 if(i+1<=5 && j-2>=0)
            	 grid[i+1][j-2].setBorder(BorderFactory.createLineBorder(Color.RED));
            
         }
	 }
	  public void actionPerformed(ActionEvent evt) {
	        JButton selectedBtn = (JButton) evt.getSource();
	        for (int i= 0; i < 6; i++) {
	           for (int j = 0; j < 6; j++) {
	              if (grid[i][j] == selectedBtn) {
	                 System.out.printf("Selected row and column: %d %d%n", i, j);
//	                 current = game.getCurrent();
	                 
	                 if(!flag){
	                	 
	                	 if(!game.checkPiece( i, j,game.getCurrent())){
	                		 flag = false;
	                		 
	                	 }
	                	 else{
	                		 helpMove(i,j);
	                		 flag = true;
	                	 }
	                 }
	                 else{
	                	 if(!game.movePiece(i,j)){
	                		 flag = false;
	                		 return;
	                	 }
	                	 else{
	                	 //game.movePiece(i,j);
	                	 flag = false;
	                	 setGUI();
	                	
	                	 score.trackerUpdate();
	                	 board.printBoard();
	                	 }
	                 }
	             
	              }
	           }
	        }
	     }

		public static void killFrame() {
			String s = game.gwinner();
			JOptionPane.showMessageDialog(null,s +"");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			score.killFrame();
			
		}


	}
