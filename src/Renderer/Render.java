package Renderer;
import java.awt.Color;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Consumer;
//import Elements.LightSource;
//import Geometries.FlatGeometry;
import Elements.LightSource;
import Geometries.FlatGeometry;
import Geometries.Geometry;
import Geometries.Triangle;
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

                Ray ray =
                        this._scene.getCamera().constructRayThroughPixel(
                                this._imageWriter.getNx(),
                                this._imageWriter.getNy(),j,i,
                                this._scene.getScreenDistance(),
                                this._imageWriter.getWidth(),
                                this._imageWriter.getHeight());
                Map<Geometry, List<Point3D>>  intersectionPoints =
                        getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    this._imageWriter.writePixel(j, i, this._scene.getBackground());
                else {
                    Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
                    Entry<Geometry, Point3D> entry = closestPoint.entrySet().iterator().next();
                    _imageWriter.writePixel(j, i,calcColor(entry.getKey(),entry.getValue()) );
                }
            }
        }
    }


    private Color calcColor(Geometry geometry, Point3D point) {
        Color ambientLight = _scene.getAmbientLight().getIntensity();
        Color emissionLight = geometry.getEmmission();
        Iterator<LightSource> lights = _scene.getLightsIterator();
        Color lightReflected = new Color(0, 0, 0);

        while (lights.hasNext()){
            LightSource light = lights.next();

            if (!occluded(light, point, geometry)) {

                Color lightIntensity = light.getIntensity(point);

                Color lightDiffuse = calcDiffusiveComp(geometry.getMaterial().get_Kd(),
                        geometry.getNormal(point),
                        light.getL(point),
                        lightIntensity);
                // diffuseLight=addColors(diffuseLight,lightDiffuse);
                Color lightSpecular = calcSpecularComp(geometry.getMaterial().get_Ks(),
                        new Vector(point, _scene.
                                getCamera().getP0()),
                        geometry.getNormal(point),
                        light.getL(point),
                        geometry.getShininess(),
                        lightIntensity);
                // specularLight=addColors(specularLight,lightSpecular);
                Color lightRef = addColors(lightDiffuse, lightSpecular);
                lightReflected = addColors(lightReflected, lightRef);
            }
        }
        Color temp=addColors(ambientLight,emissionLight);
        return addColors(temp,lightReflected);
    }


    /*0
        public void renderImage(){
            for (int i = 0;i<this._imageWriter.getNx();i++){
                for (int j=0;j<this._imageWriter.getNy();j++){

                    Ray ray = this._scene.getCamera().constructRayThroughPixel
                            (this._imageWriter.getNx(),this._imageWriter.getNy(),i,j,this._scene.getScreenDistance(),this._imageWriter.getWidth(),this._imageWriter.getHeight());
                    Entry<Geometry,Point3D> geometryPoint3DEntry =findClosesntIntersection(ray);
                    if (geometryPoint3DEntry==null)
                        this._imageWriter.writePixel(i, j, this._scene.getBackground());
                    else {
                        this._imageWriter.writePixel(i,j,calcColor(geometryPoint3DEntry.getKey(),geometryPoint3DEntry.getValue()));
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
    /*  private Color calcColor(Geometry geometry, Point3D point, Ray ray){
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
      }*/
    private boolean occluded(LightSource light, Point3D point,Geometry geometry){
        Vector lightDirection = light.getL(point);
        lightDirection.scale(-1);

        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector.scale(geometry.getNormal(point).dotProduct(lightDirection)>0?2:-2);
        geometryPoint.add(epsVector);
        Ray lightRay = new Ray(geometryPoint, lightDirection);
        Map<Geometry, List<Point3D>> intersectionPoints =
                getSceneRayIntersections(lightRay);

        // Flat geometry cannot self intersect
        if (geometry instanceof FlatGeometry) {
            intersectionPoints.remove(geometry);}

        return !intersectionPoints.isEmpty();
    }
    private Color calcSpecularComp(double ks, Vector v, Vector normal,Vector l, double shininess, Color lightIntensity){
        Vector V=new Vector(v);
        Vector N =new Vector(normal);
        Vector L=new Vector(l);
        V.normalize();
        N.normalize();
        L.normalize();

        N.scale(2*L.dotProduct(N));
        Vector R =new Vector(L);
        R.normalize();
        R.subtract(N);
        double Shin=0;
        if (V.dotProduct(R)>0) Shin=Math.pow(V.dotProduct(R),shininess)*ks;
        // if(Shin>1)Shin=1;
        return new Color((int)(lightIntensity.getRed()*Shin),
                (int)(lightIntensity.getGreen()*Shin),
                (int)(lightIntensity.getBlue()*Shin));
    }

    private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity){
        Vector N=new Vector(normal);
        Vector L=new Vector(l);
        N.normalize();
        L.normalize();
        double d= Math.abs(kd * N.dotProduct(L));
//if (d>1)d=1;
        return new Color((int)(lightIntensity.getRed()*d),
                (int)(lightIntensity.getGreen()*d),
                (int)(lightIntensity.getBlue()*d));
    }

    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray)
    {
        Map<Geometry, List<Point3D>> intersectionPoints=new HashMap<Geometry, List<Point3D>>();
        Iterator<Geometry> geometries = _scene.getGeometriesIterator();

        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints =
                    geometry.FindIntersections(ray);

            if (!geometryIntersectionPoints.isEmpty())
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
            for (Point3D point : mapIntersection.getValue()){

//                    System.out.println(P0.distance(point));
//                    System.out.println(point);
                if (P0.distance(point) < distance){
                    minDistancePoint.clear();
                    minDistancePoint.put(mapIntersection.getKey(),point);
                    distance = P0.distance(point);
                }
            }
        }
        return minDistancePoint;
    }

    private Color addColors(Color a, Color b){
        int R = a.getRed() + b.getRed();
        if (R > 255) R = 255;

        int G = a.getGreen() + b.getGreen();
        if (G > 255) G = 255;

        int B = a.getBlue() + b.getBlue();
        if (B > 255) B = 255;

        Color I = new Color (R, G, B);
        return I;
    }
}