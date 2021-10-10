/**
 * 07 - Ventana (JFrame)
 */

import java.awt.*;
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    createWindow();
  }

  private static void createWindow() {
    // Components for the window
    JFrame frame = new JFrame("Testing JFrames");
    JPanel panel = new JPanel();
    JLabel lblHello = new JLabel("Hello, World!");

    // Close application on window close
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setContentPane(panel); // Add the panel
    frame.setSize(280, 80);
    frame.getContentPane().add(lblHello);


    frame.setLocationRelativeTo(null);// Open window in the center of the screen
    // frame.pack(); // Make the size of the window fit the size of its childs
    frame.setVisible(true); // Show the window
  }

  public void drawPixel(int x, int y) {
    
  }

  public void drawLine(int x0, int y0, int x1, int y1) {

  }
}
