import javax.swing.JPanel;
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
        if (!(e.source instanceof Cell))
            return;
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
        return "";
    }

}
