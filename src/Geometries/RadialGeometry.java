package Geometries;

/*public abstract class RadialGeometry extends Geometry {

    protected double _radius;
    public RadialGeometry(){ this._radius=0.0;  }
    public RadialGeometry(double radius){

        this._radius=radius;
    }
    public double getRadius(){

        return this._radius;
    }
    public void setRadius(double radius){

        this._radius=radius;
    }

  *//*  public List<Point3D> FindIntersections(Ray ray){
        return null;
    }

    public Vector getNormal(Point3D point){return null;}*//*
}
*/


public abstract class RadialGeometry extends Geometry {

    protected double _radius;

    public RadialGeometry()              { this._radius = 0.0;    }
    public RadialGeometry(double radius) { this._radius = radius; }

    public double getRadius()              { return _radius;	    }
    public void   setRadius(double radius) { this._radius = radius; }

}
