import java.util.*;
public class randomnumber{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int num = (int)(Math.random()*100);

        System.out.println("num is = " + num);
        int prev = -1;
        while(true){
            int guess = input.nextInt();
            if(guess == num){
                System.out.println("CONGO");
                break;
            }
            if(guess<0||guess>100){
                System.out.println("Out of Bound");
                continue;
            }
            if(prev>0)
            {
                if(guess>prev && guess<num){
                    System.out.println("Warm");
                }else{
                    System.out.println("COLDER");
                    continue;
                }
            }
            else{
                if(guess<num && guess>num-10 && prev == -1){
                    System.out.println("Warm");
                }else{
                    System.out.println("COLDER");
                    continue;
                }                
            }
            prev = guess;
        }

        input.close();
    }
}