import java.util.Scanner;

public class AddOne
{
  public static void main(String[] args)
  {
    // Write your code here
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int temp=0;
    int pro = 1;
    while(num!=0)
    {
      int rem = num%10;
      rem = (rem+1)%10;
      temp = rem*pro+temp;
      pro = pro*10;
      num = num/10;
    }
    System.out.println(temp);
    input.close();
  }
}