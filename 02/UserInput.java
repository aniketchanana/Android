import java.util.Scanner;
public class UserInput{
    public static void main(String agrs[]){
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        System.out.println(a+b);
        input.close();
    }
}