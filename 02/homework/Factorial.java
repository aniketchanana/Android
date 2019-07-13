import java.util.Scanner;

public class Factorial{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int factorial = 1;
        // while(n!=0){
        //     factorial = factorial*n;
        //     n--;
        // }
        for(int i=n;i>=1;i--)
        factorial = factorial*i;
        System.out.println(factorial);
        input.close();
    }
}