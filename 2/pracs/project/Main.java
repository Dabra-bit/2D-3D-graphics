package project;

import points.CustomPoint;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame {
    BufferedImage background;
    Graphics2D graphsBG;
    Dimension dimVentana;
    Timer timer;
    double t;

    public Main() {

        t = 0;
        background = new BufferedImage(1000, 1000, BufferedImage.TYPE_3BYTE_BGR);
        graphsBG = background.createGraphics();
        graphsBG.setBackground(Color.LIGHT_GRAY);

        init();
    }

    private void init() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("2nd partial - Project");
        setResizable(false);

        Dimension dimPantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        dimVentana = new Dimension(800, 600);
        setSize(dimVentana);
        setLocation(
                (dimPantalla.width - dimVentana.width) / 2,
                (dimPantalla.height - dimVentana.height) / 2);

        timer = new Timer(1000 / 30, e -> {
            t += 1.0 / 30;
            graphsBG.clearRect(0, 0, dimVentana.width, dimVentana.height);
            dibujar(background, t);
            repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this);
    }

    // Draw the whole project
    public void dibujar(BufferedImage img, double t) {

        for (int i = 0; i < 5; i++) {
            ProjectGraphics.fillCircle(img, new CustomPoint(200 + 100 * i, 450), 45, Color.BLACK);
            ProjectGraphics.drawCircle(img, new CustomPoint(200 + 100 * i, 450), 50, 10, Color.DARK_GRAY);
        }
        // Linea
        double ct = Math.cos(Math.PI * t);
        double st = Math.sin(Math.PI * t);
        int vn = (int) (30 * t);

        ProjectGraphics.drawLine(img,
                new CustomPoint(200 + (int) (50 * ct), 450 + (int) (50 * st)),
                new CustomPoint(600 + (int) (50 * ct), 450 + (int) (50 * st)),
                10,
                Color.GRAY);

        ProjectGraphics.fillRectangle(img, new CustomPoint(0, 500), new CustomPoint(800, 600), Color.decode("#964B00"));

        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 100 - vn), 110), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 150 - vn), 110), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 70 - vn), 130), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 110 - vn), 90), 50, Color.WHITE);

        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 410 - vn), 180), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 470 - vn), 180), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 350 - vn), 150), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 420 - vn), 160), 50, Color.WHITE);

        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 700 - vn), 130), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 770 - vn), 110), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 650 - vn), 80), 50, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 950, 720 - vn), 90), 50, Color.WHITE);

        ProjectGraphics.fillRectangle(img, new CustomPoint(80, 280), new CustomPoint(680, 450), Color.DARK_GRAY); // Cuerpo
        ProjectGraphics.fillRectangle(img, new CustomPoint(100, 120), new CustomPoint(480, 400), Color.DARK_GRAY); // Cabina
        ProjectGraphics.fillRectangle(img, new CustomPoint(100, 150), new CustomPoint(260, 240), Color.gray); // Ventanas
        ProjectGraphics.fillRectangle(img, new CustomPoint(175, 150), new CustomPoint(185, 240), Color.BLACK); // Marco
        //ProjectGraphics.fillRectangle(img, new CustomPoint(520, 250), new CustomPoint(500, 279), Color.CYAN); // Espejo
        ProjectGraphics.fillRectangle(img, new CustomPoint(680, 280), new CustomPoint(700, 450), Color.GRAY); // Blindaje
        ProjectGraphics.fillRectangle(img, new CustomPoint(200, 210), new CustomPoint(750, 150), Color.DARK_GRAY); // Cañon
        ProjectGraphics.fillRectangle(img, new CustomPoint(0, 510), new CustomPoint(800, 500), Color.GRAY); // Vias

        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(-150, 700, 900), 180), 30, Color.RED); // Disparo

        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(0, 700, (int) (300 * t) - 425), 180), 30, Color.YELLOW);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(0, 700, 400 - (int) (300 * t)), 170 + (int) (50 * st)), 30, Color.WHITE);
        ProjectGraphics.fillCircle(img, new CustomPoint(ProjectGraphics.enclose(0, 700, 450 - (int) (300 * t)), 150 + (int) (50 * ct)), 30, Color.WHITE);

        ProjectGraphics.fillRectangle(img, new CustomPoint(80, 280), new CustomPoint(680, 290), Color.GRAY);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
