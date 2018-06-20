package Geometries;
import Primitives.*;

import java.awt.Color;
import java.util.List;
/*

public abstract class Geometry {

    private Material _material = new Material();
 //   private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);

    public abstract List<Point3D> FindIntersections (Ray ray);
    public abstract Vector getNormal(Point3D point);

    public double getShininess(){
        return this._material.get_n();
    }
    public Material getMaterial(){
         return new Material(this._material);
    }
    public Color getEmmission(){return this._emmission;}
    public void setShininess(double n){this._material.set_n(n);}
    public void setMaterial(Material material){
         this._material=new Material(material);
    }
    public void setEmmission(Color emmission){
         this._emmission=new Color(
                 emmission.getRed(),
                 emmission.getGreen(),
                 emmission.getBlue());}
    public void setKs(double ks){this.getMaterial().set_Ks(ks); }
    public void setKd(double kd){
         this._material.set_Kd(kd);
    }
    public void setKr(double Kr){this.getMaterial().set_Kr(Kr);}
    public void setKt(double Kt){this.getMaterial().set_Kt(Kt);}

}
*/

public abstract class Geometry {

    private Material _material = new Material();
    private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);

    public abstract List<Point3D> FindIntersections (Ray ray);
    public abstract Vector getNormal(Point3D point);

    public double   getShininess() { return _nShininess; }
    public Material getMaterial()  { return _material;   }
    public Color getEmmission()    { return _emmission;  }

    public void setShininess(double n)          { _nShininess = n;             }
    public void setMaterial(Material _material) { this._material = _material;  }
    public void setEmmission(Color emmission)   { this._emmission = emmission; }

    public void setKs(double ks) { _material.set_Ks(ks); }
    public void setKd(double kd) { _material.set_Kd(kd); }
    public void setKr(double Kr) { _material.set_Kr(Kr); }
    public void setKt(double Kt) { _material.set_Kt(Kt); }

}
