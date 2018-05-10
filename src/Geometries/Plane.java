package Geometries;
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
    public Plane (Vector normal, Point3D q) {
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
        Point3D P=new Point3D();
        Point3D P0=ray.get_POO();
        Vector V=ray.get_direction();

        Point3D Q0=this.getQ();
        Vector N=this.getNormal(null);


        Vector vector=new Vector(Q0,P0);
        double t=(N.dotProduct(vector)*-1)/N.dotProduct(V);

        V.scale(t);
        P.add(V);


        vector.add(V);
        if (N.dotProduct(vector)==0)
        {
            intersectionPoint.add(P);
        }
        return intersectionPoint;
    }

}
