import points.BasePoint3D;
import window.CustomWindow;

import javax.swing.SwingUtilities;

import helpers.Constants3D;
import helpers.Figure3D;

public class Prac7 {

    public CustomWindow cw;
    public Figure3D curve;
    public BasePoint3D[] vertices;
    public BasePoint3D vanishingPoint;

    public Prac7() {
        cw = new CustomWindow("Practice 7 - Rotating Curve", 800, 800);

        BasePoint3D center = new BasePoint3D(300, 300, 0);
        double t = 8 * Math.PI;
        int points = 100;
        double inc = t / (double) points;

        vertices = new BasePoint3D[points + 1];
        int[][] edges = new int[points][];
        
        double error = 0.01;
        int i = 0;
        for (; t >= error; t -= inc, i++) {
            double x = Math.cos(t) * 100 + center.x();
            double z = Math.sin(t) * 100 + center.z();
            double y = t * 5 + center.y();

            vertices[i] = new BasePoint3D(x, y, z);
            edges[i] = new int[] { i, i + 1 };
        }

        double x = Math.cos(t) * 100 + center.x();
        double z = Math.sin(t) * 100 + center.z();
        double y = t * 5 + center.y();

        vertices[i] = new BasePoint3D(x, y, z);

        curve = new Figure3D(center, vertices, edges);
        vanishingPoint = new BasePoint3D(0.5, 0.5, 1);
    }

    public void drawCurve() {
        cw.resetGraphics();

        cw.drawFigure3D(vertices, curve.getEdges(), Constants3D.PARALLEL_PROJ, vanishingPoint);

        cw.update(cw.getGraphics());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Prac7 prac7 = new Prac7();
            prac7.drawCurve();

            double alpha = 0;
            double beta = 1;
            double gamma = 0;

            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                prac7.vertices = prac7.curve.rotate(alpha, beta, gamma);
                prac7.drawCurve();
            }
        });
    }
}
