import javax.swing.JFrame;
import javax.swing.*;
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
        JButton button = new JButton("Start a new game");
        button.addActionListener(new NewGameActionListener(b));
        
        this.add(b, BorderLayout.CENTER);
        this.add( new JLabel("Attempts: " + b.getAttempts()), BorderLayout.NORTH);
        
        
        this.add(button, BorderLayout.SOUTH);
        this.pack();
        b.setVisible(true);
        this.setSize(400,480);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
      EightPuzzle puzzleframe = new EightPuzzle();

    }

    public static void main(String[] args) {
        EightPuzzle puzzleframe;
        Board b;

        puzzleframe = new EightPuzzle();
    }

}
