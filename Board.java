import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.event.*;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Board extends JPanel implements ActionListener {

    //Declare class variables
    private Image[] cellimg;
    private Cell[] cells;
    private RandomPermutation randperm;
    private int attempts;
    private EightPuzzle parent;

    //Constructor - passing in a reference to EightPuzzle object
    public Board(EightPuzzle parent) {
        this.setLayout(new GridLayout(3, 3));
        this.parent = parent;
        this.cellimg = null;
    }

    /* private methods */

    private void updateCellImages() {
        int[] a;

        a = this.randperm.toArray();
        for (int i=0;i<a.length;i++) {
            this.cells[i].setId(a[i]);
            this.cells[i].setImage(this.cellimg[a[i]]);
            this.add(cells[i]);
        }
        this.parent.setSize(60 + this.cellimg[1].getWidth(null)*3, 120 + this.cellimg[1].getHeight(null)*3);
    }

    /* public methods */

    //ActionPerformed - used to swap tiles when clicked, and declare a winning state
    public void actionPerformed(ActionEvent e) {
        int i, j, pos, swap = -1;
        Cell c;
        boolean youwon;

        //if cell is not clicked on, do nothing.
        if (!(e.getSource() instanceof Cell))
            return;
        youwon = true;
        c = (Cell)e.getSource();
        pos = -1;
        if (c.getId() == 0)
            return;
        for (i=0;i<this.cells.length;i++) {
            if (this.cells[i].getId() == c.getId()) {
                pos = i;
                break;
            }
        }

        //depending on where is clicked, checks if white cell is next to it. If it is, keeps its position stored in "swap" variable.
        if (pos > 2 && this.cells[pos-3].getId() == 0) {
            swap = pos-3;
        } else if(pos > 0 && this.cells[pos-1].getId() == 0) {
            swap = pos-1;
        } else if (pos < 8 && this.cells[pos+1].getId() == 0) {
            swap = pos+1;
        } else if (pos < 6 && this.cells[pos+3].getId() == 0) {
            swap = pos+3;
        }

        //swaps clicked cell and white cell
        if (swap<0)
            return;
        this.cells[pos] = this.cells[swap];
        this.cells[swap] = c;
        this.removeAll();
        for (i=0;i<9;i++) {
            this.add(cells[i]);
            if ((this.cells[i].getId() == 0 && i != 8) ||
                (this.cells[i].getId() != 0 && this.cells[i].getId() != i+1)) {
                youwon = false;
            }
        }

        //re-sets the board with new positions, and increases attempts. If winning state is achieved, puts out winning message with number of attempts, then resets the board.

        this.revalidate();
        this.repaint();
        this.attempts++;
        if (youwon) {
            JOptionPane.showMessageDialog(this, "You won in "+this.attempts+" moves.");
            this.parent.actionPerformed(new ActionEvent(this, 0, "Attempts: 0"));
        } else {
            this.parent.actionPerformed(new ActionEvent(this, 0, "Attempts: "+this.attempts));
        }
    }

    //shuffle method, shuffles the board through RandomPermutation class
    public void shuffle() {
        this.randperm.shuffle();
    }

    public void setImageSource(BufferedImage img) {
        int width, height;

        width = img.getWidth(null) / 3;
        height = img.getHeight() / 3;
        for (int i=0;i<8;i++) {
            this.cellimg[i+1] = img.getSubimage((i%3)*width, (i/3)*height, width, height);
        }
        this.updateCellImages();
    }

    //Initializes the board, and sets a random permutation.
    public void init() {
        int[] a;

        this.attempts = 0;
        this.cells = new Cell[9];

        this.randperm = new RandomPermutation(3, 3);
        this.randperm.shuffle();

        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                this.cells[i*3+j] = new Cell(this, i, j);
            }
        }

        if (this.cellimg == null) {
            this.cellimg = new Image[9];
            for (int i=0;i<9;i++) {
                try {
                    this.cellimg[i] = ImageIO.read(new File("data/img-0"+i+".png"));
                } catch (IOException except) {
                    continue;
                }
            }
        }
        this.updateCellImages();
    }

    //Prints the board to a string, including number of attempts
    public String toString() {
        String arr = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr += "[" + cells[(i * 3) + j].toString() + "]";
            }
            arr += "\n";
        }
        arr += "\nThe number of moves is " + attempts;
        return arr;
    }

}
