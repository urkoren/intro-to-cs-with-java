 /**
 * Maman 12 - Point3D.
 * This class represents a three-dimensional point the x,y and z coordinate 
 * values can get either negative, positive or zero double values.
 * 
 
 * @author Or Koren
 * @version 2024b
 */

public class Point3D
{
    private double _x;
    private double _y;
    private double _z;

    /** Constructs and initializes a Point3D to (0,0,0) */
    public Point3D(){
        setPoint(0, 0, 0);
    }

    /** Constructs and initializes a Point3D from the specified xyz coordinates
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Point3D(double x, double y, double z){
        setPoint(x, y, z);
    }

    /** Constructs and initializes a Point3D from the specified Point3D
     * @param other the Point3D which the new instance initialization will be based on
     */
    public Point3D(Point3D other){
        setPoint(other.getX(), other.getY(), other.getZ());
    }

    /** General Point3D setter by the specified xyz coordinates
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    private void setPoint(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }

    /** Returns the x coordinate
     * @return the value of the x coordinate
     */
    public double getX(){
        return _x;
    }

    /** Returns the y coordinate
     * @return the value of the y coordinate
     */
    public double getY(){
        return _y;
    }

    /** Returns the z coordinate
     * @return the value of the z coordinate
     */
    public double getZ(){
        return _z;
    }
    
    /** Sets the x coordinate to the given x
     * @param num the x value to set
     */
    public void setX(double num){
        _x = num;
    }

    /** Sets the y coordinate to the given y
     * @param num the y value to set
     */
    public void setY(double num){
        _y = num;
    }

    /** Sets the z coordinate to the given z
     * @param num the z value to set
     */
    public void setZ(double num){
        _z = num;
    }

    /** Returns a string representation of this Point3D
     * @return a string representation of this point and its location in the (x,y,z) coordinate space
     */
    public String toString(){
        return new String("(" + getX() + "," + getY() + "," + getZ() + ")");
    }

    /** Determines whether or not two points are equal
     * @param other a Point3D object to be compared with this Point3D
     * @return true if the two Point3D objects are equal (containing the same x, y, and z values); false otherwise
     */
    public boolean equals(Point3D other){
        if ((this.getX() == other.getX()) && (this.getY() == other.getY()) && (this.getZ() == other.getZ())){
            return true;
        }
        return false;
    }

    /** Checks if this point is above the other point
     * @param other the point to check whether this point is above it
     * @return true if this point is above the other point; false otherwise
     */
    public boolean isAbove(Point3D other){
        if (this.getZ() > other.getZ()){
            return true;
        }
        return false;
    }

    /** Checks if this point is under the other point
     * @param other the point to check whether this point is under i
     * @return true if this point is under the other point; false otherwise
     */
    public boolean isUnder(Point3D other){
        return other.isAbove(this);
    }

    /** Checks if this point is to the left of the other point
     * @param other the point to check whether this point is left of it
     * @return true if this point is to the left of the other point; false otherwise
     */
    public boolean isLeft(Point3D other){
        if (getY() < other.getY()){
            return true;
        }
        return false;
    }

    /** Checks if this point is to the right of the other point
     * @param other The point to check whether this point is right of it
     * @return true if this point is to the right of the other point; false otherwise
     */
    public boolean isRight(Point3D other){
        return other.isLeft(this);
    }
    
    /** Checks if this point is behind the other point
     * @param other the point to check whether this point is behind it
     * @return true if this point is behind the other point; false otherwise
     */
    public boolean isBehind(Point3D other){
        if (getX() < other.getX()){
            return true;
        }
        return false;
    }

    /** Checks if this point is in front of the other point
     * @param other the point to check whether this point is in front of it
     * @return true if this point is in front of the other point; false otherwise
     */
    public boolean isInFrontOf(Point3D other){
        return other.isBehind(this);
    }

    /** Moves the Point3D in location (x,y,z), by dx along the x axis, by dy along the y axis and dz along the z axis so 
     * that it now represents the Point3D in the following 3D coordintes (x+dx,y+dy,z+dz)
     * @param dx the addtion for coordinate x value
     * @param dy the addtion for coordinate y value
     * @param dz the addtion for coordinate z value
     */
    public void move(double dx, double dy, double dz)
    {
        setX(getX() + dx);
        setY(getY() + dy);
        setZ(getZ() + dz);
    }

    /** Returns the distance between this point and other point p
     * @param p the other point
     * @return returns the distance
     */
    public double distance(Point3D p){
        double pow_x = Math.pow(getX() - p.getX(), 2);
        double pow_y = Math.pow(getY() - p.getY(), 2);
        double pow_z = Math.pow(getZ() - p.getZ(), 2);
        return Math.sqrt(pow_x + pow_y + pow_z);
    }
}
