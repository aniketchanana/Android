public class AlternatePrime{
    public static void main(String args[]){
        int count = 0;
        int i = 2;
        while(i<=100)
        {
            int flag = 0;
            for(int j=2;j<=i/2;j++)
            {
                if(i%j == 0)
                {
                    flag++;
                    break;
                }
            }
            if(flag == 0 && count!=0)
            {
                count = 0;
                i++;
                continue;
            }
            if(flag==0 && count == 0){
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}