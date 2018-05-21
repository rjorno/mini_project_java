package Scene;

import Elements.Camera;
import Geometries.Geometry;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.AmbientLight;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene {
    private String _sceneName = "scene";
    private Color _background;
    private AmbientLight _ambientLight;
    private List<Geometry> _geometries = new ArrayList<Geometry>();
    private Camera _camera;
    private double _screenDistance;
    //private List<LightSource> _lights = new ArrayList<LightSource>();
    // ***************** Constructors ********************** //
    public Scene(){
        this._ambientLight=new AmbientLight();
        this._background=new Color(0,0,0);
        this._camera=new Camera();
        this._screenDistance=0;
    }
    public Scene(Scene scene){
        this._ambientLight=new AmbientLight(scene._ambientLight.getColor());
        this._background=new Color(scene._background.getRGB());
        this._camera=new Camera(scene._camera);
        this._screenDistance=scene._screenDistance;
    }
    public Scene(AmbientLight aLight, Color background,
                 Camera camera, double screenDistance){
        this._ambientLight=new AmbientLight(aLight.getColor());
        this._background=new Color(background.getRGB());
        this._camera=new Camera(camera);
        this._screenDistance=screenDistance;
    }
    // ***************** Getters/Setters ********************** //
    public Color getBackground(){
        return new Color(this._background.getRGB());
    }
    public AmbientLight getAmbientLight(){
        return new AmbientLight(this._ambientLight.getColor());
    }
    public Camera getCamera(){
        return new Camera(this._camera);
    }
    public String getSceneName(){
        return this._sceneName;
    }
    public double getScreenDistance(){
        return this._screenDistance;
    }
    public void setBackground(Color background){
        this._background=new Color(background.getRGB());
    }
    public void setAmbientLight(AmbientLight ambientLight){
        this._ambientLight=new AmbientLight(ambientLight.getColor());
    }
    public void setCamera(Camera camera){
        this._camera=new Camera(camera);
    }
    public void setSceneName(String sceneNAme){
        this._sceneName=sceneNAme;
    }
    public void setScreenDistance(double screenDistance){
        this._screenDistance=screenDistance;
    }
    // ***************** Operations ******************** //
    public void addGeometry(Geometry geometry)
    {
        _geometries.add(geometry);
    }
    public Iterator<Geometry> getGeometriesIterator()
    {
        return _geometries.iterator();
    }
    //public void addLight(LightSource light);
    //public Iterator<LightSource> getLightsIterator();

}
