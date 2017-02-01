import java.*;

class RegexMatch {
    public static boolean isDigit(char s) {
        int val = Character.getNumericValue(s);
        if( val >= 0 && val <= 9) return true;
        return false;
    }
    
    public static boolean patternMatch(String s, String pat) {
    if(s == null && pat == null) return true;
    if(s == null || pat == null) return false;
    int i = 0, j = 0, skip = 0, prevSkip = 0;
    while(i < s.length() && j < pat.length()) {
        if(isDigit(pat.charAt(j))) {
            prevSkip = skip;
            skip = skip*10 + Character.getNumericValue(pat.charAt(j));
            i = i - prevSkip + skip;
            j++;
        } else {
            skip = 0;
            if(s.charAt(i) != pat.charAt(j)) {
                return false;
            } else {
                i++; 
                j++;
            }
        }
    }
    return (i == s.length() && j == pat.length()) ? true : false;
}
    public static void main(String[] args) {
        //String s = "appppppppppels";
        //String pat = "a10e01s";
        //String s = "apple";
        //String pat = "";
        String s = "apples";
        String pat = "apple"; // test for s = apple and pat = a3e, a1ple, a2le, a3e, a4
        System.out.println(patternMatch(s, pat));
        
    }
}

