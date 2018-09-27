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




public class ChooseMove extends Gui implements ActionListener{
    JFrame frame = new JFrame();
    


    private JTextField player2Move;
    private JTextField  player1Move;
    private final Action action = new SwingAction();
    public ChooseMove(){
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
            
            JLabel lblUsername = new JLabel("Player 1 Moves: ");
            lblUsername.setBounds(58, 120, 62, 14);
            panel.add(lblUsername);
            
            JLabel lblPassword = new JLabel("Player 2 Moves: ");
            lblPassword.setBounds(58, 158, 46, 14);
            panel.add(lblPassword);
            
            player1Move = new JTextField();
            player1Move .setBounds(148, 117, 151, 20);
            panel.add(player1Move );
            player1Move .setColumns(10);
            
            player2Move  = new JTextField();
            player2Move.setBounds(148, 155, 151, 20);
            panel.add(player2Move);
            player2Move.setColumns(10);
            
            JButton btnNewButton = new JButton("Play!");
            
            btnNewButton.setBounds(148, 218, 89, 23);
            btnNewButton.setAction(action);
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    if(player1Move.getText() != null && player1Move.getText().matches("[-+]?\\d*\\.?\\d+") && player2Move.getText() != null && player2Move.getText().matches("[-+]?\\d*\\.?\\d+")){
                        game.averageMove(Integer.parseInt(player1Move.getText()), Integer.parseInt(player2Move.getText()));
                        game.playGame();
                        
                        
                        Score score = new Score();
                        new Play(score);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please enter only numbers");
                    }
                }
            });
            panel.add(btnNewButton);
            
            JLabel lblNewLabel = new JLabel("CHOOSE MOVES");
            lblNewLabel.setBounds(85, 38, 137, 31);
            panel.add(lblNewLabel);
            
            frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Play!");
        }
        public void actionPerformed(ActionEvent e) {
        }
    }
}
