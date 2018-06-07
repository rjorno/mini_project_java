package Elements;

import java.awt.*;

public class AmbientLight extends Light {
    private final double _Ka = 0.7;

    // ***************** Constructors ********************** //
    public AmbientLight(){
        super (new Color(255,255,255));
    }
    public AmbientLight(AmbientLight aLight){

        super(aLight._color);
    }
    //
    public AmbientLight(int r, int g, int b){

        super(new Color(r,g,b));
    }
    //public AmbientLight(Map<String, String> attributes);
    // ***************** Getters/Setters ********************** //
    public Color getColor(){
        return _color;
    }
    public void setColor(Color color) {
        this._color=color;
    }
    public double getKa(){
        return _Ka;
    }
    @Override
    public Color getIntensity()
    {
        return new Color(((int)(this._color.getRed()*this._Ka)),
                ((int)(this._color.getGreen()*this._Ka)),
                ((int)(this._color.getBlue()*this._Ka)));


    }
}
