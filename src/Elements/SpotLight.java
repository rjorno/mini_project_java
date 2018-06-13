package Elements;

import Primitives.*;

import java.awt.*;

public class SpotLight extends  PointLight {

    private Vector _direction;
    // ***************** Constructor ********************** //
    public SpotLight(Color color, Point3D position, Vector direction,
                     double kc, double kl, double kq){
        super(color,position,kc,kl,kq);
        this._direction=new Vector(direction);
        this._direction.normalize();
    }

    // ***************** Getters/Setters ********************** //
    @Override
    public Color getIntensity(Point3D point) {

        Color color = super.getIntensity(point);
        Vector l = super.getL(point);
        l.normalize();
        this._direction.normalize();
        double angle = Math.abs( l.dotProduct(this._direction));
        if (angle > 1) angle = 1; // doesn't allow light magnification

        return new Color((int) (color.getRed() * angle),
                (int) (color.getGreen() * angle),
                (int) (color.getBlue() * angle));
    }

}
