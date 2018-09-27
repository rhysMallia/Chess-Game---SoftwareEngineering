import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Score extends Gui implements ActionListener{
    JFrame frame = new JFrame();
    JLabel movecnt = new JLabel("...");
    JLabel turnName = new JLabel("awaiting current");
    JLabel scorecnt = new JLabel("No score yet");
    
    public Score(){
        super(playerDatabase, board, game);
	        
        	
            frame.setBackground(Color.LIGHT_GRAY);
            frame.setBounds(350,120,316,269);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            JPanel panel = new JPanel();
            frame.getContentPane().add(panel);
            panel.setLayout(null);
            
            
            turnName.setBounds(30, 80, 187, 14);
            panel.add(turnName);
            
            
            movecnt.setBounds(30, 115, 179, 14);
            panel.add(movecnt);
 
            JLabel lblNewLabel = new JLabel("Game Tracker");
            lblNewLabel.setBounds(85, 38, 137, 31);
            panel.add(lblNewLabel);
            
          
            scorecnt.setBounds(30, 154, 249, 38);
            panel.add(scorecnt);
            
            frame.setVisible(true);
            trackerUpdate();
            
    }
    
    public void trackerUpdate(){
    	turnName.setText("It is " + game.getCurrent().getName() + "'s turn!");
    	movecnt.setText("It is turn " +game.getMoveCount() + " as " + game.getCurrent().getColour());
    	scorecnt.setText(game.getP1().getName() + "'s score is " + game.getP1().getScore() 
    			+ " and " +game.getP2().getName() + "'s score is " + game.getP2().getScore());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

	public void killFrame() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		
	}
}