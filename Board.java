import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.GridLayout;

class Board extends JPanel implements ActionListener {

    private Cell[] cells;
    private RandomPermutation randperm;
    private int attempts;

    public Board() {
        this.setLayout(new GridLayout(3, 3));
    }

    public void actionPerformed(ActionEvent e) {
        int i, j, pos, swap = -1;
        Cell c;
        boolean youwon;

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
        if (pos > 2 && this.cells[pos-3].getId() == 0) {
            swap = pos-3;
        } else if(pos > 0 && this.cells[pos-1].getId() == 0) {
            swap = pos-1;
        } else if (pos < 8 && this.cells[pos+1].getId() == 0) {
            swap = pos+1;
        } else if (pos < 6 && this.cells[pos+3].getId() == 0) {
            swap = pos+3;
        }
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
        this.revalidate();
        this.repaint();
        this.attempts++;
        if (youwon) {
            JOptionPane.showMessageDialog(this, "You won in "+this.attempts+" moves.");
        }
    }

    public void shuffle() {
        this.randperm.shuffle();
    }

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

        a = this.randperm.toArray();
        for (int i=0;i<a.length;i++) {
            this.cells[i].setId(a[i]);
            this.add(cells[i]);
        }
    }

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
