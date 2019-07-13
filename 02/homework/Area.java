import java.util.Scanner;

public class Area{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double l = input.nextDouble();
        double b = input.nextDouble();
        System.out.println(l*b);
        input.close();
    }
}