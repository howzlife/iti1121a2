import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;


class EightPuzzle extends JFrame implements ActionListener {

    //Declare class variables
    private JLabel label;
    private Board puzzleBoard;
    private JButton selectImgButton;
    private final String initialLabel = "Attempts: 0";

    /* Constructor */

    public EightPuzzle() {
        super("Eight Puzzle");

        JButton reset;
        this.puzzleBoard = new Board(this);

        //Set JFrame to close when we close it
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //initiate puzzle board - see Board class for more detail
        this.puzzleBoard.init();
        this.add(this.puzzleBoard, BorderLayout.CENTER);

        this.label =  new JLabel(this.initialLabel);
        this.add(this.label, BorderLayout.NORTH);

        // start new game button - set to South location, when clicked re-shuffles the board
        reset = new JButton("Start new game");
        reset.addActionListener(this);
        this.add(reset, BorderLayout.SOUTH);

        this.pack();
        this.puzzleBoard.setVisible(true);
        this.setSize(420,480);
        this.setVisible(true);
    }

    /* Public methods */

    public void actionPerformed(ActionEvent e) {
        String newLabel;
        Object source;
        JFileChooser filechooser;
        Image chosenimg;

        //if board is clicked on, or if current number of attempts = 0, update number of attempts on board
        newLabel = e.getActionCommand();
        source = e.getSource();
        if (source == this.selectImgButton) {
            filechooser = new JFileChooser();
            while (filechooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION);
            while (true) {
                try {
                    chosenimg = ImageIO.read(filechooser.getSelectedFile());
                    break;
                } catch (IOException except) {
                    continue;
                }
            }
            this.puzzleBoard.setImageSource(chosenimg);
        } else if (source != this.puzzleBoard || newLabel.equals(this.initialLabel)) {
            this.puzzleBoard.removeAll();
            this.puzzleBoard.init();
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
