package String;

import java.util.HashMap;

/**
 * Write a method to decide if two strings are anagrams or not.
 * Created by jp on 5/24/16.
 */
public class Anagram {
    private static boolean anagram(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if(aLen!=bLen) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<aLen;i++) {
            if(map.containsKey(a.charAt(i))){
                map.put(a.charAt(i), map.get(a.charAt(i)).intValue()+1);
            } else {
                map.put(a.charAt(i), 1);
            }
        }
        for(int i=0;i<bLen;i++) {
            if(map.containsKey(b.charAt(i))) {
                if(map.get(b.charAt(i))==0) {
                    return false;
                } else {
                    map.put(b.charAt(i), map.get(b.charAt(i)).intValue()-1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String a = "hello";
        String b = "olleh";
        System.out.print(anagram(a,b));
    }
}
