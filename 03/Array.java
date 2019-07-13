import java.util.Scanner;

public class Array{
    public static void main(String[] args){
        int []a = new int[5];
        java.util.Scanner input = new Scanner(System.in);
        for(int i =0;i<5;i++){
            a[i] = input.nextInt();
        }
        for(int i =0;i<5;i++){
            System.out.println(a[i]);
        }
        input.close();
    }
}