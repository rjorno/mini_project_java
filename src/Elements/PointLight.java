package Elements;

import Primitives.*;

import java.awt.*;

import static java.lang.Math.pow;

public class PointLight extends Light {

    private   Point3D _position;
    private double _Kc, _Kl, _Kq;

    // ***************** Constructors ********************** //
    public PointLight(Color color, Point3D position,
                      double kc, double kl, double kq){
        super(color);
        this._position=new Point3D(position);
        this._Kc=kc;
        this._Kl=kl;
        this._Kq=kq;
    }
    // ***************** Getters/Setters ********************** //
    @Override
    public Color getIntensity(Point3D point){

        int red=this._color.getRed();
        int green=this._color.getGreen();
        int blue=this._color.getBlue();
        double d= this._position.distance(point);

        double dilution=1/(_Kc*_Kl*d*_Kq*pow(d,2));

        return new Color((int)(red*dilution),(int)(green*dilution),(int)(blue*dilution));

    }
    @Override
    public Vector getL(Point3D point){
        return new Vector (_position, point);
        //
    }
}