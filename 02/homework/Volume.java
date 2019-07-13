import java.util.Scanner;

public class Volume{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double r = input.nextDouble();
        System.out.println((double)((4.0/3)*3.14*r*r*r));
        input.close();
    }
}