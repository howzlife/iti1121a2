import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.BorderLayout;

class EightPuzzle extends JFrame implements ActionListener {

    private JLabel label;
    private Board puzzleboard;
    private final String initialLabel = "Attempts: 0";

    /* Constructor */

    public EightPuzzle() {
        super("Eight Puzzle");

        JButton reset;

        this.puzzleboard = new Board(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.puzzleboard.init();
        this.add(this.puzzleboard, BorderLayout.CENTER);

        this.label =  new JLabel(this.initialLabel);
        this.add(this.label, BorderLayout.NORTH);

        reset = new JButton("Start new game");
        reset.addActionListener(this);
        this.add(reset, BorderLayout.SOUTH);

        this.pack();
        this.puzzleboard.setVisible(true);
        this.setSize(420,480);
        this.setVisible(true);
    }

    /* Public methods */

    public void actionPerformed(ActionEvent e) {
        String newLabel;

        newLabel = e.getActionCommand();
        if (e.getSource() != this.puzzleboard || newLabel.equals(this.initialLabel)) {
            this.puzzleboard.removeAll();
            this.puzzleboard.init();
            this.label.setText(this.initialLabel);
            this.revalidate();
            this.repaint();
        } else {
            this.label.setText(newLabel);
        }
    }

    public static void main(String[] args) {
        EightPuzzle puzzleframe;
        Board b;

        puzzleframe = new EightPuzzle();
    }

}
