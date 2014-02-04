import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.*;

class Cell extends JButton {
    
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

    /* public methods */

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
        /*this.icon = new ImageIcon("data/image-0"+Integer.toString(this.id));
          this.setIcon(this.icon);*/
        this.setText(Integer.toString(this.id));
        if (this.id != 0)
            this.setVisible(true);
        else
            this.setVisible(false);
    }

    public String toString() {
        return Integer.toString(this.id);
    }
}
