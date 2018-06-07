package Primitives;

public class Vector extends Exception {

    private Point3D _head;

    public Vector() {
        this._head = new Point3D();
    }

    public Vector(Point3D head) {
        this._head = new Point3D(head);
    }

    public Vector(Vector vector) {

        this._head = new Point3D(vector._head);

    }

    public Vector(double xHead, double yHead, double zHead) {
        this._head = new Point3D(xHead, yHead, zHead);
    }

    public Vector(Point3D p1, Point3D p2) {
        this(p2.get_x().getCoordinate() - p1.get_x().getCoordinate(),
                p2.get_y().getCoordinate() - p1.get_y().getCoordinate(),
                p2.get_z().getCoordinate() - p1.get_z().getCoordinate());
       // this.normalize();
    }

    public Point3D get_head() {
        return new Point3D(_head);
    }

    public void set_head(Point3D _head) {
        this._head = new Point3D(_head);
    }

    public int compareTo(Vector vector) {
        return this._head.compareTo(vector._head);
    }

    public String toString() {
        return this._head.toString();
    }

    public void add(Vector vector) {
        this._head.add(vector);
    }

    public void subtract(Vector vector) {
        this._head.subtract(vector);
    }

    public void scale(double scalingFactor) {

        this._head.set_x(new Coordinate(scalingFactor * this._head.get_x().getCoordinate()));
        this._head.set_y(new Coordinate(scalingFactor * this._head.get_y().getCoordinate()));
        this._head.set_z(new Coordinate(scalingFactor * this._head.get_z().getCoordinate()));
    }

    public Vector crossProduct(Vector vector) {

        double x1 = this._head._x.getCoordinate();
        double y1 = this._head._y.getCoordinate();
        double z1 = this._head._z.getCoordinate();

        double x2 = vector._head._x.getCoordinate();
        double y2 = vector._head._y.getCoordinate();
        double z2 = vector._head._z.getCoordinate();

        return new Vector(y1 * z2 - z1 * y2, (x1 * z2 - z1 * x2) * -1, x1 * y2 - y1 * x2);
    }

    public double length() {

        return Math.sqrt(this._head._x.getCoordinate()*this._head._x.getCoordinate() +
                this._head._y.getCoordinate()*this._head._y.getCoordinate() +
                this._head._z.getCoordinate()*this._head._z.getCoordinate());
    }

    public void normalize() {

        double length = this.length();
        if (length == 0)
            throw new ArithmeticException();
        this.set_head(new Point3D(this._head.get_x().getCoordinate() / length,
                this._head.get_y().getCoordinate() / length,
                this._head.get_z().getCoordinate() / length));
    }

    public double dotProduct(Vector vector) {

        double x1 = this._head.get_x().getCoordinate();
        double y1 = this._head.get_y().getCoordinate();
        double z1 = this._head.get_z().getCoordinate();


        double x2 = vector._head.get_x().getCoordinate();
        double y2 = vector._head.get_y().getCoordinate();
        double z2 = vector._head.get_z().getCoordinate();

        return x1 * x2 + y1 * y2 + z1 * z2;
    }
}
