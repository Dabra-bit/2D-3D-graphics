import points.BasePoint3D;
import window.CustomWindow;

import java.awt.event.KeyListener;

import helpers.Constants3D;
import helpers.Figure3D;

import java.awt.event.KeyEvent;

public class Prac4 implements KeyListener {

    public CustomWindow cw;
    public Figure3D cube;
    public BasePoint3D[] vertices;
    public BasePoint3D vanishingPoint;

    public Prac4() {
        cw = new CustomWindow("Practice 4 - Scaling", 800, 800);
        cw.setKeyListener(this);

        BasePoint3D[] vertices = {
            new BasePoint3D(50, 50, -25),
            new BasePoint3D(100, 50, -25),
            new BasePoint3D(50, 100, -25),
            new BasePoint3D(100, 100, -25),
            new BasePoint3D(50, 50, 25),
            new BasePoint3D(100, 50, 25),
            new BasePoint3D(50, 100, 25),
            new BasePoint3D(100, 100, 25)
        };

        BasePoint3D center = new BasePoint3D(75, 75, 0);

        int[][] edges = { {0, 1}, {0, 2}, {0, 4}, {3, 2}, {3, 7}, {3, 1},
            {6, 4}, {6, 2}, {6, 7}, {5, 4}, {5, 1}, {5, 7}
        };

        cube = new Figure3D(center, vertices, edges);
        this.vertices = cube.getVertices();

        vanishingPoint = new BasePoint3D(0.5, 0.5, 1);
    }

    public void drawCube() {
        cw.resetGraphics();

        cw.drawFigure3D(vertices, cube.getEdges(), Constants3D.PARALLEL_PROJ, vanishingPoint);

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

        double sx = 1.0;
        double sy = 1.0;
        double sz = 1.0;

        if (key == KeyEvent.VK_LEFT) {
            sx = 0.9;
        } else if (key == KeyEvent.VK_RIGHT) {
            sx = 1.1;
        } else if (key == KeyEvent.VK_UP) {
            sy = 0.9;
        } else if (key == KeyEvent.VK_DOWN) {
            sy = 1.1;
        } else if (key == KeyEvent.VK_S) {
            sz = 1.1;
        } else if (key == KeyEvent.VK_X) {
            sz = 0.9;
        }

        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
            case KeyEvent.VK_X:
                vertices = cube.scale(sx, sy, sz);
                drawCube();
        }
    }
}
