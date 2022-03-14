
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.util.GregorianCalendar;
import java.awt.image.BufferedImage;

class MyClock extends JFrame implements Runnable {

  private int HOURHANDLEN;
  private int MINHANDLEN;
  private int SECHANDLEN;

  // Window properties
  private String windowTitle;
  private int width;
  private int height;
  private int margin;

  // Time properties
  private int hour;
  private int minute;
  private int second;

  // Double buffering
  private Image background;
  private Image buffer;
  private BufferedImage image;

  // Thread
  private Thread thr;

  // Constructor
  public MyClock(String windowTitle, int width, int height) {
    super(windowTitle);

    // Set window config
    this.width = width;
    this.height = height;
    this.margin = (int) (width * 0.3);
    this.windowTitle = windowTitle;
    this.createBaseWindow();

    // Set hands length
    this.HOURHANDLEN = (int) (0.2 * (this.width - this.margin));
    this.MINHANDLEN = (int) (0.3 * (this.width - this.margin));
    this.SECHANDLEN = (int) (0.4 * (this.width - this.margin));

    // Double buffering
    this.background = this.buffer = null;

    // Load background Image
    try {
      image = ImageIO.read(new File("dali.jpg"));
    } catch(IOException e) {
      System.out.println("Failed to load image...");
    }

    // Thread start
    this.thr = new Thread(this);
    this.thr.start();
  }

  private void createBaseWindow() {
    JPanel panel = new JPanel();

    // Close application on window close
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setContentPane(panel); // Add the panel
    setResizable(false); // Disable window risizing
    setSize(this.width, this.height); // Set window size
    setLocationRelativeTo(null); // Open window in the center of the screen
    setLayout(null);

    // Draw controls
    this.drawControls();
  }

  public void visible(boolean visible) {
    // Set visible
    setVisible(visible);
  }

