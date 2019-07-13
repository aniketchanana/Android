import java.util.Scanner;
public class Form{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name");
        String name;
        name = input.nextLine();
        System.out.println("Enter Emailid");
        String emailid;
        emailid = input.nextLine();
        System.out.println("Enter Phone");
        String phone = input.nextLine();
        System.out.println("Enter Age");
        float age = input.nextInt();
        System.out.println("Your details are");
        System.out.println("name = " + name);
        System.out.println("email = " + emailid);
        System.out.println("phone = " + phone);
        System.out.println("age = " + age);
        input.close();
    }
}