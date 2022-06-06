package helpers;

import points.BasePoint3D;

public class Figure3D {
    private BasePoint3D[] vertices;
    private int[][] edges;
    private BasePoint3D center;
    
    // Angles
    private double alpha;
    private double beta;
    private double gamma;

    // Translations
    private int tx;
    private int ty;
    private int tz;

    
    public Figure3D(BasePoint3D center) {
        // Figure center
        this.center = center;
        
        // Angles
        this.alpha = 0;
        this.beta = 0;
        this.gamma = 0;

        // Translations
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
    }

    public Figure3D(BasePoint3D center, BasePoint3D[] vertices, int[][] edges) {
        this(center);
        this.vertices = vertices;
        this.edges = edges;
    }

    public void setVertices(BasePoint3D[] vertices) {
        this.vertices = vertices;
    }

    public void setEdges(int[][] edges) {
        this.edges = edges;
    }

    public BasePoint3D[] getVertices() {
        return vertices;
    }

    public int[][] getEdges() {
        return edges;
    }

    public BasePoint3D[] translate(int tx, int ty, int tz) {
        this.tx += tx;
        this.ty += ty;
        this.tz += tz;

        BasePoint3D[] transformed = new BasePoint3D[vertices.length];
        int i = 0;

        for(BasePoint3D p : vertices) {
            BasePoint3D tmp = BasePoint3D.translate(p, this.tx, this.ty, this.tz);
            transformed[i++] = tmp;
        }

        return transformed;
    }

    public BasePoint3D[] scale(double sx, double sy, double sz) {

        BasePoint3D[] transformed = new BasePoint3D[vertices.length];
        int i = 0;

        for(BasePoint3D p : vertices) {
            BasePoint3D tmp = BasePoint3D.scale(p, sx, sy, sz);
            transformed[i++] = tmp;
        }

        vertices = transformed;

        return transformed;
    }

    public BasePoint3D[] rotate(double alpha, double beta, double gamma) {
        this.alpha += alpha;
        this.beta += beta;
        this.gamma += gamma;

        BasePoint3D[] transformed = new BasePoint3D[vertices.length];
        int i = 0;

        for(BasePoint3D p : vertices) {
            BasePoint3D tmp = BasePoint3D.translate(p, -center.x(), -center.y(), -center.z());
            tmp = BasePoint3D.rotate(tmp, this.alpha, this.beta, this.gamma);
            tmp = BasePoint3D.translate(tmp, center.x(), center.y(), center.z());
            transformed[i++] = tmp;
        }

        return transformed;
    }
}
