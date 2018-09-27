import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

public class GuiMenu extends Gui implements ActionListener{
	JFrame frame = new JFrame();
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	public GuiMenu(){
		super(playerDatabase, board, game);
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(6,6));
        
        JButton btnNewButton_1 = new JButton();
        btnNewButton_1.setAction(action);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Register();
        	}
        });
        frame.getContentPane().add(btnNewButton_1);
        
        
        JButton btnNewButton_2 = new JButton("Login");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Login();
        	}
        });
        frame.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton();
        btnNewButton_3.setAction(action_4);
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(game.checkPlayer()){
        			new ChooseMove();
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"You need 2 players logged in");
        		}
        	    
        	}
        });
        frame.getContentPane().add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("Logout");
        btnNewButton_4.setAction(action_3);
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Logout();
        	}
        });
        frame.getContentPane().add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Quit");
        btnNewButton_5.setAction(action_2);
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        		
        	}
        });
        frame.getContentPane().add(btnNewButton_5);
        
        
        frame.setVisible(true);
    }
	public void actionPerformed(ActionEvent e) {
		
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Register");	
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Login");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Quit");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Logout");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Play");
			
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
