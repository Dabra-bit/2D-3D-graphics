import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.awt.event.MouseEvent;

class MouseTest extends JFrame implements MouseListener {

  private int width;
  private int height;

  MouseTest(String windowTitle, int width, int height) {
    super(windowTitle);

    this.width = width;
    this.height = height;

    this.createBaseWindow();

    this.addMouseListener(this);
  }

  private void createBaseWindow() {
    // Close application on window close
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false); // Disable window risizing
    setSize(this.width, this.height); // Set window size
    setLocationRelativeTo(null); // Open window in the center of the screen

    // Set visible
    setVisible(true);
  }

  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse clicked");
  }

  public void mousePressed(MouseEvent e) {
    System.out.println("Mouse pressed");
  }

  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released");
  }

  public void mouseEntered(MouseEvent e) {
    System.out.println("Mouse entered");
  }

  public void mouseExited(MouseEvent e) {
    System.out.println("Mouse exited");
  }
}
