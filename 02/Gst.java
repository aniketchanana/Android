import java.util.Scanner;
public class Gst
{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();
        System.out.println((int)((money*(0.18))+money));
        input.close();
    }
}