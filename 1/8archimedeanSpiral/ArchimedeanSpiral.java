
import java.awt.*;
import javax.swing.*;

class ArchimedeanSpiral extends JFrame implements Runnable {

  // Window's properties
  private String windowTitle;
  private int width;
  private int height;

  // Threads' properties
  private Thread thr;

  // Double buffering
  private Image background;

  // Spiral variables
  private final int PIECES = 20; // Pieces of spiral

  // Base values
  private int spiralSquareLength;
  private int depth;
  private int multiplier;

  // Default values
  private int sqrWidth;
  private int sqrHeight;
  private int x;
  private int y;
  private int startingAngle;
  private int arcAngle;
  private int lineWidth;

  // Iterator
  private int i;

  ArchimedeanSpiral() {
    super("Test");

    this.width = 200;
    this.height = 200;
    this.windowTitle = "Test";

    this.createBaseWindow();

    thr = new Thread(this);
    thr.start();
  }

  ArchimedeanSpiral(String windowTitle, int width, int height) {
    super(windowTitle);

    this.width = width < 200 ? 200 : width ;
    this.height = height < 200 ? 200 : height;
    this.windowTitle = windowTitle;

    this.createBaseWindow();

    thr = new Thread(this);
    thr.start();
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
    if(this.background == null) {
      // Base values
      this.i = 0;
      this.spiralSquareLength = this.width / this.PIECES;
      this.depth = this.spiralSquareLength / 2;
      this.multiplier = 1;

      // Default values
      this.sqrWidth = this.spiralSquareLength;
      this.sqrHeight = this.spiralSquareLength;
      this.x = this.width / 2 - this.depth;
      this.y = this.height / 2 - this.depth;
      this.startingAngle = 0;
      this.arcAngle = 180;

      this.lineWidth = this.sqrWidth / 2;

      this.background = createImage(getWidth(), getHeight());

      Graphics gBG = this.background.getGraphics();
      gBG.setClip(0, 0, getWidth(), getHeight());

      gBG.drawLine(this.x + this.lineWidth/2, this.y + this.depth, this.x + ((int) (1.5*this.lineWidth)), this.y + this.depth);
      gBG.drawArc(this.x - this.lineWidth/2, this.y, this.sqrWidth, this.sqrHeight, this.startingAngle, this.multiplier * this.arcAngle);
      gBG.drawArc(this.x + this.lineWidth/2, this.y, this.sqrWidth, this.sqrHeight, this.startingAngle, -this.multiplier * this.arcAngle);
    }

    update(g);
  }

  public void update(Graphics g) {
    // Set area to draw
    g.setClip(0, 0, getWidth(), getHeight());

    // Draw background
    Graphics gBG = this.background.getGraphics();
    gBG.setClip(0, 0, getWidth(), getHeight());

    gBG.setClip(0, 0, getWidth(), getHeight());
    gBG.drawImage(this.background, 0, 0, this);

    // Draw spiral piece
    this.multiplier = i % 2 == 0 ? -1 : 1;
    this.y -= depth;
    this.x -= this.i % 2 == 0 ? 0 : this.spiralSquareLength;
    int xprime = this.x - (this.i % 2 != 0 ? 0 : this.spiralSquareLength);
    this.sqrWidth += this.spiralSquareLength;
    this.sqrHeight += this.spiralSquareLength;

    gBG.drawArc(this.x - this.lineWidth/2, this.y, this.sqrWidth, this.sqrHeight, this.startingAngle, this.multiplier * this.arcAngle);
    gBG.drawArc(xprime + this.lineWidth/2, this.y, this.sqrWidth, this.sqrHeight, this.startingAngle, -this.multiplier * this.arcAngle);

    // Paint buffer
    g.drawImage(this.background, 0, 0, this);

    this.i++;
  }

  public void run() {
    while(this.i < this.PIECES - 1) {
      try {
        thr.sleep(1000);
      } catch (InterruptedException e) {
      }

      repaint();
    }
  }
}
