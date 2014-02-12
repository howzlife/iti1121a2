import java.awt.event.*;
public class NewGameActionListener implements ActionListener {
  
  private Board b;
  
  NewGameActionListener(Board b) {
   this.b = b; 
  }
  
  public void actionPerformed( ActionEvent e ) {
    EightPuzzle p = new EightPuzzle();
  }
  
}
