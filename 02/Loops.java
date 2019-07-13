import java.util.Scanner;
public class Loops{
    public static void main(String args[]){
        int i=1;
        // while(++i<=100)
        // {
        //     int flag = 0;
        //     for(int j=2;j<=i/2;j++)
        //     {
        //         if(i%j == 0 && j!=i)
        //         {
        //             flag++;
        //             break;
        //         }
        //     }
        //     if(flag==0){
        //         System.out.println(i);
        //     }
        // }
           Scanner input = new Scanner(System.in);
           int i = 1;
           int num = input.nextInt();
           while(i<=num){
               System.out.println("2 * "+i + " = " + 2*i);
               i++;
           } 
    }
}