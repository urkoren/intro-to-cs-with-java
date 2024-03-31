import java.util.Scanner;
public class Triangle
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the area "
        + "and the perimeter of a given triangle. ");
        System.out.println ("Please enter the three lengths"
        + " of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int perimeter = a+b+c;
        System.out.println("The lengths of the triangle sides are: "+ a + ", " + b +", "+ c);

        if (a<0 || b<0 || c<0)
            System.out.println("Not a vaild numbers");
        else {
            double p = (a+b+c)/2;
            double temp = p*(p-a)*(p-b)*(p-c);
            if (temp<=0)
                System.out.println("The given three sides don't represent a triangle");
            else {
                double s = Math.sqrt(temp);
                System.out.println("The perimeter of the triangle is: " + perimeter);
                System.out.println("The area of the triangle is: "+ s);
            }
        }
    }
}
