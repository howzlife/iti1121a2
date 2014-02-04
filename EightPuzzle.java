import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.BorderLayout;

class EightPuzzle extends JFrame implements ActionListener {

    private Board puzzleboard;

    public EightPuzzle() {
        super("Eight Puzzle");

        Board b;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        b = new Board();
        b.init();

        this.add(b, BorderLayout.CENTER);
        this.pack();
        b.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String[] args) {
        EightPuzzle puzzleframe;
        Board b;

        puzzleframe = new EightPuzzle();

        puzzleframe.setVisible(true);
    }

}
