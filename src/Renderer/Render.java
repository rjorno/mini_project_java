package Renderer;
import java.awt.Color;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Consumer;
//import Elements.LightSource;
//import Geometries.FlatGeometry;
import Geometries.Geometry;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;
public class Render
{
    private Scene _scene;
    private ImageWriter _imageWriter;
    private final int RECURSION_LEVEL = 3;
    // ***************** Constructors ********************** //
    public Render(ImageWriter imageWriter, Scene scene){
        this._imageWriter=new ImageWriter(imageWriter);
        this._scene=new Scene(scene);
    }
    // ***************** Operations ******************** //



    public void renderImage(){
        for (int i = 0;i<this._imageWriter.getHeight();i++){
            for (int j=0;j<this._imageWriter.getWidth();j++){

                Ray ray = this._scene.getCamera().constructRayThroughPixel
                        (this._imageWriter.getNx(),this._imageWriter.getNy(),j,i,this._scene.getScreenDistance(),this._imageWriter.getWidth(),this._imageWriter.getHeight());
                List<Point3D> intersectionPoints =
                        getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    this._imageWriter.writePixel(j, i, this._scene.getBackground());
                else {
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j, i, calcColor(closestPoint));
                }
            }
        }
    }


    private List<Point3D> getSceneRayIntersections(Ray ray) {
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();

        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints =
                    geometry.FindIntersections(ray);
                intersectionPoints.addAll(geometryIntersectionPoints);
        }
        return intersectionPoints;
    }



    private Point3D getClosestPoint(List<Point3D> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = this ._scene.getCamera().getP0();
        Point3D minDistancePoint = null;
        for (Point3D point: intersectionPoints) {
            if (P0.distance(point) < distance){
                minDistancePoint = new Point3D(point);
                distance = P0.distance(point);
            }
        }
        return minDistancePoint;
    }

    private Color calcColor(Point3D point) {
        return _scene.getAmbientLight().getIntensity();
    }










  /*  public void renderImage(){
        for (int i = 0;i<this._imageWriter.getNx();i++){
            for (int j=0;j<this._imageWriter.getNy();j++){

                Ray ray = this._scene.getCamera().constructRayThroughPixel
                        (this._imageWriter.getNx(),this._imageWriter.getNy(),i,j,this._scene.getScreenDistance(),this._imageWriter.getWidth(),this._imageWriter.getHeight());
                Entry<Geometry,Point3D> geometryPoint3DEntry =findClosesntIntersection(ray);
                if (geometryPoint3DEntry==null)
                    this._imageWriter.writePixel(i, j, this._scene.getBackground());
                else {
                    this._imageWriter.writePixel(i,j,calcColor(geometryPoint3DEntry.getKey(),geometryPoint3DEntry.getValue(),ray));
                }
            }
        }
    }

    private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray){
        Map<Geometry, List<Point3D>> intersectionPoints=getSceneRayIntersections(ray);
        if (intersectionPoints.isEmpty()) return null;
        Map<Geometry, Point3D> mapClosestPoint = getClosestPoint(intersectionPoints);
        Entry<Geometry, Point3D> entry = mapClosestPoint.entrySet().iterator().next();
        return entry;
    }
    */
    public void printGrid(int interval){

        int height = _imageWriter.getHeight();
        int width = _imageWriter.getWidth();

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){

                if (i % interval == 0 || j % interval == 0)
                    _imageWriter.writePixel(j, i, 255, 255, 255);

            }
        }
    }
    public void writeToImage(){
        _imageWriter.writeToimage();
    }
    private Color calcColor(Geometry geometry, Point3D point, Ray ray){
        return null;
    }
    private Color calcColor(Geometry geometry, Point3D point,Ray inRay, int level){
        return null;
    }
    // Recursive
    private Ray constructRefractedRay(Geometry geometry, Point3D point,Ray inRay){
        return null;
    }
    private Ray constructReflectedRay(Vector normal, Point3D point,Ray inRay){
        return null;
    }
  /*  private boolean occluded(LightSource light, Point3D point,Geometry geometry){
        return false;
    }*/
    private Color calcSpecularComp(double ks, Vector v, Vector normal,Vector l, double shininess, Color lightIntensity){
        return null;
    }
    private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity){
        return null;
    }
    /*
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray)
    {
        Map<Geometry, List<Point3D>> intersectionPoints=new HashMap<Geometry, List<Point3D>>();
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();
        List<Point3D> intersectionPoints1 = new ArrayList<Point3D>();

        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints =
                    geometry.FindIntersections(ray);
            intersectionPoints.put(geometry,geometryIntersectionPoints);
        }
        return intersectionPoints;
    }

    private Map<Geometry, Point3D> getClosestPoint
            (Map<Geometry,List<Point3D>> intersectionPoints) {

        double distance = Double.MAX_VALUE;
        Point3D P0 = this ._scene.getCamera().getP0();
        Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry,Point3D>();
        for (Entry<Geometry,List<Point3D>> mapIntersection:intersectionPoints.entrySet()) {
            for (Point3D point : mapIntersection.getValue())
                if (P0.distance(point) < distance){
                    minDistancePoint.clear();
                    minDistancePoint.put(mapIntersection.getKey(),point);
                    distance = P0.distance(point);
                }
        }
        return minDistancePoint;
    }
    */
    private Color addColors(Color a, Color b){
        return null;
    }
}