package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*

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
    @Override
    public Vector getNormal(Point3D point)  {
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

        double d = Math.sqrt((Math.pow(L.length(), 2) - Math.pow(Tm, 2)));

        if (d > this._radius) return intersections;

  if (d == this._radius) {
            Point3D P = new Point3D(P0);
            V.scale(Tm);
            P.add(V);
            intersections.add(P);
            return intersections;
        } else {


        double Th = Math.sqrt((Math.pow(this._radius, 2) - Math.pow(d, 2)));
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
        // System.out.println(intersections);
        return intersections;



    }


    @Override
    public String toString() {
        return "p "+ this._center +" : " +"r " +this._radius;
    }
}
*/

public class Sphere extends RadialGeometry{

    private Point3D _center;

    // ***************** Constructors ********************** //

    public Sphere(){
        super(0.0);
        _center = new Point3D();
    }

    public Sphere (Sphere sphere){
        super(sphere._radius);
        _center = sphere.getCenter();
    }

    public Sphere(double radius, Point3D center){
        super(radius);
        _center = new Point3D(center);
    }

    public Sphere(Map<String, String> attributes){

        String[] centerPoints = attributes
                .get("center" ).split("\\s+");

        _center = new Point3D(Double.valueOf(centerPoints[0]),
                Double.valueOf(centerPoints[1]),
                Double.valueOf(centerPoints[2]));

        _radius = Double.valueOf(attributes.get("radius"));
    }

    // ***************** Getters/Setters ********************** //

    public Point3D getCenter()            { return new Point3D(_center);         }
    public void setCenter(Point3D center) { this._center = new Point3D(_center); }

    // ***************** Operations ******************** //

    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoints= new ArrayList<Point3D>(2);

        Vector L = new Vector(ray.get_POO(), this.getCenter());
        double tm = L.dotProduct(ray.get_direction());
        double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));

        if (d > this.getRadius())
            return intersectionPoints;

        double th = Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(d, 2));

        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0){
            Vector V = ray.get_direction();
            V.scale(t1);
            Point3D P1 = ray.get_POO();
            P1.add(V);
            intersectionPoints.add(P1);
        }

        if (t2 >= 0){
            Vector V = ray.get_direction();
            V.scale(t2);
            Point3D P2 = ray.get_POO();
            P2.add(V);
            intersectionPoints.add(P2);
        }

        return intersectionPoints;

    }

    @Override
    public Vector getNormal(Point3D point) {

        Vector N = new Vector (_center, point);
        N.normalize();
        return N;

    }
}
