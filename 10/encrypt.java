import java.util.Scanner;
public class encrypt{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String pass = input.nextLine();
        pass = protect(pass);
        System.out.println(pass);
        pass = decrypt(pass);
        System.out.println(pass);
        input.close();
    }
    public static String decrypt(String pass){
        StringBuilder newpass = new StringBuilder();
        for(int i=0;i<pass.length();i++)
            {
                newpass.append((char)(pass.charAt(i)-10));
            }
            newpass.reverse();
        return newpass.toString();
    }
    public static String protect(String pass){
        StringBuilder newpass = new StringBuilder();
            for(int i=0;i<pass.length();i++)
            {
                newpass.append((char)(pass.charAt(i)+10));
            }
            newpass.reverse();
            return newpass.toString();
        }
    }