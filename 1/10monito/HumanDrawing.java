
import java.awt.*;
import javax.swing.*;

class HumanDrawing extends JFrame {

  private String windowTitle;
  private int width;
  private int height;

  HumanDrawing() {
    super("Test");

    this.width = 200;
    this.height = 200;
    this.windowTitle = "Test";

    this.createBaseWindow();
  }

  HumanDrawing(String windowTitle, int width, int height) {
    super(windowTitle);

    this.width = width;
    this.height = height;
    this.windowTitle = windowTitle;

    this.createBaseWindow();
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

  public void paint(Graphics g) {
    // Dibujar cara
    g.drawArc(50, 60, 50, 50, 0, 360); // Cara (forma)
    g.drawArc(60, 70, 30, 30, 180, 180); // Sonrisa
    g.fillOval(65, 75, 5, 5); // Ojo izquierdo
    g.fillOval(80, 75, 5, 5); // Ojo derecho
    // Dibujar cuerpo
    g.drawLine(75, 110, 75, 200);
    // Brazos
    g.drawLine(75, 120, 45, 160);
    g.drawLine(75, 120, 105, 160);
    // Piernas
    g.drawLine(75, 200, 45, 240);
    g.drawLine(75, 200, 105, 240);
  }
}
