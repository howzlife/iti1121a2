import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.BorderLayout;

class EightPuzzle extends JFrame implements ActionListener {

    private Board puzzleboard;

    /* Constructor */

    public EightPuzzle() {
        super("Eight Puzzle");

        Board b;
        JButton reset;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        b = new Board();
        b.init();
        this.add(b, BorderLayout.CENTER);
        this.puzzleboard = b;
        this.add( new JLabel("Attempts: " + b.getAttempts()), BorderLayout.NORTH);

        reset = new JButton("Start new game");
        reset.addActionListener(this);
        this.add(reset, BorderLayout.SOUTH);

        this.pack();
        b.setVisible(true);
        this.setSize(420,480);
        this.setVisible(true);
    }

    /* Public methods */

    public void actionPerformed(ActionEvent e) {
        System.out.println("Reset!");
        this.puzzleboard.init();
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        EightPuzzle puzzleframe;
        Board b;

        puzzleframe = new EightPuzzle();
    }

}
