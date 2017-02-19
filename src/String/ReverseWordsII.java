// reverse words

public class ReverseWordsII {
    public static void reverse(char[] a, int left, int right) {
        while(left < right) {
            char tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }
    
    public static char[] reverseWords(char[] a) {
          reverse(a, 0, a.length-1);
          int i, j = 0;
          for(i = 0; i < a.length; i++) {
              if(a[i] == ' ') {
                  reverse(a, j, i-1);
                  j = i+1;
              }
          }
          reverse(a, j, i-1);
          
          return a;
    }
    
    public static void main(String[] args) {
        String str = "hi how are you?";
        char[] ch = reverseWords(str.toCharArray());
        System.out.println(ch);
    }
}
