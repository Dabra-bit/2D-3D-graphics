import points.BasePoint3D;
import window.CustomWindow;
import helpers.Transformations;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Prac5 implements KeyListener {

    public CustomWindow cw;
    public BasePoint3D v1;
    public BasePoint3D v2;
    public BasePoint3D v3;
    public BasePoint3D v4;
    public BasePoint3D v5;
    public BasePoint3D v6;
    public BasePoint3D v7;
    public BasePoint3D v8;

    public Prac5() {
        cw = new CustomWindow("Practice 5 - Rotation", 800, 800);
        cw.setKeyListener(this);
        v1 = new BasePoint3D(200, 200, 0);
        v2 = new BasePoint3D(250, 200, 0);
        v3 = new BasePoint3D(200, 250, 0);
        v4 = new BasePoint3D(250, 250, 0);
        v5 = new BasePoint3D(200, 200, 50);
        v6 = new BasePoint3D(250, 200, 50);
        v7 = new BasePoint3D(200, 250, 50);
        v8 = new BasePoint3D(250, 250, 50);
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
        Prac5 prac5 = new Prac5();
        prac5.drawCube();
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
            v1.setCoords(Transformations.rotation(v1.toRowVector(), Transformations.ROTATION_X, 0.1));
            v2.setCoords(Transformations.rotation(v2.toRowVector(), Transformations.ROTATION_X, 0.1));
            v3.setCoords(Transformations.rotation(v3.toRowVector(), Transformations.ROTATION_X, 0.1));
            v4.setCoords(Transformations.rotation(v4.toRowVector(), Transformations.ROTATION_X, 0.1));
            v5.setCoords(Transformations.rotation(v5.toRowVector(), Transformations.ROTATION_X, 0.1));
            v6.setCoords(Transformations.rotation(v6.toRowVector(), Transformations.ROTATION_X, 0.1));
            v7.setCoords(Transformations.rotation(v7.toRowVector(), Transformations.ROTATION_X, 0.1));
            v8.setCoords(Transformations.rotation(v8.toRowVector(), Transformations.ROTATION_X, 0.1));

            drawCube();
        } else if (key == KeyEvent.VK_RIGHT) {
            v1.setCoords(Transformations.rotation(v1.toRowVector(), Transformations.ROTATION_X, -0.1));
            v2.setCoords(Transformations.rotation(v2.toRowVector(), Transformations.ROTATION_X, -0.1));
            v3.setCoords(Transformations.rotation(v3.toRowVector(), Transformations.ROTATION_X, -0.1));
            v4.setCoords(Transformations.rotation(v4.toRowVector(), Transformations.ROTATION_X, -0.1));
            v5.setCoords(Transformations.rotation(v5.toRowVector(), Transformations.ROTATION_X, -0.1));
            v6.setCoords(Transformations.rotation(v6.toRowVector(), Transformations.ROTATION_X, -0.1));
            v7.setCoords(Transformations.rotation(v7.toRowVector(), Transformations.ROTATION_X, -0.1));
            v8.setCoords(Transformations.rotation(v8.toRowVector(), Transformations.ROTATION_X, -0.1));

            drawCube();
        } else if (key == KeyEvent.VK_UP) {
            v1.setCoords(Transformations.rotation(v1.toRowVector(), Transformations.ROTATION_Y, 0.1));
            v2.setCoords(Transformations.rotation(v2.toRowVector(), Transformations.ROTATION_Y, 0.1));
            v3.setCoords(Transformations.rotation(v3.toRowVector(), Transformations.ROTATION_Y, 0.1));
            v4.setCoords(Transformations.rotation(v4.toRowVector(), Transformations.ROTATION_Y, 0.1));
            v5.setCoords(Transformations.rotation(v5.toRowVector(), Transformations.ROTATION_Y, 0.1));
            v6.setCoords(Transformations.rotation(v6.toRowVector(), Transformations.ROTATION_Y, 0.1));
            v7.setCoords(Transformations.rotation(v7.toRowVector(), Transformations.ROTATION_Y, 0.1));
            v8.setCoords(Transformations.rotation(v8.toRowVector(), Transformations.ROTATION_Y, 0.1));

            drawCube();
        } else if (key == KeyEvent.VK_DOWN) {
            v1.setCoords(Transformations.rotation(v1.toRowVector(), Transformations.ROTATION_Y, -0.1));
            v2.setCoords(Transformations.rotation(v2.toRowVector(), Transformations.ROTATION_Y, -0.1));
            v3.setCoords(Transformations.rotation(v3.toRowVector(), Transformations.ROTATION_Y, -0.1));
            v4.setCoords(Transformations.rotation(v4.toRowVector(), Transformations.ROTATION_Y, -0.1));
            v5.setCoords(Transformations.rotation(v5.toRowVector(), Transformations.ROTATION_Y, -0.1));
            v6.setCoords(Transformations.rotation(v6.toRowVector(), Transformations.ROTATION_Y, -0.1));
            v7.setCoords(Transformations.rotation(v7.toRowVector(), Transformations.ROTATION_Y, -0.1));
            v8.setCoords(Transformations.rotation(v8.toRowVector(), Transformations.ROTATION_Y, -0.1));

            drawCube();
        } else if (key == KeyEvent.VK_T) {
            v1.setCoords(Transformations.rotation(v1.toRowVector(), Transformations.ROTATION_Z, 0.1));
            v2.setCoords(Transformations.rotation(v2.toRowVector(), Transformations.ROTATION_Z, 0.1));
            v3.setCoords(Transformations.rotation(v3.toRowVector(), Transformations.ROTATION_Z, 0.1));
            v4.setCoords(Transformations.rotation(v4.toRowVector(), Transformations.ROTATION_Z, 0.1));
            v5.setCoords(Transformations.rotation(v5.toRowVector(), Transformations.ROTATION_Z, 0.1));
            v6.setCoords(Transformations.rotation(v6.toRowVector(), Transformations.ROTATION_Z, 0.1));
            v7.setCoords(Transformations.rotation(v7.toRowVector(), Transformations.ROTATION_Z, 0.1));
            v8.setCoords(Transformations.rotation(v8.toRowVector(), Transformations.ROTATION_Z, 0.1));

            drawCube();
        } else if (key == KeyEvent.VK_G) {
            v1.setCoords(Transformations.rotation(v1.toRowVector(), Transformations.ROTATION_Z, -0.1));
            v2.setCoords(Transformations.rotation(v2.toRowVector(), Transformations.ROTATION_Z, -0.1));
            v3.setCoords(Transformations.rotation(v3.toRowVector(), Transformations.ROTATION_Z, -0.1));
            v4.setCoords(Transformations.rotation(v4.toRowVector(), Transformations.ROTATION_Z, -0.1));
            v5.setCoords(Transformations.rotation(v5.toRowVector(), Transformations.ROTATION_Z, -0.1));
            v6.setCoords(Transformations.rotation(v6.toRowVector(), Transformations.ROTATION_Z, -0.1));
            v7.setCoords(Transformations.rotation(v7.toRowVector(), Transformations.ROTATION_Z, -0.1));
            v8.setCoords(Transformations.rotation(v8.toRowVector(), Transformations.ROTATION_Z, -0.1));

            drawCube();
        }
    }
}
