public class ExpHandel{
    public static void main(String args[]){
        int a = 5;
        try{
            System.out.println(a/0);
        }catch(Exception e){
            System.out.println("can not be divided by 0");
        }
    }
}