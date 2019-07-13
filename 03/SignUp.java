import java.util.Scanner;

public class SignUp{
    static Boolean signUp(String email,String password){
        if(email.equals("aniketchanana6@gmail.com") && password.equals("aniket123")){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        String password = input.nextLine();
        if(signUp(email, password)){
            System.out.println("welcome");
        }else{
            System.out.println("not a valid user");
        }
        input.close();
    }
}