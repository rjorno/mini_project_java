package Primitives;

public class Point3D extends Point2D {
    protected Coordinate _z;

    public Point3D(){
        super();
        this._z=new Coordinate();
    }
    public Point3D(Coordinate x, Coordinate y, Coordinate z){
        super(x,y);
        this._z=new Coordinate(z);
    }
    public Point3D(double x, double y, double z){
        super(new Coordinate(x), new Coordinate(y));
        _z = new Coordinate(z);

    }
    public Point3D(Point3D point3D){
        super(point3D._x,point3D._y);
        this._z=new Coordinate(point3D._z);
    }

    public Coordinate get_z() {
        return _z;
    }

    public void set_z(Coordinate _z) {
        this._z = _z;
    }
    public int compareTo(Point3D point3D){
        if(this._x.compareTo(point3D._x)==0&&
                this._y.compareTo(point3D._y)==0&&
                this._z.compareTo(point3D._z)==0)
            return 0;
        return 1;

    }

    public String toString(){
        return "(" + _x.getCoordiannte() + ", " +
                _y.getCoordiannte() + ", " +
                _z.getCoordiannte() + ")";
    }
    public void add(Vector vector){
        this._x.add(vector.get_head()._x);
        this._y.add(vector.get_head()._y);
        this._z.add(vector.get_head()._z);
    }
    public void subtract(Vector vector){
        this._x.subtract(vector.get_head()._x);
        this._y.subtract(vector.get_head()._y);
        this._z.subtract(vector.get_head()._z);

    }
    public double distance(Point3D point){
        return Math.sqrt(Math.pow(this._x.getCoordiannte()-point.get_x().getCoordiannte(),2)+
        Math.pow(this._y.getCoordiannte()-point.get_y().getCoordiannte(),2)+
        Math.pow(this._z.getCoordiannte()-point.get_z().getCoordiannte(),2));

    }
}