  public void setTime(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public void paint(Graphics g) {
    if(this.background == null) {
      this.background = createImage(getWidth(), getHeight());

      Graphics gBG = this.background.getGraphics();
      gBG.setClip(0, 0, getWidth(), getHeight());

      // Draw background image
      gBG.drawImage(image, 0, 0, this.width, this.height, this);

      // Draw clock
      this.drawClock(gBG);
    }

    update(g);
  }

  private void drawThickClockFace(Graphics g, int x, int y, int thick) {
    int w = this.width - this.margin;
    int h = this.height - this.margin;

    for(int i = 0, temp = 0; i < thick; i++, temp+=2) {
      if(i == 0) {
        g.setColor(new Color(1f, 1f, 1f, 0.5f));
        g.fillOval(x - i, y - i, w + temp, h + temp);
      } else {
        g.setColor(Color.BLACK);
        g.drawOval(x - i, y - i, w + temp, h + temp);
      }
    }
  }

  private void drawSpiral(Graphics g) {

    // Pieces of spiral
    int pieces = 5;

    // Base values
    int spiralSquareLength = (this.width - margin) / pieces;
    int depth = spiralSquareLength / 2;
    int multiplier = 1;

    // Default values
    int sqrWidth = spiralSquareLength;
    int sqrHeight = spiralSquareLength;
    int x = this.width / 2 - depth;
    int y = this.height / 2 - depth;
    int startingAngle = 0;
    int arcAngle = 180;

    g.drawArc(x, y, sqrWidth, sqrHeight, startingAngle, multiplier * arcAngle);

    // Draw the other halfs of spiral
    for(int i = 0; i < pieces - 1; i++) {
      multiplier = i % 2 == 0 ? -1 : 1;
      y -= depth;
      x -= i % 2 == 0 ? 0 : spiralSquareLength;
      sqrWidth += spiralSquareLength;
      sqrHeight += spiralSquareLength;

      g.drawArc(x, y, sqrWidth, sqrHeight, startingAngle, multiplier * arcAngle);
    }
  }

  private void drawMinLines(Graphics g) {
    int center = this.width / 2; // Center of window
    int radius = (this.width - this.margin) / 2; // Radius of circle

    int shortLineLength = 10;
    int longLineLength = shortLineLength * 2;

    for(int ang = 0; ang < 360; ang += 6) {
      double radians = ang * Math.PI / 180;
      int xInBorder = (int) (radius * Math.cos(radians)) + center;
      // Y has a negative because of the system of coordinates
      // A bigger Y gets us lower instead of higher
      int yInBorder = -(int) (radius * Math.sin(radians)) + center;

      // Compute P(x,y) in clock's border
      int xMove = 0;
      int yMove = 0;

      if(ang % 30 == 0) { // If hour draw a larger line
        xMove = (int) (longLineLength * Math.cos(radians));
        yMove = (int) (longLineLength * Math.sin(radians));
      } else { // Draw a shorter line
        xMove = (int) (shortLineLength * Math.cos(radians));
        yMove = (int) (shortLineLength * Math.sin(radians));
      }

      // Get starting coords
      int starting_x = xInBorder - xMove;
      int starting_y = yInBorder + yMove;

      // Draw the lines
      g.drawLine(starting_x, starting_y, xInBorder, yInBorder);
    }
  }

  private void drawNumbers(Graphics g) {
    int[] numCoords;

    for(int i = 0; i < 12; i++) {
      String num = String.valueOf(i == 0 ? "12" : String.valueOf(i));
      numCoords = this.computeCoords(this.SECHANDLEN, 30 * i + 90);
      g.drawString(num, numCoords[0] - 10, numCoords[1] + 15);
    }
  }

  private void drawClock(Graphics g) {
    // Clock's circle
    this.drawThickClockFace(g, this.margin / 2, this.margin / 2, 8);

    // Center circle
    g.fillOval((this.width / 2) - 10, (this.height / 2) - 10, 20, 20);

    // Spiral
    g.setColor(Color.RED);
    this.drawSpiral(g);

    // Minute lines
    g.setColor(Color.BLACK);
    this.drawMinLines(g);

    // Draw numbers
    g.setColor(Color.BLACK);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
    this.drawNumbers(g);
  }

  private void drawControls() {
    SpinnerModel hourModel = new SpinnerNumberModel(12, 1, 12, 1);
    SpinnerModel minSecModel = new SpinnerNumberModel(0, 0, 60, 1);

    JSpinner hourSpinner = new JSpinner(hourModel);
    JSpinner minSpinner = new JSpinner(minSecModel);
    JSpinner secSpinner = new JSpinner(minSecModel);

    hourSpinner.setLocation(100, 500);
    hourSpinner.setSize(50, 25);

    minSpinner.setLocation(210, 500);
    minSpinner.setSize(50, 25);
    
    secSpinner.setLocation(320, 500);
    secSpinner.setSize(50, 25);

    this.getContentPane().add(hourSpinner);
    this.getContentPane().add(minSpinner);
    this.getContentPane().add(secSpinner);
  }

  private double degToRad(int ang) {
    return ang * Math.PI / 180;
  }

  private int[] computeCoords(int length, int ang) {
    int center = this.width / 2;

    int y = (int) (-length * Math.sin(degToRad(ang)) + center);
    int x = (int) (-length * Math.cos(degToRad(ang)) + center);

    return new int[] {x, y};
  }

  public void update(Graphics g) {
    Calendar cal = GregorianCalendar.getInstance();

    // Seconds, minutes and hours coordinates
    int[] secCoords = this.computeCoords(this.SECHANDLEN, 6 * this.second + 90);
    int[] minCoords = this.computeCoords(this.MINHANDLEN, 6 * this.minute + 90);
    int[] hourCoords = this.computeCoords(this.HOURHANDLEN, 30 * this.hour + 90);

    boolean areSmallHandsDrawn = false;
    int center = this.width / 2;

    // Set area to draw
    g.setClip(0, 0, getWidth(), getHeight());

    // Draw background
    this.buffer = createImage(getWidth(), getHeight());
    Graphics gBuffer = this.buffer.getGraphics();

    gBuffer.setClip(0, 0, getWidth(), getHeight());
    gBuffer.drawImage(this.background, 0, 0, this);

    if(cal.get(Calendar.MINUTE) != this.minute) {

      this.hour = cal.get(Calendar.HOUR);
      this.minute = cal.get(Calendar.MINUTE);

      // Draw clock's small hands
      gBuffer.setColor(Color.BLACK);
      gBuffer.drawLine(center, center, hourCoords[0], hourCoords[1]);
      gBuffer.drawLine(center, center, minCoords[0], minCoords[1]);
      areSmallHandsDrawn = true;
    }

    // Paint buffer
    g.drawImage(this.buffer, 0, 0, this);

    // Draw seconds' hand and play sound
    this.second = cal.get(Calendar.SECOND);
    this.playTickAudio();

    g.setColor(Color.GREEN);
    g.drawLine(center, center, secCoords[0], secCoords[1]);
    if(!areSmallHandsDrawn) {
      // Draw clock's small hands
      g.setColor(Color.BLACK);
      g.drawLine(center, center, hourCoords[0], hourCoords[1]);
      g.drawLine(center, center, minCoords[0], minCoords[1]);
    }
  }

  private void playTickAudio() {
    String audioFileName = "./clockTickTrimmed.wav";

    try {
      File audioFile = new File(audioFileName);
      
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(audioFile));
      clip.start();
    } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    while(true) {
      try {
        this.thr.sleep(1000);
      } catch(InterruptedException ex) {
      }

      repaint();
    }
  }

}
