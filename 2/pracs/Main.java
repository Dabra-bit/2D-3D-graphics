import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("Practica 1 - Pixel", 600, 600);
        cw.drawLine(100, 100, 100, 200, Color.RED);
    }
}
