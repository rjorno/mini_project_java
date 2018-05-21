package Elements;

import java.awt.*;

public class AmbientLight {
    private final double _Ka = 0.1;
    private Color _color;

    // ***************** Constructors ********************** //
    public AmbientLight(){

    }
    public AmbientLight(AmbientLight aLight){
        this._color=new Color(1, 1, 1);
    }
    public AmbientLight(int r, int g, int b){
        this._color=new Color(r,g,b);
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
    public Color getIntensity()
    {
        return new Color(((int)(this._color.getRed()*this._Ka)),
                ((int)(this._color.getGreen()*this._Ka)),
                ((int)(this._color.getBlue()*this._Ka)));
        //כגד

    }
}
