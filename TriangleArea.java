/*
Calculates the area of a triangle using Heron's area formula;
*/

public class TriangleArea{
  public static void main(String[] args) {
    // A, B, and C are the sides of the triangle
    double A = 585.54;
    double B = 237.40;
    double C = 358.28;

    // this is a variable used in the final formula
    double s = (A + B + C) / 2;
    System.out.println("s is " + s);

    double combined = s * (s - A) * (s - B) * (s - C);
    System.out.println("combined is " + combined);

    // the final formula
    double area = Math.sqrt(combined);

    System.out.println("Area is " + area);
  }
}
