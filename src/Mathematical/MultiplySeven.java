package Mathematical;

/**
 * Created by jp on 5/26/16.
 */
import java.io.*;

class MultiplySeven {
    static int multiply(int n) {
        return ((n<<3)-n);
    }
    public static void main(String[] args) {
        System.out.print(multiply(3));
    }
}
