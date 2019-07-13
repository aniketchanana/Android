import java.util.Scanner;

public class calculator{
    public static void main(String args[]){
        java.util.Scanner input = new Scanner(System.in);
        int a,b;
        System.out.println("Enter 2 numbers");
        a = input.nextInt();
        b = input.nextInt();
        System.out.println("Enter 1 for +");
        System.out.println("Enter 2 for -");
        System.out.println("Enter 3 for *");
        System.out.println("Enter 4 for /");
        System.out.println("Enter 5 for %");
        int op;
        op = input.nextInt();
        switch(op){
            case 1:
            System.out.println(a+b);
            break;
            case 2:
            System.out.println(a-b);
            break;
            case 3:
            System.out.println(a*b);
            break;
            case 4:
            System.out.println(a/b);
            break;
            case 5:
            System.out.println(a%b);
            break;
            default:
            System.out.println("wrong operator");
        }
        input.close();
    }
}