package Primitives;

public class Ray {

    private Point3D _POO;

    private Vector _direction;

    public Ray(){

        this._POO=new Point3D();
        this._direction=new Vector();
    }

    public Ray(Ray ray){
        this._POO=new Point3D(ray._POO);
        this._direction=new Vector(ray._direction);
    }
    public Ray(Point3D poo, Vector direction){
        this._POO=new Point3D(poo);
        this._direction=new Vector(direction);
    }

    public Point3D get_POO() {
        return _POO;
    }

    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }
}
