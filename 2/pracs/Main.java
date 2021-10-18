import java.awt.Color;

import factories.CircleFactory;
import factories.LinesFactory;

public class Main {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("Practica 6 - Polar coords circle", 600, 600);
        cw.setColor(Color.RED);
        cw.drawCircle(100, 100, 50, CircleFactory.POLAR_COORDS_CIRCLE);
    }
}
