public class Largest{
    public static void main(String args[]){
        int b = 10;
        int a = 9;
        int c = 8;
        if(a>b && a>c){
            System.out.println("a is the largest");
        }else if(b>c && b>a){
            System.out.println("b is the largest");
        }else{
            System.out.println("c is the largest");
        }
    }
}