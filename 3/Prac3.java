import points.BasePoint3D;
import window.CustomWindow;
import helpers.Transformations;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Prac3 implements KeyListener {

    public CustomWindow cw;
    public BasePoint3D v1;
    public BasePoint3D v2;
    public BasePoint3D v3;
    public BasePoint3D v4;
    public BasePoint3D v5;
    public BasePoint3D v6;
    public BasePoint3D v7;
    public BasePoint3D v8;

    public Prac3() {
        cw = new CustomWindow("Practice 3 - Translation", 800, 800);
        cw.setKeyListener(this);
        v1 = new BasePoint3D(50, 50, 0);
        v2 = new BasePoint3D(100, 50, 0);
        v3 = new BasePoint3D(50, 100, 0);
        v4 = new BasePoint3D(100, 100, 0);
        v5 = new BasePoint3D(50, 50, 50);
        v6 = new BasePoint3D(100, 50, 50);
        v7 = new BasePoint3D(50, 100, 50);
        v8 = new BasePoint3D(100, 100, 50);
    }

    public void drawCube() {
        cw.resetGraphics();

        cw.drawLine3D(v1, v2);
        cw.drawLine3D(v1, v3);
        cw.drawLine3D(v1, v5);
        cw.drawLine3D(v4, v3);
        cw.drawLine3D(v4, v8);
        cw.drawLine3D(v4, v2);
        cw.drawLine3D(v7, v5);
        cw.drawLine3D(v7, v3);
        cw.drawLine3D(v7, v8);
        cw.drawLine3D(v6, v5);
        cw.drawLine3D(v6, v2);
        cw.drawLine3D(v6, v8);

        cw.update(cw.getGraphics());
    }

    public static void main(String[] args) {
        Prac3 prac3 = new Prac3();
        prac3.drawCube();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // Keyboard code for the pressed key.

        if (key == KeyEvent.VK_LEFT) {
            v1.setCoords(Transformations.translation(v1.toRowVector(), -1, 0, 0));
            v2.setCoords(Transformations.translation(v2.toRowVector(), -1, 0, 0));
            v3.setCoords(Transformations.translation(v3.toRowVector(), -1, 0, 0));
            v4.setCoords(Transformations.translation(v4.toRowVector(), -1, 0, 0));
            v5.setCoords(Transformations.translation(v5.toRowVector(), -1, 0, 0));
            v6.setCoords(Transformations.translation(v6.toRowVector(), -1, 0, 0));
            v7.setCoords(Transformations.translation(v7.toRowVector(), -1, 0, 0));
            v8.setCoords(Transformations.translation(v8.toRowVector(), -1, 0, 0));

            drawCube();
        } else if (key == KeyEvent.VK_RIGHT) {
            v1.setCoords(Transformations.translation(v1.toRowVector(), 1, 0, 0));
            v2.setCoords(Transformations.translation(v2.toRowVector(), 1, 0, 0));
            v3.setCoords(Transformations.translation(v3.toRowVector(), 1, 0, 0));
            v4.setCoords(Transformations.translation(v4.toRowVector(), 1, 0, 0));
            v5.setCoords(Transformations.translation(v5.toRowVector(), 1, 0, 0));
            v6.setCoords(Transformations.translation(v6.toRowVector(), 1, 0, 0));
            v7.setCoords(Transformations.translation(v7.toRowVector(), 1, 0, 0));
            v8.setCoords(Transformations.translation(v8.toRowVector(), 1, 0, 0));

            drawCube();
        } else if (key == KeyEvent.VK_UP) {
            v1.setCoords(Transformations.translation(v1.toRowVector(), 0, -1, 0));
            v2.setCoords(Transformations.translation(v2.toRowVector(), 0, -1, 0));
            v3.setCoords(Transformations.translation(v3.toRowVector(), 0, -1, 0));
            v4.setCoords(Transformations.translation(v4.toRowVector(), 0, -1, 0));
            v5.setCoords(Transformations.translation(v5.toRowVector(), 0, -1, 0));
            v6.setCoords(Transformations.translation(v6.toRowVector(), 0, -1, 0));
            v7.setCoords(Transformations.translation(v7.toRowVector(), 0, -1, 0));
            v8.setCoords(Transformations.translation(v8.toRowVector(), 0, -1, 0));

            drawCube();
        } else if (key == KeyEvent.VK_DOWN) {
            v1.setCoords(Transformations.translation(v1.toRowVector(), 0, 1, 0));
            v2.setCoords(Transformations.translation(v2.toRowVector(), 0, 1, 0));
            v3.setCoords(Transformations.translation(v3.toRowVector(), 0, 1, 0));
            v4.setCoords(Transformations.translation(v4.toRowVector(), 0, 1, 0));
            v5.setCoords(Transformations.translation(v5.toRowVector(), 0, 1, 0));
            v6.setCoords(Transformations.translation(v6.toRowVector(), 0, 1, 0));
            v7.setCoords(Transformations.translation(v7.toRowVector(), 0, 1, 0));
            v8.setCoords(Transformations.translation(v8.toRowVector(), 0, 1, 0));

            drawCube();
        } else if (key == KeyEvent.VK_T) {
            v1.setCoords(Transformations.translation(v1.toRowVector(), 0, 0, 1));
            v2.setCoords(Transformations.translation(v2.toRowVector(), 0, 0, 1));
            v3.setCoords(Transformations.translation(v3.toRowVector(), 0, 0, 1));
            v4.setCoords(Transformations.translation(v4.toRowVector(), 0, 0, 1));
            v5.setCoords(Transformations.translation(v5.toRowVector(), 0, 0, 1));
            v6.setCoords(Transformations.translation(v6.toRowVector(), 0, 0, 1));
            v7.setCoords(Transformations.translation(v7.toRowVector(), 0, 0, 1));
            v8.setCoords(Transformations.translation(v8.toRowVector(), 0, 0, 1));

            drawCube();
        } else if (key == KeyEvent.VK_G) {
            v1.setCoords(Transformations.translation(v1.toRowVector(), 0, 0, -1));
            v2.setCoords(Transformations.translation(v2.toRowVector(), 0, 0, -1));
            v3.setCoords(Transformations.translation(v3.toRowVector(), 0, 0, -1));
            v4.setCoords(Transformations.translation(v4.toRowVector(), 0, 0, -1));
            v5.setCoords(Transformations.translation(v5.toRowVector(), 0, 0, -1));
            v6.setCoords(Transformations.translation(v6.toRowVector(), 0, 0, -1));
            v7.setCoords(Transformations.translation(v7.toRowVector(), 0, 0, -1));
            v8.setCoords(Transformations.translation(v8.toRowVector(), 0, 0, -1));

            drawCube();
        }
    }
}
