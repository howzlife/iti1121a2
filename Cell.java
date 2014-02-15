import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

class Cell extends JButton {

  //Class variables
    private int id, row, col;
    private Board puzzleboard;
    private ImageIcon icon;

    /* Constructor */

    public Cell(Board b, int x, int y) {
        this.row = x;
        this.col = y;
        this.puzzleboard = b;
        this.addActionListener(b);
    }

    //Public Methods, all quite obvious as to what they do

    public int getColumn() {
        return this.col;
    }

    public int getId() {
        return this.id;
    }

    public int getRow() {
        return this.row;
    }

    public void setId(int newid) {
        this.id = newid;
        this.setVisible(true);
    }

    public void setImage(Image img) {
        this.setIcon(new ImageIcon(img));
    }

    public String toString() {
        return Integer.toString(this.id);
    }
}
