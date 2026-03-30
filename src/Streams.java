// Online Java Compiler
/**
 * Problem: Write a function extractTransactionIds(List<String>log_list) that takes a list of log strings. Some logs contain a Transaction ID formatted as TXN:12345. 
 * Your function should: Find every string that contains TXN:. Extract only the numeric ID following the colon. Return a list of these IDs as integers. If a log doesn't have a TXN:, ignore it."
 * /
import java.util.*;

public class Streams {
    private static List<Integer> getIds(List<String> txs) {
        List<Integer> ids = new ArrayList<>();
        
        for(String tx: txs) {
            if(tx.contains("TXN:") && tx.split(":").length > 1){
                ids.add(Integer.valueOf(tx.split(":")[1]));
            }
        }
        return ids;
    }
  
    public static void main( String args[] ) {
        System.out.println( "Hello World!" );
        List<String> input = List.of("TXN:123", "TXN:456", "TXN:", "987");
        
        // without streams
        System.out.println(getIds(input));
        
        // using streams
        List<Integer> res = input.stream()
        .filter(i -> i.contains("TXN:") && i.length() > 4)
        .mapToInt(i -> Integer.valueOf(i.replace("TXN:", ""))).boxed().toList();
        res.forEach(System.out::println);
        
        // refining streams
        List<Integer> re = input.stream()
            .filter(s -> s.startsWith("TXN:") && s.length() > 4)
            .map(s -> s.split(":")[1])
            .filter(s -> s.matches("\\d+")) // only keep strings that are purely numeric.
            .map(Integer::valueOf)
            .toList();
        re.forEach(System.out::println);
        
        // regex within the stream
        List<Integer> result = input.stream()
            .filter(s -> s.startsWith("TXN:") && s.length() > 4)
            .map(s -> s.replaceAll("^TXN:", "")) // Remove prefix if it exists
            .filter(s -> s.matches("\\d+"))      // Only keep strings that are purely numeric
            .map(Integer::valueOf)
            .toList();
        result.forEach(System.out::println);
    }
}
