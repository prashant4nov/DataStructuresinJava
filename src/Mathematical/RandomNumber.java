package Mathematical;
import java.util.Random;

/**
 * Created by jp on 5/28/16.
 * https://www.youtube.com/watch?v=sKLt-NcPXFE
 * r(25) = r(5) * r(5)  formula r(25) = 5*r(5) + r(5) - 5
 * now for r(7) from r(25). r(7)=r(25-25%7)%7+1 and ignore values 22, 23,24,25
 */
public class RandomNumber {
    static int foo() {
        int max = 5;
        int min = 1;
        Random rand = new Random();
        return (rand.nextInt((max - min) + 1) + min);
    }

    static int randomSeven() {
        int res = 5*foo() + foo() - 5;
        if(res < 22) return ((res%7)+1);
        return randomSeven();
    }

    public static void main(String[] args) {
        for(int i=0;i<7;i++){
            System.out.print(randomSeven() + " ");
        }
    }
}
