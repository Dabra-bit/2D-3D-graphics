import java.awt.Color;

import factories.LinesFactory;

public class Main {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("Practica 1 - Pixel", 600, 600);
        cw.setColor(Color.RED);
        cw.drawLine(30, 20, 40, 36, LinesFactory.BRESENHAM_LINE);
    }
}
