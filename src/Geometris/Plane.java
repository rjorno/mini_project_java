package Geometris;
import Primitives.*;

import java.util.ArrayList;
import java.util.List;

public class Plane implements Geometry {

    private Vector _normal;
    private Point3D _Q;

    public Plane(){

      this._normal=new Vector();
      this._Q=new Point3D();

    }
    public Plane (Plane plane){
        this._normal=new Vector(plane._normal);
        this._Q=new Point3D(plane._Q);
    }
    public Plane (Vector normal, Point3D q) throws Exception {
        this._normal=new Vector(normal);
        this._normal.normalize();
        this._Q=new Point3D(q);

    }

    public Vector getNormal(Point3D point){

        return new Vector(_normal);
    }
    public Point3D getQ(){

        return new Point3D(_Q);
    }
    public void setNormal(Vector normal){

        this._normal=normal;
    }
    public void setQ(Point3D d){

        this._Q=d;
    }
    public List<Point3D> FindIntersections(Ray ray){
        List<Point3D>intersectionPoint=new ArrayList<Point3D>(1);
        Point3D p0=ray.get_POO();
        Point3D q0=getQ();
        Vector v=new Vector(q0,p0);
        Vector N=getNormal(null);
        Vector D=ray.get_direction();
        double t=(N.dotProduct(v)*-1)/N.dotProduct(D);
        if (t==0)
        {
            D.scale(t);
            p0.add(D);
            intersectionPoint.add(p0);
        }
        return intersectionPoint;
    }

}
