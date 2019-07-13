import java.util.Scanner;
import java.util.regex.*;
public class pass{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String pass = input.nextLine();
        System.out.println(pass.matches(regex));
        // if(check(pass)){
        //     System.out.println("Strong password");
        // }else{
        //     System.out.println("Weak password");
        // }
        input.close();
    }
    // private static boolean check(String pass){
    //     return pass.matches("*n");
    //     if(pass.length()<8)
    //     return false;
    //     boolean one=false,two=false,three=false,four=false;
    //     for(int i=0;i<pass.length();i++){
    //         if(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z'){
    //             one = true;
    //         }
    //         else if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z'){
    //             two = true;
    //         }
    //         else if(pass.charAt(i)>='0'&& pass.charAt(i)<='9'){
    //             four = true;
    //         }
    //         else{
    //             three = true;
    //         }
    //     }
    //     if(one && two && three && four){
    //         return true;
    //     }
    //     else
    //     {
    //         return false;
    //     }
    // }
}