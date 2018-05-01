package Geometris;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;
import java.util.Map;

public class Sphere extends RadialGeometry {

    private Point3D _center;
    // ***************** Constructors ********************** //
    public Sphere(){
        super(0.0);
        _center=new Point3D();
    }
    public Sphere (Sphere sphere){
        super(sphere._radius);
        _center=new Point3D(sphere._center);
    }
    public Sphere(double radius, Point3D center){
        super(radius);
        _center=new Point3D(center);
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
    public Point3D getCenter(){
        return new Point3D(_center);
    }
    public void setCenter(Point3D center){
     this._center=new Point3D(center);
    }
    // ***************** Operations ******************** //

    public Vector getNormal(Point3D point) throws Exception {
        Vector v =  new Vector(_center,point);
        v.normalize();
        return v;
    }
    @Override
    public List<Point3D> FindIntersections(Ray ray) throws Exception {
        return null;
    }
}
