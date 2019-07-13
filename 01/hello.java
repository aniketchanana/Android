class A{
    void msg(){
        System.out.println("i am in class A");
    }
}
//initially when it was not public compiler was like ok if you dont want to give me access of classes i will compile
//each class seprately for you and now you have to figure out which class to run own your own
//because i dont know which class is containing main method to start execution


//but when you make a class public now again compiler will compile all the classes seprately but now you have defined 
//your main method in public class and compiler knows this thing so you need not to worry about which class to execute
//you can directly run it by using java filename 
class B{
    public static void main(String args[]){
        System.out.println("i am in class B");
        A obj = new A();
        obj.msg();
    }
    
}