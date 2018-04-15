package Geometris;

public class RadialGeometry {

    protected double _radius;
    public RadialGeometry(){

        this._radius=0;
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
}
