/**
 * Auto Generated Java Class.
 */
public class Test {
  
  public static void main(String [] args) {
    int[] cells = new int[9];

    for (int i = 0; i < cells.length; i++) {
      cells[i] = i;
    }
    
    
      String arr = "";
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          arr += "[" + cells[(i * 3) + j] + "]";
        }
        arr += "\n";
      }
    
    System.out.println(arr);
  }


}
