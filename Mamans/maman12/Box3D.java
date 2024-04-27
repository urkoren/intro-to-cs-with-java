package Mamans.maman12;

/**
 * Maman 12 - Using a class to represent a given box.
 * 
 * @author Or Koren
 * @version 2024b
 */

public class Box3D
{
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    /** Constructs and initializes a box with a default base point and all dimensions to 1 */
    public Box3D(){
        _base = new Point3D();
        setDimensions(1, 1, 1);
    }

    /** Constructs and initializes a Box3D object from a given Box3D.
    * @param p point object that represent the base point of the box
    * @param length the length of the box
    * @param width the width of the box
    * @param height the height of the box
    */
    public Box3D(Point3D p, int length, int width, int height){
        _base = new Point3D(p);
        setDimensions(length, width, height);
    }

    /** Constructs and initializes a box object from a given base point and 3 integers as the dimentions of the Box
    * @param other Box3D object to be copied into the new Box3D object
    */
    public Box3D(Box3D other){
        _base = new Point3D(other._base);
        setDimensions(other._length, other._width, other._height); 
    }

    /** Set the dimentions of the box while verfying the given values
     * @param length the length to set
     * @param width the width to set
     * @param height the height to set
     */
    private void setDimensions(int length, int width, int height){
        _length = verify(length);
        _width = verify(width);
        _height = verify(height);    
    }

    /** Verify given int value if its greater then zero, if not it returns 1
     * @param num the value to verify
     * @return num if the value is greater then 0; 1 otherwise
     */
    private int verify(int num)
    {
        if (num <= 0){
            return 1;
        }
        return num;
    }

    /** Returns the length dimension */
    public int getLength(){
        return _length;
    }

    /** Returns the width dimension */
    public int getWidth(){
        return _width;
    }

    /** Returns the height dimension */
    public int getHeight(){
        return _height;
    }

    /** Returns the lower-left-front (base) Point3D of the box */
    public Point3D getBase(){
        return _base;
    }

    /** Sets the length of the box only if the given value is equal or greater than 1 
     * @param num the length to set
     */
    public void setLength(int num){
        if (num > 0){
            _length = num;
        }
    }
    
    /** Sets the width of the box only if the given value is equal or greater than 1 
     * @param num the width to set
     */
    public void setWidth(int num){
        if (num > 0){
            _width = num;
        }
    }

    /** Sets the height of the box only if the given value is equal or greater than 1 
     * @param num the height to set
     */
    public void setHeight(int num){
        if (num > 0){
            _height = num;
        }
    }
     
    /** Sets the base point of the box
     * @param otherBase the Point3D to set
     */
    public void setBase(Point3D otherBase){
        _base = new Point3D(otherBase);
    }

    /** Returns a string representation of this Box3D object.
     * @return a string representation of this box containing the location of its base point in the coordinate space and its dimensions.
     * in the follwing foramt:
     * The base point is (x,x,x), length = x, width = x, height= x
     */
    public String toString(){
        return new String("The base point is " + _base.toString()
                        + ", length = " + getLength() + 
                        ", width = "+ getWidth() + 
                        ", height = " + getHeight());
    }

    /** Determines whether or not the two boxes are equal
     * @param other a Box3D object to be compared with this Box3D
     * @return true if the Box3D object to be compared has the same values; false otherwise
     */
    public boolean equals(Box3D other){
        if (_base.equals(other.getBase()) && 
            getLength() == other.getLength() && 
            getWidth() == other.getWidth() && 
            getHeight() == other.getHeight()){
            return true;
        }
        return false;
    }

    /** Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) without changing the box dimensions
     * 
     * @param dx the addtion for coordinate x value
     * @param dy the addtion for coordinate y value
     * @param dz the addtion for coordinate z value
     * @return the new box in its new location
     */
    public Box3D move(double dx, double dy, double dz){
        Point3D newP = new Point3D(_base.getX() + dx, _base.getY() + dy, _base.getZ()+ dz);
        return new Box3D(newP, getLength(), getWidth(), getHeight());
    }

    /** Calculates and returns the upper-right-back point of this box
     * @return the upper-right-back point of this box
     */
    public Point3D getUpRightBackPoint(){
        return getNewPoint(_base.getX() - getLength(),
                            _base.getY() + getWidth(),
                            _base.getZ() + getHeight());
    }

    /** Calculates and returns the center point of the box
     * @return the center point of the box
     */
    public Point3D getCenter(){
        double half_length = getLength() * 0.5;
        double half_width= getWidth() * 0.5;
        double half_height= getHeight() * 0.5;
        return getNewPoint(_base.getX() - half_length,
                            _base.getY() + half_width,
                            _base.getZ() + half_height);
    }
    
    /** Computes the distance between two boxes based on the distance of their center points
     * @param other a Box3D object that will be usd to calculate the distance between it to this Box3D object
     * @return the distance between two Box3D objects
     */
    public double distance(Box3D other){
        return this.getCenter().distance(other.getCenter()); 
    }

    /** Computes the volume of the box
     * @return volume of the Box3D object
     */
    public int getVolume(){
        return getLength() * getWidth() * getHeight();
    }

    /** Computes the surface area of a box
     * @return the surface area of a Box3D object
     */
    public int getSurfaceArea(){
        return 2 * (getLength() * getWidth() +
                    getLength() * getHeight() +
                    getWidth() * getHeight());
    }

    /** Determines whether this box has a greater volume in compare to other box
     * @param other a Box3D object whose volume will be compared with the volume of this Box3D
     * @return true if this object has a greater volume, false otherwise.
     */
    public boolean isLargerCapacity(Box3D other){
        if (this.getVolume() > other.getVolume()){
            return true;
        }
        return false;
    }
    
    /** Determines whether this box can contain the other box
     * @param other a Box3D object to check if it can be contained within this box
     * @return true if this Box3D object can contain the other, false otherwise
     */
    public boolean contains(Box3D other){
        if (getTopPanel(this) > getTopPanel(other) &&
            getSidePanel(this) > getSidePanel(other) &&
            getFrontPanel(this) > getFrontPanel(other)){
            return true;
        }
        return false;
    }

    /** Checks if this box is above the other box
     * @param other The box to check if this box is above it
     * @return true if this box is above the other box, false otherwise
     */
    public boolean isAbove(Box3D other){
        if (_base.getZ() >(other.getHeight() + other._base.getZ())){
            return true;
        }
        return false;
    }

    /** Gets the area of the box the top panel
     * @param box the box to scan
     * @return the area requried
     */
    private int getTopPanel(Box3D box){
        return box.getLength() * box.getWidth();
    }

    /** Gets the area of the box the side panel
     * @param box the box to scan
     * @return the area requried
     */
    private int getSidePanel(Box3D box){
        return box.getLength() * box.getHeight();
    }

    /** Gets the area of the box the front panel
     * @param box the box to scan
     * @return the area requried
     */
    private int getFrontPanel(Box3D box){
        return box.getWidth() * box.getHeight();
    }

    /** Generates new Point3D object by given values
     * @param x the coordinate x value
     * @param y the coordinate y value
     * @param z the coordinate z value
     * @return new Point3D object
     */
    private Point3D getNewPoint(double x, double y, double z){
        return new Point3D(x, y, z);
    }
}
