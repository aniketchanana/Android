class Methods{
    Methods(int a){
        System.out.println("This is constructor of Method class");
        System.out.println("passed parameter is "+a);
    }
}
public class StaticMethod{
    int nonStaticMethod(){
        System.out.println("non static method");
        return 0;
    }
    static int staticMethod(){
        System.out.println("This is static method");
        return 0;
    }
    public static void main(String[] args){
        StaticMethod sm = new StaticMethod();
        sm.nonStaticMethod();
        staticMethod();
        Methods ms = new Methods(3);
    }
}