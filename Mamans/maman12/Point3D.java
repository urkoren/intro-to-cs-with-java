package Mamans.maman12;

public class Point3D
{
    /////////////////////
    ///// Instances /////
    /////////////////////

    double _x;
    double _y;
    double _z;

    /////////////////////////
    ///// Constructures /////
    /////////////////////////

    // Empty constructor
    public Point3D(){
        setPoint(0, 0, 0);
    }

    // Set constructor.
    public Point3D(double x, double y, double z){
        setPoint(x, y, z);
    }

    // Copy constructor.
    public Point3D(Point3D other){
        setPoint(other._x, other._y, other._z);
    }

    private void setPoint(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }
    /////////////////////////
    ///// Get methods ///////
    /////////////////////////

    public double getX(){
        return _x;
    }

    public double getY(){
        return _y;
    }

    public double getZ(){
        return _z;
    }

    /////////////////////////
    ///// Set methods ///////
    /////////////////////////
    
    public void setX(double num){
        _x = num;
    }

    public void setY(double num){
        _y = num;
    }

    public void setZ(double num){
        _z = num;
    }

    public String toString(){
        return new String("(" + _x + "," + _y + "," + _z + ")");
    }

    public boolean equals(Point3D other){
        if ((_x == other._x) && (_y == other._y) && (_z == other._z)){
            return true;
        }
        return false;
    }

    public boolean isAbove(Point3D other){
        if (_z > other._z){
            return true;
        }
        return false;
    }

    public boolean isUnder(Point3D other){
        return other.isAbove(this);
    }

    public boolean isLeft(Point3D other){
        if (_y < other._y){
            return true;
        }
        return false;
    }

    public boolean isRight(Point3D other){
        return other.isLeft(this);
    }

    public boolean isBehind(Point3D other){
        if (_x < other._x){
            return true;
        }
        return false;
    }

    public boolean isInFrontOf(Point3D other){
        return other.isBehind(this);
    }

    public void move(double dx, double dy, double dz)
    {
        _x += dx;
        _y += dy;
        _z += dz;
    }

    public double distance(Point3D p){
        double pow_x = Math.pow(_x - p._x, 2);
        double pow_y = Math.pow(_y - p._y, 2);
        double pow_z = Math.pow(_z - p._z, 2);
        return Math.sqrt(pow_x + pow_y + pow_z);
    }
}
