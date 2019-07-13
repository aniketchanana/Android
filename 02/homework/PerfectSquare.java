import java.util.Scanner;

public class PerfectSquare{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double sq = Math.sqrt(n);
        if((double)n == sq){
            System.out.println("yes it is a perfect Square");
        }else{
            System.out.println("it is not a perfect square");
        }
        System.out.println(sq);
        input.close();
    }
}