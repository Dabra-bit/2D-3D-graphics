package project;

import points.CustomPoint;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class ProjectGraphics {

    public static void drawPixel(BufferedImage img, CustomPoint p, Color color) {
        int x = p.x(), y = p.y();
        if (x >= 0 && y >= 0 && x < img.getWidth() && y < img.getHeight())
            img.setRGB(x, y, color.getRGB());
    }

    public static void fillRectangle(BufferedImage img, CustomPoint p1, CustomPoint p2, Color color) {
        int x1 = p1.x(), y1 = p1.y();
        int x2 = p2.x(), y2 = p2.y();

        for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++)
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++)
                drawPixel(img, new CustomPoint(x, y), color);
    }

    public static void fillCircle(BufferedImage img, CustomPoint p, int r, Color color) {

        int x = p.x(), y = p.y();
        int X = 0;
        int Y = r;
        int delta = 2 * (1 - r);
        int error;

        while (Y >= 0) {

            for (int h = x - X; h <= x + X; h++) {
                drawPixel(img, new CustomPoint(h, y + Y), color);
                drawPixel(img, new CustomPoint(h, y - Y), color);
            }

            error = 2 * (delta + Y) - 1;
            if (delta < 0 && error <= 0) {
                delta += 2 * ++X + 1;
                continue;
            }

            error = 2 * (delta - X) - 1;
            if (delta > 0 && error > 0) {
                delta += 1 - 2 * --Y;
                continue;
            }

            delta += 2 * (++X - Y--);
        }
    }

    public static void drawCircle(BufferedImage img, CustomPoint p, int r, int thickness, Color color) {

        int x = p.x(), y = p.y();

        int X = 0;
        int Y = r;
        int delta = 2 * (1 - r);
        int error;

        while (Y >= X) {

            for (int w = -(int) Math.floor(thickness / 2f); w < (int) Math.ceil(thickness / 2f); w++)
                for (int h = -(int) Math.floor(thickness / 2f); h < (int) Math.ceil(thickness / 2f); h++) {
                    drawPixel(img, new CustomPoint(x + w + X, y + h + Y), color);
                    drawPixel(img, new CustomPoint(x + w - X, y + h + Y), color);
                    drawPixel(img, new CustomPoint(x + w + X, y + h - Y), color);
                    drawPixel(img, new CustomPoint(x + w - X, y + h - Y), color);
                    drawPixel(img, new CustomPoint(x + w + Y, y + h + X), color);
                    drawPixel(img, new CustomPoint(x + w - Y, y + h + X), color);
                    drawPixel(img, new CustomPoint(x + w + Y, y + h - X), color);
                    drawPixel(img, new CustomPoint(x + w - Y, y + h - X), color);
                }

            error = 2 * (delta + Y) - 1;
            if (delta < 0 && error <= 0) {
                delta += 2 * ++X + 1;
                continue;
            }

            error = 2 * (delta - X) - 1;
            if (delta > 0 && error > 0) {
                delta += 1 - 2 * --Y;
                continue;
            }

            delta += 2 * (++X - Y--);
        }
    }

    public static void drawLine(BufferedImage img, CustomPoint p1, CustomPoint p2, int thickness, Color color) {
        int x1 = p1.x(), y1 = p1.y();
        int x2 = p2.x(), y2 = p2.y();
        
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
        int err = (dx > dy ? dx : -dy) / 2, e2;

        while (true) {

            for (int x = -(int) Math.floor(thickness / 2f); x < (int) Math.ceil(thickness / 2f); x++)
                for (int y = -(int) Math.floor(thickness / 2f); y < (int) Math.ceil(thickness / 2f); y++)
                    drawPixel(img, new CustomPoint(x1 + x, y1 + y), color);
            if (x1 == x2 && y1 == y2)
                break;
            e2 = err;

            if (e2 > -dx) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dy) {
                err += dx;
                y1 += sy;
            }
        }
    }
    public static int enclose(int a, int b, int v) {
        return (v - b) % (b - a) + a + b;
    }
}
