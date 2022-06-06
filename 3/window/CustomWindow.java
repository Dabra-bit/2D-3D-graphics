package window;

import java.awt.Color;
import javax.swing.JPanel;

import circles.CustomCircle;
import factories.CircleFactory;
import factories.LinesFactory;
import graphics.CustomGraphics;
import helpers.Constants3D;

import javax.swing.JFrame;
import java.awt.Dimension;

import points.BasePoint3D;
import points.CustomPoint;

import java.awt.event.KeyListener;

public class CustomWindow extends JFrame {

    // Custom Graphics
    protected CustomGraphics customGraphics;

    public CustomWindow(String title, int width, int height) {
        super(title);
        this.paint(this.getGraphics());

        customGraphics = new CustomGraphics();
        this.configureFrame(new Dimension(width, height),
                customGraphics);
    }

    public void setKeyListener(KeyListener listener) {
        addKeyListener(listener);
    }

    public void resetGraphics() {
        customGraphics = new CustomGraphics();
        Dimension d = getSize();
        this.add(customGraphics);
        this.setContentPane(customGraphics);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(d);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void configureFrame(Dimension dimension, JPanel panel) {
        this.add(panel);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void setColor(Color color) {
        this.customGraphics.setColor(color);
    }

    public void drawPixel(int x, int y) {
        this.customGraphics.drawPixel(new CustomPoint(x, y));
    }

    public void drawLine(int x1, int y1, int x2, int y2, int lineType, int thick, boolean[] mask) {
        this.customGraphics.drawLine(
                new CustomPoint(x1, y1),
                new CustomPoint(x2, y2),
                lineType,
                thick,
                mask);
    }

    public void drawLine(int x1, int y1, int x2, int y2, int lineType, int thick) {
        this.customGraphics.drawLine(
                new CustomPoint(x1, y1),
                new CustomPoint(x2, y2),
                lineType,
                thick,
                LinesFactory.DEFAULT_MASK);
    }

    public void drawLine(int x1, int y1, int x2, int y2, int lineType) {
        this.customGraphics.drawLine(
                new CustomPoint(x1, y1),
                new CustomPoint(x2, y2),
                lineType,
                1,
                LinesFactory.DEFAULT_MASK);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        this.drawLine(x1, y1, x2, y2, LinesFactory.DEFAULT_LINE, 1, LinesFactory.DEFAULT_MASK);
    }

    public void drawFigure3D(BasePoint3D[] vertices, int[][] edges, int projectionType, BasePoint3D vPoint3d) {
        for(int[] edge : edges) {
            BasePoint3D p1 = vertices[edge[0]];
            BasePoint3D p2 = vertices[edge[1]];

            CustomPoint _p1 = BasePoint3D.to2D(p1, projectionType, vPoint3d);
            CustomPoint _p2 = BasePoint3D.to2D(p2, projectionType, vPoint3d);

            this.customGraphics.drawLine(_p1, _p2, LinesFactory.DEFAULT_LINE, 1, LinesFactory.DEFAULT_MASK);
        }
    }

    public void drawLine3D(BasePoint3D p1, BasePoint3D p2, int projectionType, BasePoint3D vPoint3d) {
        // Line3D line = new Line3D(p1, p2, projectionType, vPoint3d);
        CustomPoint _p1 = BasePoint3D.to2D(p1, projectionType, vPoint3d);
        CustomPoint _p2 = BasePoint3D.to2D(p2, projectionType, vPoint3d);

        this.customGraphics.drawLine(_p1, _p2, LinesFactory.DEFAULT_LINE, 1, LinesFactory.DEFAULT_MASK);
    }

    public void drawLine3D(BasePoint3D p1, BasePoint3D p2) {
        drawLine3D(p1, p2, Constants3D.DEF_PROJECTION, Constants3D.DEF_PROJ_P);
    }

    public void drawCircle(int x, int y, int radius, int circleType, int thick, boolean[] mask) {
        this.customGraphics.drawCircle(
                new CustomPoint(x, y),
                radius,
                circleType,
                thick,
                mask);
    }

    public void drawCircle(int x, int y, int radius, int thick, boolean[] mask) {
        this.customGraphics.drawCircle(
                new CustomPoint(x, y),
                radius,
                CircleFactory.DEFAULT_CIRCLE,
                thick,
                mask);
    }

    public void drawCircle(int x, int y, int radius, boolean[] mask) {
        this.drawCircle(x, y, radius, CircleFactory.DEFAULT_CIRCLE, CustomCircle.DEFAULT_THICKNESS, mask);
    }

    public void drawCircle(int x, int y, int radius, int thick) {
        this.drawCircle(x, y, radius, CircleFactory.DEFAULT_CIRCLE, thick, CustomCircle.DEFAULT_MASK);
    }

    public void drawCircle(int x, int y, int radius) {
        this.drawCircle(x, y, radius, CircleFactory.DEFAULT_CIRCLE, CustomCircle.DEFAULT_THICKNESS,
                CustomCircle.DEFAULT_MASK);
    }

    public void drawEllipse(int x, int y, int yRadius, int xRadius) {
        this.customGraphics.drawEllipse(
                new CustomPoint(x, y),
                yRadius,
                xRadius);
    }

    public void drawRectangle(int x1, int y1, int x2, int y2) {
        this.customGraphics.drawRectangle(
                new CustomPoint(x1, y1),
                new CustomPoint(x2, y2));
    }
}
