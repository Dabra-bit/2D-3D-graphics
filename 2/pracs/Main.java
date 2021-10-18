import java.awt.Color;

import factories.CircleFactory;
import factories.LinesFactory;

public class Main {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("7th prac - Ellipse", 600, 600);
        cw.setColor(Color.RED);
        cw.drawRectangle(100, 100, 50, 70);
    }
}
