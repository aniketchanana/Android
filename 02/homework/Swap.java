import java.util.Scanner;

public class Swap{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println("a = "+a+" b = " + b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("a = "+a+" b = " + b);
        input.close();
    }
}