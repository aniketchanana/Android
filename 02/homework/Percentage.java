import java.util.Scanner;

public class Percentage
{
  public static void main(String[] args)
  {
    int a,b,c,d,e;
    Scanner input = new Scanner(System.in);
    a = input.nextInt();
    b = input.nextInt();
    c = input.nextInt();
    d = input.nextInt();
    e = input.nextInt();
    int sum = a+b+c+d+e;
    System.out.println(sum + " " + sum/5);
    input.close();
  }
}