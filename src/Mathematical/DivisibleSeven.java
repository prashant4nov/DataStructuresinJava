package Mathematical;

/**
 * Created by Prashant on 5/28/16.
 * for ab check a-2*b if it is divisible by 7.
 */
public class DivisibleSeven {
    static boolean divisibleSeven(int n) {
        if(n<0) return divisibleSeven(-n);
        if(n==0||n==7) return true;
        if(n<10) return false;
        return divisibleSeven((n/10)-2*(n-(n/10)*10));
    }
    public static void main(String[] args){
        System.out.print(divisibleSeven(20));
    }
}
