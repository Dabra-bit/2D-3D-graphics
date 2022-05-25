import points.BasePoint3D;
import window.CustomWindow;
import helpers.Transformations;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Prac4 implements KeyListener {
    // Coords factors
    public final static double xF = 1.0;
    public final static double yF = 1.0;
    public final static double zF = 1.0;
    
    public CustomWindow cw;
    
    // Initial state
    public BasePoint3D v1;
    public BasePoint3D v2;
    public BasePoint3D v3;
    public BasePoint3D v4;
    public BasePoint3D v5;
    public BasePoint3D v6;
    public BasePoint3D v7;
    public BasePoint3D v8;

    // Moving state
    public BasePoint3D tmpv1;
    public BasePoint3D tmpv2;
    public BasePoint3D tmpv3;
    public BasePoint3D tmpv4;
    public BasePoint3D tmpv5;
    public BasePoint3D tmpv6;
    public BasePoint3D tmpv7;
    public BasePoint3D tmpv8;


    public Prac4() {
        cw = new CustomWindow("Practice 4 - Scaling", 800, 800);
        cw.setKeyListener(this);
        v1 = new BasePoint3D(200, 200, 0);
        v2 = new BasePoint3D(250, 200, 0);
        v3 = new BasePoint3D(200, 250, 0);
        v4 = new BasePoint3D(250, 250, 0);
        v5 = new BasePoint3D(200, 200, 50);
        v6 = new BasePoint3D(250, 200, 50);
        v7 = new BasePoint3D(200, 250, 50);
        v8 = new BasePoint3D(250, 250, 50);

        tmpv1 = new BasePoint3D(v1);
        tmpv2 = new BasePoint3D(v2);
        tmpv3 = new BasePoint3D(v3);
        tmpv4 = new BasePoint3D(v4);
        tmpv5 = new BasePoint3D(v5);
        tmpv6 = new BasePoint3D(v6);
        tmpv7 = new BasePoint3D(v7);
        tmpv8 = new BasePoint3D(v8);
    }

    public void drawCube() {
        cw.resetGraphics();

        cw.drawLine3D(tmpv1, tmpv2);
        cw.drawLine3D(tmpv1, tmpv3);
        cw.drawLine3D(tmpv1, tmpv5);
        cw.drawLine3D(tmpv4, tmpv3);
        cw.drawLine3D(tmpv4, tmpv8);
        cw.drawLine3D(tmpv4, tmpv2);
        cw.drawLine3D(tmpv7, tmpv5);
        cw.drawLine3D(tmpv7, tmpv3);
        cw.drawLine3D(tmpv7, tmpv8);
        cw.drawLine3D(tmpv6, tmpv5);
        cw.drawLine3D(tmpv6, tmpv2);
        cw.drawLine3D(tmpv6, tmpv8);

        cw.update(cw.getGraphics());
    }

    public static void main(String[] args) {
        Prac4 prac4 = new Prac4();
        prac4.drawCube();
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
        double tmpFactorX = xF;
        double tmpFactorY = yF;
        double tmpFactorZ = zF;

        if (key == KeyEvent.VK_LEFT) {
            tmpFactorX -= 0.1;
            tmpv1.setCoords(Transformations.scaling(tmpv1.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv2.setCoords(Transformations.scaling(tmpv2.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv3.setCoords(Transformations.scaling(tmpv3.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv4.setCoords(Transformations.scaling(tmpv4.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv5.setCoords(Transformations.scaling(tmpv5.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv6.setCoords(Transformations.scaling(tmpv6.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv7.setCoords(Transformations.scaling(tmpv7.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv8.setCoords(Transformations.scaling(tmpv8.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));

            drawCube();
        } else if (key == KeyEvent.VK_RIGHT) {
            tmpFactorX += 0.1;

            tmpv1.setCoords(Transformations.scaling(tmpv1.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv2.setCoords(Transformations.scaling(tmpv2.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv3.setCoords(Transformations.scaling(tmpv3.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv4.setCoords(Transformations.scaling(tmpv4.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv5.setCoords(Transformations.scaling(tmpv5.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv6.setCoords(Transformations.scaling(tmpv6.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv7.setCoords(Transformations.scaling(tmpv7.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv8.setCoords(Transformations.scaling(tmpv8.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));

            drawCube();
        } else if (key == KeyEvent.VK_UP) {
            tmpFactorY -= 0.1;

            tmpv1.setCoords(Transformations.scaling(tmpv1.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv2.setCoords(Transformations.scaling(tmpv2.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv3.setCoords(Transformations.scaling(tmpv3.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv4.setCoords(Transformations.scaling(tmpv4.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv5.setCoords(Transformations.scaling(tmpv5.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv6.setCoords(Transformations.scaling(tmpv6.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv7.setCoords(Transformations.scaling(tmpv7.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv8.setCoords(Transformations.scaling(tmpv8.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));

            drawCube();
        } else if (key == KeyEvent.VK_DOWN) {
            tmpFactorY += 0.1;

            tmpv1.setCoords(Transformations.scaling(tmpv1.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv2.setCoords(Transformations.scaling(tmpv2.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv3.setCoords(Transformations.scaling(tmpv3.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv4.setCoords(Transformations.scaling(tmpv4.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv5.setCoords(Transformations.scaling(tmpv5.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv6.setCoords(Transformations.scaling(tmpv6.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv7.setCoords(Transformations.scaling(tmpv7.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv8.setCoords(Transformations.scaling(tmpv8.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));

            drawCube();
        } else if (key == KeyEvent.VK_T) {
            tmpFactorZ += 0.1;

            tmpv1.setCoords(Transformations.scaling(tmpv1.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv2.setCoords(Transformations.scaling(tmpv2.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv3.setCoords(Transformations.scaling(tmpv3.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv4.setCoords(Transformations.scaling(tmpv4.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv5.setCoords(Transformations.scaling(tmpv5.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv6.setCoords(Transformations.scaling(tmpv6.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv7.setCoords(Transformations.scaling(tmpv7.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv8.setCoords(Transformations.scaling(tmpv8.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));

            drawCube();
        } else if (key == KeyEvent.VK_G) {
            tmpFactorZ -= 0.1;

            tmpv1.setCoords(Transformations.scaling(tmpv1.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv2.setCoords(Transformations.scaling(tmpv2.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv3.setCoords(Transformations.scaling(tmpv3.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv4.setCoords(Transformations.scaling(tmpv4.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv5.setCoords(Transformations.scaling(tmpv5.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv6.setCoords(Transformations.scaling(tmpv6.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv7.setCoords(Transformations.scaling(tmpv7.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));
            tmpv8.setCoords(Transformations.scaling(tmpv8.toRowVector(), tmpFactorX, tmpFactorY, tmpFactorZ));

            drawCube();
        }
        System.out.println();
    }
}
