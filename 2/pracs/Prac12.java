import java.awt.Color;

import factories.CircleFactory;
import points.CustomPoint;

public class Prac12 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("12th practice - Figures", 1000, 600);
        cw.setColor(Color.BLACK);

        // Lines
        cw.drawLine(50, 50, 150, 150);
        cw.drawLine(300, 100, 400, 100);
        cw.drawLine(700, 50, 600, 150);
        cw.drawLine(900, 100, 800, 100);

        // Circles
        cw.drawCircle(100, 450, 80);
        cw.drawCircle(100, 450, 55);
        cw.drawCircle(100, 450, 30);
        cw.drawCircle(100, 450, 5);

        // Rectangles
        cw.drawRectangle(350, 400, 550, 500);
        cw.drawRectangle(510, 470, 390, 430);

        // Ellipses
        cw.drawEllipse(800, 450, 10, 40);
        cw.drawEllipse(800, 450, 20, 60);
        cw.drawEllipse(800, 450, 30, 80);
        cw.drawEllipse(800, 450, 40, 100);

        cw.repaint();
    }
}
