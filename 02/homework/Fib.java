import java.util.Scanner;

public class Fib{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements tll which you want fib Series(n > 0)");
        int n = input.nextInt();
        int a = 0;
        int b = 1;
        for(int i=0;i<n/2;i++)
        {
            System.out.println(a);
            System.out.println(b);
            a=a+b;
            b=a+b;
        }
        if(n%2!=0)
        {
            System.out.println(a);
        }
        input.close();
    }
}