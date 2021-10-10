
import java.awt.*;
import javax.swing.*;
import java.util.Random;

class PieChart extends JFrame {

  // Window's properties
  private String windowTitle;
  private int width;
  private int height;

  // Pie graph properties
  private float[] data;
  private int x;
  private int y;
  private int w;
  private int h;

  // Random property
  private Random rand;

  PieChart() {
    super("Test");

    // Window properties
    this.width = 200;
    this.height = 200;
    this.windowTitle = "Test";

    // Set up the chart dimensions to 80% of the shortest window dimension
    this.w = this.h = 160;

    // Set up chart square center
    this.x = this.y = 20;

    // Save the data received
    this.data = new float[] {1};

    // Instantiate random property
    this.rand = new Random();

    this.createBaseWindow();
  }

  PieChart(String windowTitle, int width, int height, float[] data) {
    super(windowTitle);

    // Window properties
    this.width = width < 200 ? 200 : width ;
    this.height = height < 200 ? 200 : height;
    this.windowTitle = windowTitle;

    // Set up the chart dimensions to 80% of the shortest window dimension
    int shortestDimension = this.width < this.height ? this.width : this.height;
    this.w = this.h = (int) (0.8 * shortestDimension);

    // Set up chart square center
    this.x = (this.width - this.w ) / 2;
    this.y = (this.height - this.h ) / 2;

    // Save the data received
    this.data = data;

    // Instantiate random property
    this.rand = new Random();

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

  private Color createNewRandomColor() {
    int r = rand.nextInt(256);
    int g = rand.nextInt(256);
    int b = rand.nextInt(256);

    return new Color(r, g, b);
  }

  public void paint(Graphics g) {

    int angle = 0; // Starting angle

    // Build a part of the chart
    for(float d : this.data) {

      int addedAngle = (int) (d * 360); // Angle to add

      // Draw the arc
      g.setColor(this.createNewRandomColor());
      g.fillArc(this.x, this.y, this.w, this.h, angle, addedAngle);

      angle += addedAngle; // Increment the starting angle
    }
  }
}
