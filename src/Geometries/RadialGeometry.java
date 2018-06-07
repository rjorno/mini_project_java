package Geometries;

import Primitives.Point3D;
import Primitives.Ray;

import java.util.List;

public class RadialGeometry implements Geometry {

    protected double _radius;
    public RadialGeometry(){

        this._radius=0.0;
    }
    public RadialGeometry(double radius){

        this._radius=radius;
    }
    public double getRadius(){

        return this._radius;
    }
    public void setRadius(double radius){

        this._radius=radius;
    }

    public List<Point3D> FindIntersections(Ray ray){
        return null;
    }
}
