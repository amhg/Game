/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package andreaConnect4;


public class logic {
    private int cells_left = 0;
    private int max;
    private int xsize;
    private int ysize;
    Grid my_grid;
    
    public logic(Grid tempGrid){
        max = 4;//connect 4 or n
        my_grid = tempGrid;
        cells_left = my_grid.get_cells_left();
        xsize = my_grid.get_xsize();
        ysize = my_grid.get_ysize();
        }
    
    public void set_and_check(int x, int y, int player){//sets the found coordinate to current player
        my_grid.set_matrix(x, y, player);
        cells_left--;
        }
    
}
