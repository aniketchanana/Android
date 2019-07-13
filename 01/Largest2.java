public class Largest2{
    public static void main(String args[]){
        int c = 10;
        int b = 9;
        int a = 8;
        if(a>b){
            if(a>c){
                System.out.println("a is largest");
            }else{
                System.out.println("c is largest");
            }
        }else{
            if(b>c){
                System.out.println("b is largest");
            }else{
                System.out.println("c is largest");
            }
        }
    }
}