/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package andreaConnect4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author amhg
 */
public class gui {
    
    private JFrame frame;
    private JLabel[][] slots;
    private JButton[] buttons;
    //variables used in grid
    private int xsize = 7;
    private int ysize = 6;
    private int currentPlayer = 1;
    Grid my_grid = new Grid();
   
      
    public static void main(String[] args){
        new gui().buildGUI();
    
        }
            
    public void buildGUI(){
        
        frame = new JFrame("connect four");
        
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(new GridLayout(xsize, ysize + 1));//GridLayout(int rows, int cols) or (xsize, ysize + 1)
        
        slots = new JLabel[xsize][ysize];
        buttons = new JButton[xsize];
       
        for(int i = 0; i < xsize; i++){
          buttons[i] = new JButton("" + (i + 1));
            buttons[i].setActionCommand("" + i);
            buttons[i].addActionListener(
                    new ActionListener(){
                        
                        public void actionPerformed(ActionEvent e){
                            int a = Integer.parseInt(e.getActionCommand());
                            int y = my_grid.find_y(a);//check for space in collum
                            if(y != -1){
                                //set a place to current player
                                my_grid.set_matrix(a, y, currentPlayer);
                                frame.setTitle("Connect Four - player " + currentPlayer + "'s turn");
                                currentPlayer = my_grid.changeplayer(currentPlayer, 2);
                                updateBoard();
                                }
                            else{
                                JOptionPane.showMessageDialog(null, "Choose another one", "Column is filled", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }//actionPerformed
                        
                        });//ActionListener
            
            panel.add(buttons[i]);
            }//end for
        
        for (int column = 0; column < ysize; column++) {
            for (int row = 0; row < xsize; row++) {
                slots[row][column] = new JLabel("r" + row + "c" + column);
                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
                slots[row][column].setBorder(new LineBorder(Color.black));
                panel.add(slots[row][column]);
            }
        }
        
        //jframe stuff
        frame.setContentPane(panel);
        frame.setSize(700,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    public void updateBoard() {//keeps the gui in sync with the logggggtjiic and grid
        for (int row = 0; row < xsize; row++) {
            for (int column = 0; column < ysize; column++) {
                if (my_grid.matrix_equals(row, column, 1)) {
                    slots[row][column].setOpaque(true);
                    slots[row][column].setBackground(Color.red);
                }
                if (my_grid.matrix_equals(row, column, 2)) {
                    slots[row][column].setOpaque(true);
                    slots[row][column].setBackground(Color.blue);
                }
            }
        }
    }
    
}

