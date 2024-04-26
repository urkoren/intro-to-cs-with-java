package Mamans.maman12;

public class Box3D
{
    /////////////////////
    ///// Instances /////
    /////////////////////

    Point3D _base;
    int _length;
    int _width;
    int _height;

    /////////////////////////
    ///// Constructures /////
    /////////////////////////

    public Box3D(){
        
        _base = new Point3D(0, 0, 0);
        setDimentions(1, 1, 1);
    }

    public Box3D(Point3D other, int length, int width, int height){
        _base = new Point3D(other);
        setDimentions(length, width, height);
    }

    public Box3D(Box3D other){
        _base = new Point3D(other._base);
        setDimentions(other._length, other._width, other._height); 
    }
        
    private void setDimentions(int length, int width, int height){
        _length = verify(length);
        _width = verify(width);
        _height = verify(height);    
    }

    private int verify(int num)
    {
        if (num <= 0){
            return 1;
        }
        return num;
    }

    public int getLength(){
        return _length;
    }

    public int getWidth(){
        return _width;
    }

    public int getHeight(){
        return _height;
    }

    public Point3D getBase(){
        return _base;
    }

    public void setLength(int num){
        if (num > 0){
            _length = num;
        }
    }
    public void setWidth(int num){
        if (num > 0){
            _width = num;
        }
    }

    public void setHeight(int num){
        if (num > 0){
            _height = num;
        }
    }
     
    public void setBase(Point3D p){
        _base = new Point3D(p);
    }

    public String toString(){
        return new String("The base point is " + _base.toString()
                        + ", length = " + _length + 
                        ", width = "+ _width + 
                        ", height = " + _height);
    }

    public boolean equals(Box3D other){
        if (_base.equals(other._base) && 
            _length == other._length && 
            _width == other._width && 
            _height == other._height){
            return true;
        }
        return false;
    }

    public Box3D move(double dx, double dy, double dz){
        Point3D newP = new Point3D(_base._x + dx, _base._y + dy, _base._z + dz);
        return new Box3D(newP, _length, _width, _height);
    }

    public Point3D getUpRightBackPoint(){
        return getNewPoint(_base._x - _length,
                            _base._y + _width,
                            _base._z + _height);
    }

    public Point3D getCenter(){
        double half_length = _length * 0.5;
        double half_width= _width * 0.5;
        double half_height= _height * 0.5;
        return getNewPoint(_base._x - half_length,
                            _base._y + half_width,
                            _base._z + half_height);
    }
    
    public double distance(Box3D other){
        return this.getCenter().distance(other.getCenter()); 
    }

    public int getVolume(){
        return _length * _width * _height;
    }

    public int getSurfaceArea(){
        return 2 * (_length * _width +
                    _length * _height +
                    _width * _height);
    }

    public boolean isLargerCapacity(Box3D other){
        if (this.getVolume() > other.getVolume()){
            return true;
        }
        return false;
    }
    
    public boolean contains(Box3D other){
        if (getTopPanel(this) > getTopPanel(other) &&
            getSidePanel(this) > getSidePanel(other) &&
            getFrontPanel(this) > getFrontPanel(other)){
            return true;
        }
        return false;
    }

    public boolean isAbove(Box3D other){
        if (_base._z >(other._height + other._base._z)){
            return true;
        }
        return false;
    }

    private int getTopPanel(Box3D box){
        return box._length * box._width;
    }

    private int getSidePanel(Box3D box){
        return box._length * box._height;
    }

    private int getFrontPanel(Box3D box){
        return box._width * box._height;
    }

    private Point3D getNewPoint(double x, double y, double z){
        return new Point3D(x, y, z);
    }
}
