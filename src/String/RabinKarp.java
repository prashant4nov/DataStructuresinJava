import java.io.*;

class RabinKarp {
    private int q = 121;
    public String search(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int p = 0; // hash value for the pattern
        int t = 0; // hash value for the text
        
        // Calculate the hash values for the pattern and text
        for (int i=0; i<m; i++) {
            p += pat.charAt(i)*Math.pow(q, i);
            t += txt.charAt(i)*Math.pow(q, i);
        }
        
        for(int i=0; i<=n-m; i++) {
            if(p==t) {
                // If hash values match
                int j;
                for(j=0; j<m; j++) {
                    // Check if pattern is found
                    if(pat.charAt(j) != txt.charAt(i+j)) {
                      break;    
                    }
                }
                
                if(j==m) {
                  return "Pattern found!";
                }
            } else {
              // Recalculate hash value t
              if(i<n-m) {
                t = t - txt.charAt(i);
                t = t/q;
                t += txt.charAt(i+m)*Math.pow(q, m-1);
              }
            }
        }
        return "pattern not found!";
    }

	public static void main (String[] args) {
		//code
		GFG o1 = new GFG();
		System.out.println(o1.search("GEEKS FOR GEEKS", "GEEK"));
	}
}
