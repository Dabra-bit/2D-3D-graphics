import points.BasePoint3D;
import window.CustomWindow;

public class Prac1 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("Practice 1 - Parallel projection", 800, 800);

        BasePoint3D v1 = new BasePoint3D(50, 50, 0);
        BasePoint3D v2 = new BasePoint3D(100, 50, 0);
        BasePoint3D v3 = new BasePoint3D(50, 100, 0);
        BasePoint3D v4 = new BasePoint3D(100, 100, 0);
        BasePoint3D v5 = new BasePoint3D(50, 50, 50);
        BasePoint3D v6 = new BasePoint3D(100, 50, 50);
        BasePoint3D v7 = new BasePoint3D(50, 100, 50);
        BasePoint3D v8 = new BasePoint3D(100, 100, 50);

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

        cw.repaint();
    }
}
