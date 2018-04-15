package Geometris;
import Primitives.*;

import java.util.List;

public class Plane {

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

        return null;
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
    return null;
    }

}
