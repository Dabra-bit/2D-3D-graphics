import points.BasePoint3D;
import window.CustomWindow;

import java.awt.event.KeyListener;

import helpers.Constants3D;
import helpers.Figure3D;

import java.awt.event.KeyEvent;

public class Prac3 implements KeyListener {

    public CustomWindow cw;
    public Figure3D cube;
    public BasePoint3D[] vertices;
    public BasePoint3D vanishingPoint;

    public Prac3() {
        cw = new CustomWindow("Practice 3 - Translation", 800, 800);
        cw.setKeyListener(this);

        BasePoint3D[] vertices = {
            new BasePoint3D(200, 200, -100),
            new BasePoint3D(400, 200, -100),
            new BasePoint3D(200, 400, -100),
            new BasePoint3D(400, 400, -100),
            new BasePoint3D(200, 200, 100),
            new BasePoint3D(400, 200, 100),
            new BasePoint3D(200, 400, 100),
            new BasePoint3D(400, 400, 100)
        };

        BasePoint3D center = new BasePoint3D(300, 300, 0);

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

        int tx = 0;
        int ty = 0;
        int tz = 0;

        if (key == KeyEvent.VK_LEFT) {
            tx = -2;
        } else if (key == KeyEvent.VK_RIGHT) {
            tx = 2;
        } else if (key == KeyEvent.VK_UP) {
            ty = -2;
        } else if (key == KeyEvent.VK_DOWN) {
            ty = 2;
        } else if (key == KeyEvent.VK_T) {
            tz = 2;
        } else if (key == KeyEvent.VK_G) {
            tz = -2;
        }

        switch (key) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_T:
            case KeyEvent.VK_G:
                vertices = cube.translate(tx, ty, tz);
                drawCube();
        }
    }
}
