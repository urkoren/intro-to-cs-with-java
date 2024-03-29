
import java.util.Scanner;
public class Congruent
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);

        System.out.println ("This program calculates the area "
        + "and the perimeter of a given triangle. ");

        System.out.println ("Please enter the coordinates of the 3 " +
        "vertices of the first triangle:");
        System.out.println ("Enter the first vertex (2 real numbers)");
        double x11 = scan.nextDouble();
        double y11 = scan.nextDouble();
        System.out.println ("Enter the second vertex (2 real numbers)");
        double x12 = scan.nextDouble();
        double y12 = scan.nextDouble();
        System.out.println ("Enter the third vertex (2 real numbers)");
        double x13 = scan.nextDouble();
        double y13 = scan.nextDouble();

        System.out.println ("Please enter the coordinates of the 3 " +
        "vertices of the first triangle:");
        System.out.println ("Enter the first vertex (2 real numbers)");
        double x21 = scan.nextDouble();
        double y21 = scan.nextDouble();
        System.out.println ("Enter the second vertex (2 real numbers)");
        double x22 = scan.nextDouble();
        double y22 = scan.nextDouble();
        System.out.println ("Enter the third vertex (2 real numbers)");
        double x23 = scan.nextDouble();
        double y23 = scan.nextDouble();

        double distance_1a = Math.sqrt(Math.pow((x12 - x11), 2) + Math.pow((y12 - y11), 2));
        double distance_1b = Math.sqrt(Math.pow((x13 - x12), 2) + Math.pow((y13 - y12), 2));
        double distance_1c = Math.sqrt(Math.pow((x11 - x13), 2) + Math.pow((y11 - y13), 2));

        double distance_2a = Math.sqrt(Math.pow((x22 - x21), 2) + Math.pow((y22 - y21), 2));
        double distance_2b = Math.sqrt(Math.pow((x23 - x22), 2) + Math.pow((y23 - y22), 2));
        double distance_2c = Math.sqrt(Math.pow((x21 - x23), 2) + Math.pow((y21 - y23), 2));

        // System.out.println ("The first triangle is (" + x11+","+y11+") ("+ x12+","+y12+") (" + x11+","+y11+").");
        // System.out.println ("Its lengths are " + distance_1a +", " + distance_1b + ", " + distance_1c + ".");
        
        // System.out.println ("The first triangle is (" + x21+","+y21+") ("+ x22+","+y22+") (" + x21+","+y21+").");
        // System.out.println ("Its lengths are " + distance_2a +", " + distance_2b + ", " + distance_2c + ".");

        double total_distance_2 = distance_2a + distance_2b + distance_2c;

        if (distance_1a == distance_2a || distance_1a == distance_2b || distance_1a == distance_2c){
            total_distance_2 -= distance_1a;
            if (distance_1b == distance_2a || distance_1b == distance_2b || distance_1b == distance_2c){
                total_distance_2 -= distance_1b;
                if (distance_1c == distance_2a || distance_1c == distance_2b || distance_1c == distance_2c){
                    total_distance_2 -= distance_1c;
                    if (total_distance_2 == 0){
                        System.out.println("The triangles are congruent");
                        return;
                    }
                }
            }
        }
        System.out.println("The triangles are not congruent");
    }
}
