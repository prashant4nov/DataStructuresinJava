class PreserveSpaces {
    public static char[] reverseString(char[] str) {
        int left = 0;
        int right = str.length-1;
        while(left < right) {
            if(str[left] != ' ' && str[right] != ' ') {
                char tmp = str[left];
                str[left++] = str[right];
                str[right--] = tmp;
            }  else {
                if(str[left] == ' ') left++;
                if(str[right] == ' ') right--;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        String str = " this    is very beautiful    ";
        System.out.println(reverseString(str.toCharArray()));
    }
}


// Reverse words without changing capitals or punctuation.
// Reverse words preserving position of spaces.
