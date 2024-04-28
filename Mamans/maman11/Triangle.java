///////////////////////////////////////////////////////////////////////////
// This program calculate the area and the perimeter of a given traingle.//
///////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
public class Triangle
{
    public static void main (String [] args)
    {
        // Create a Scanner object to read user input
        Scanner scan = new Scanner (System.in);

        // Display a message to the user explaining the purpose of the program
        System.out.println ("This program calculates the area "
        + "and the perimeter of a given triangle. ");

        // Prompt the user to enter the lengths of the triangle's sides
        System.out.println ("Please enter the three lengths"
        + " of the triangle's sides");

        // Read the lengths of the triangle's sides from user input
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        // Display the lengths of the triangle's sides to the user
        System.out.println("The lengths of the triangle sides are: "+ a + ", " + b +", "+ c);

        // Check if any of the side lengths are negative, which would not form a valid triangle
        if (a<0 || b<0 || c<0)
            System.out.println("Not a vaild numbers");
        else {
            // Calculate the semi-perimeter of the triangle
            double p = (a+b+c)/2;

            // Calculate the area of the triangle using Heron's formula
            double s_before_square = p*(p-a)*(p-b)*(p-c);

            // Check if the calculated area is valid (greater than zero)
            if (s_before_square<=0)
                System.out.println("The given three sides don't represent a triangle");
            else {
                // Calculate the area of the triangle using the square root of s_before_square
                double s = Math.sqrt(s_before_square); 

                // Calculate the perimeter of the triangle
                int perimeter = a+b+c;

                // Display the perimeter and area of the triangle to the user
                System.out.println("The perimeter of the triangle is: " + perimeter);
                System.out.println("The area of the triangle is: "+ s);
            }
        }
    }
}
