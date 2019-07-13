public class ArrayExp{
    public static void main(String []args){
        int a[] = {1,2,3,4,5};
        try{
            System.out.println(a[20]);
            try{
                System.out.println(20/0);
            }catch(ArithmeticException ae){
                System.out.println("arithmetic exception");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bound");
        }
        System.out.println("last line");
    }
}