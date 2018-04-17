package Primitives;

public class Vector extends Exception {

    private Point3D _head;

    public Vector() {
        this._head = new Point3D();
    }
    public Vector(Point3D head){
        this._head=new Point3D(head);
    }
    public Vector(Vector vector){

        this._head=new Point3D(vector._head);

    }
    public Vector(double xHead, double yHead, double zHead){
        this._head=new Point3D(xHead,yHead,zHead);
    }
    public Vector(Point3D p1, Point3D p2){
        this(p2.get_x().getCoordiannte()-p1.get_x().getCoordiannte(),
                p2.get_y().getCoordiannte()-p1.get_y().getCoordiannte(),
                p2.get_z().getCoordiannte()-p1.get_z().getCoordiannte());
    }

    public Point3D get_head() {
        return new Point3D(_head);
    }

    public void set_head(Point3D _head) {
        this._head = new Point3D(_head);
    }
    public int compareTo(Vector vector){
        return this._head.compareTo(vector._head);
    }
    public String toString(){
        return   this._head.toString();
    }
    public void add (Vector vector ){
        this._head.add(vector);
    }
    public void subtract (Vector vector){
        this._head.subtract(vector);
    }
    public void scale(double scalingFactor){

        this._head.set_x(new Coordinate(scalingFactor*this._head.get_x().getCoordiannte()));
        this._head.set_y(new Coordinate(scalingFactor*this._head.get_y().getCoordiannte()));
        this._head.set_z(new Coordinate(scalingFactor*this._head.get_z().getCoordiannte()));
    }
    public Vector crossProduct(Vector vector){

       double x1=this._head._x.getCoordiannte();
       double y1=this._head._y.getCoordiannte();
       double z1=this._head._z.getCoordiannte();

       double x2=vector._head._x.getCoordiannte();
       double y2=vector._head._y.getCoordiannte();
       double z2=vector._head._z.getCoordiannte();

       return new Vector(y1*z2-z1*y2,(x1*z2-z1*x2)*-1,x1*y2-y1*x2);
    }
    public double length(){

        return Math.sqrt(Math.pow(this._head._x.getCoordiannte(),2)+
        Math.pow(this._head._y.getCoordiannte(),2)+
        Math.pow(this._head._z.getCoordiannte(),2));
    }
    public void normalize() throws Exception {

        double length=this.length();
        if(length==0)
            throw new Exception("You can not normalize the vector 0");
        this.set_head(new Point3D(this._head.get_x().getCoordiannte()/length,
                this._head.get_y().getCoordiannte()/length,
                this._head.get_z().getCoordiannte()/length));

    }

    public double dotProduct(Vector vector){

        double x1=this._head.get_x().getCoordiannte();
        double y1=this._head.get_y().getCoordiannte();
        double z1=this._head.get_z().getCoordiannte();


        double x2=vector._head.get_x().getCoordiannte();
        double y2=vector._head.get_y().getCoordiannte();
        double z2=  vector._head.get_z().getCoordiannte();

        return x1*x2+y1*y2+z1*z2;
    }
}
