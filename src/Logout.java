import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractAction;




public class Logout extends Gui implements ActionListener{
	JFrame frame = new JFrame();
	


	private JTextField user;
	private JTextField	pass;
	private final Action action = new SwingAction();
	public Logout(){
		super(playerDatabase, board, game);
		 //frame.setSize(500,600);
	        //frame.setLocationRelativeTo(null);
	        frame.setBackground(Color.LIGHT_GRAY);
	        frame.setBounds(350,120,684,400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //frame.getContentPane().setLayout(new GridLayout(6,6));
	        
	        JPanel panel = new JPanel();
	        frame.getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblUsername = new JLabel("Username");
	        lblUsername.setBounds(58, 120, 62, 14);
	        panel.add(lblUsername);
	        
	        
	        user = new JTextField();
	        user.setBounds(148, 117, 151, 20);
	        panel.add(user);
	        user.setColumns(10);
	        
	        
	        JButton btnNewButton = new JButton("login");
	        btnNewButton.setAction(action);
	        btnNewButton.setBounds(148, 218, 89, 23);
	        btnNewButton.setAction(action);
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		if(game.logout(user.getText())){
	        			JOptionPane.showMessageDialog(null,"successful logout");
	        			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	        		}
	        		else{
	        			JOptionPane.showMessageDialog(null,"Not correct username");
	        		}
	        	}
	        });
	        panel.add(btnNewButton);
	        
	        JLabel lblNewLabel = new JLabel("LOGIN");
	        lblNewLabel.setBounds(85, 38, 137, 31);
	        panel.add(lblNewLabel);
	        
	        frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "login");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
