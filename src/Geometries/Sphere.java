package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sphere extends RadialGeometry {

    private Point3D _center;

    // ***************** Constructors ********************** //
    public Sphere() {
        super(0.0);
        _center = new Point3D();
    }

    public Sphere(Sphere sphere) {
        super(sphere._radius);
        _center = new Point3D(sphere._center);
    }

    public Sphere(double radius, Point3D center) {
        super(radius);
        _center = new Point3D(center);
    }

    public Sphere(Map<String, String> attributes) {
        String[] centerPoints = attributes
                .get("center").split("\\s+");

        _center = new Point3D(Double.valueOf(centerPoints[0]),
                Double.valueOf(centerPoints[1]),
                Double.valueOf(centerPoints[2]));

        _radius = Double.valueOf(attributes.get("radius"));
    }

    // ***************** Getters/Setters ********************** //
    public Point3D getCenter() {
        return new Point3D(_center);
    }

    public void setCenter(Point3D center) {
        this._center = new Point3D(center);
    }
    // ***************** Operations ******************** //

    public Vector getNormal(Point3D point) throws Exception {
        Vector v = new Vector(_center, point);
        v.normalize();
        return v;
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersections = new ArrayList<Point3D>(2);

        Point3D P0 = new Point3D(ray.get_POO());
        Vector V = new Vector(ray.get_direction());

        Vector L = new Vector(P0, this._center);

        double Tm = L.dotProduct(V);

        double d = Math.pow((Math.pow(L.length(), 2) - Math.pow(Tm, 2)), 0.5);

        if (d > this._radius) return intersections;

        if (d == this._radius) {
            Point3D P = new Point3D(P0);
            V.scale(Tm);
            P.add(V);
            intersections.add(P);
            return intersections;
        } else {

            double Th = Math.pow((Math.pow(this._radius, 2) - Math.pow(d, 2)), 0.5);
            double t1 = Tm - Th;
            double t2 = Tm + Th;


            if (t1 >= 0) {
                Vector v1 = new Vector(V);
                v1.scale(t1);
                Point3D p1 = new Point3D(P0);
                p1.add(v1);
                intersections.add(p1);
            }
            if (t2 >= 0) {
                Vector v2 = new Vector(V);
                v2.scale(t2);
                Point3D p2 = new Point3D(P0);
                p2.add(v2);
                intersections.add(p2);
            }
            System.out.println(intersections);
            return intersections;

        }
    }
}
