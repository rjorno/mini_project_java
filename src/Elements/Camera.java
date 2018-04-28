package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.Map;

public class Camera {
    //Eye point of the camera
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vTo;
    //Should be calculated as the cross product if vUp and vTo
    private Vector _vRight;
    // ***************** Constructors ********************** //
    public Camera(){
        this._P0=new Point3D(0.0,0.0,10);
        this._vUp=new Vector(0.0,1.0,0.0);
        this._vTo=new Vector(0.0,0.0,-1.0);
        this._vRight=this._vTo.crossProduct(this._vUp);
    }
    public Camera (Camera camera){
        this._P0=new Point3D(camera.getP0());
        this._vUp=new Vector(camera.get_vUp());
        this._vTo=new Vector(camera.get_vTo());
        this._vRight=new Vector(camera.get_vRight());
    }
    public Camera (Point3D P0, Vector vUp, Vector vTo){
        this._P0=new Point3D(P0);
        this._vUp=new Vector(vUp);
        this._vTo=new Vector(vTo);
        this._vRight=this._vUp.crossProduct(this._vTo);
    }
    public Camera (Map<String, String> attributes){

    }
// ***************** Getters/Setters ********************** //
public Vector get_vUp(){
    return new Vector(this._vUp);
}
    public void set_vUp(Vector vUp){
        this._vUp=new Vector(vUp);
    }
    public Vector get_vTo(){
        return new Vector(this._vTo);
    }
    public void set_vTo(Vector vTo){
        this._vTo=new Vector(vTo);
    }
    public Point3D getP0(){
        return new Point3D(this._P0);
    }
    public void setP0(Point3D P0){
        this._P0=new Point3D(P0);
    }
    public Vector get_vRight(){
        return new Vector(this.get_vRight());
    }
    // ***************** Administration ********************** //
    public String toString(){return null;}
    // ***************** Operations ******************** //
    public Ray constructRayThroughPixel (int Nx, int Ny,
                                         double x, double y,
                                         double screenDist,
                                         double screenWidth,
                                         double screenHeight){
        Point3D pc=new Point3D(this.getP0());
        Vector vTo=new Vector(this.get_vTo());
        vTo.scale(screenDist);
        pc.add(vTo);
        double Rx=screenWidth/Nx;
        double Ry=screenHeight/Ny;

        Point3D P=new Point3D(pc);
        Vector vRight=new Vector(this.get_vRight());
        Vector vUp=new Vector(this.get_vUp());

        vRight.scale(((x-(Nx/2.0))*Rx + Rx/2.0));
        vUp.scale(((y-(Ny/2.0))*Ry+Ry/2.0));

        P.add(vRight);
        P.subtract(vUp);

        Vector v=new Vector(this.getP0(),P);
        Ray ray=new Ray(this.getP0(),v);

        return ray;
    }
}
