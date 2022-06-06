import points.BasePoint3D;
import window.CustomWindow;

import javax.swing.SwingUtilities;

import helpers.Constants3D;
import helpers.Figure3D;

public class Prac6 {

    public CustomWindow cw;
    public Figure3D cube;
    public BasePoint3D[] vertices;
    public BasePoint3D vanishingPoint;

    public Prac6() {
        cw = new CustomWindow("Practice 6 - Automated Rotation", 800, 800);

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
        SwingUtilities.invokeLater(() -> {
            Prac6 prac6 = new Prac6();
            prac6.drawCube();

            double alpha = 1;
            double beta = 2;
            double gamma = 3;

            while(true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    prac6.vertices = prac6.cube.rotate(alpha, beta, gamma);
                    prac6.drawCube();
            }       
        });
    }
}
