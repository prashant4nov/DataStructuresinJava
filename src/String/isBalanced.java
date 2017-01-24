import java.util.*;

public class HelloWorld{


public boolean isOpeningBracket(char c) {

   if(c=='('|| c=='{' || c== '[') return true;
    return false;
}

public boolean checkPair(char a, char b) {
    switch(a) {
        
        case '[': 
            if(b==']') return true;
        case '{':
            if(b=='}') return true;
        case '(':
            if(b==')') return true;
    }
    return false;
    
}

public boolean isBalanced(char [] arr) {
  if(arr==null) return true;
  if(arr.length<2) return false;
  
  Stack<Character> s = new Stack<Character>();
  
  for(int i = 0; i<arr.length; i++) {
  
       if(isOpeningBracket(arr[i])) {
          s.push(arr[i]);    
       } else if(!s.isEmpty() && checkPair(s.peek(), arr[i])) {
           s.pop();
       } else {
           return false;
       }
  }
  
  if(s.isEmpty()) return true;
  return false;
}
     public static void main(String []args){
         HelloWorld o = new HelloWorld();
         char[] arr = {')', ')' };
          //arr = new char[0];
          //char[] arr = {']', '}', ')', ')'};
         boolean ans = o.isBalanced(arr);
        System.out.print(ans);
     }
}
