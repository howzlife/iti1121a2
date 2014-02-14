import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.BorderLayout;

class EightPuzzle extends JFrame implements ActionListener {

  //Declare class variables
    private JLabel label;
    private Board puzzleboard;
    private final String initialLabel = "Attempts: 0";

    /* Constructor */

    public EightPuzzle() {
        super("Eight Puzzle");


        JButton reset;
        this.puzzleboard = new Board(this);

        //Set JFrame to close when we close it
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //initiate puzzle board - see Board class for more detail
        this.puzzleboard.init();
        this.add(this.puzzleboard, BorderLayout.CENTER);

        this.label =  new JLabel(this.initialLabel);
        this.add(this.label, BorderLayout.NORTH);

        // start new game button - set to South location, when clicked re-shuffles the board
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

        //if board is clicked on, or if current number of attempts = 0, update number of attempts on board
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

    //main method to initiate instance of PuzzleFrame
    public static void main(String[] args) {
        EightPuzzle puzzleframe;
        Board b;

        puzzleframe = new EightPuzzle();
    }

}
