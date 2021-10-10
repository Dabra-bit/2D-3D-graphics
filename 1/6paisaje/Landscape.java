
import java.awt.*;
import javax.swing.*;

class Landscape extends JFrame {

  private String windowTitle;
  private int width;
  private int height;

  Landscape() {
    super("Test");

    this.width = 200;
    this.height = 200;
    this.windowTitle = "Test";

    this.createBaseWindow();
  }

  Landscape(String windowTitle, int width, int height) {
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
    g.setColor(new Color(51, 204, 204)); // Establecer color #33cccc
    g.fillRect(0, 0, 800, 500); // Dibujar fondo

    g.setColor(Color.YELLOW); // Rellenar color amarillo
    g.fillArc(50, 60, 50, 50, 0, 360); // Rellenar sol
    g.setColor(Color.BLACK); // Rellenar color amarillo
    g.drawArc(50, 60, 50, 50, 0, 360); // Dibujar sol
    
    // Dibujar rayos de sol
    g.drawLine(75, 120, 75, 150);
    g.drawLine(110, 85, 140, 85);
    g.drawLine(100, 110, 125, 135);

    // Dibujar pasto
    g.setColor(Color.GREEN);
    g.fillRect(0, 400, 800, 100);

    // Dibujar casa
    g.setColor(new Color(255, 255, 204)); // Set color #ffffcc
    g.fillRect(300, 250, 250, 180); // Dibujar casita

    // Dibujar techo
    g.setColor(new Color(128, 32, 0)); // Set color #802000
    g.fillRect(260, 230, 330, 20); // Dibujar chimenea

    // Dibujar chimenea
    g.fillRect(425, 190, 40, 60);

    // Dibujar puerta
    g.setColor(new Color(77, 26, 0)); // Set color #4d1a00
    g.fillRect(405, 350, 40, 80); // Draw door

    // Draw window
    g.setColor(new Color(153, 255, 255)); // Set color #99ffff
    g.fillRect(310, 260, 230, 80); // Draw big window
    g.setColor(new Color(255, 255, 204)); // Set color #ffffcc
    g.fillRect(405, 260, 40, 80); // Divide window

  }
}
