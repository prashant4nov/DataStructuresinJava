
/*
Write a function that returns an array representing integer built from the original array with last incremented element by 1. 

Example:
input   [1,2,3,4] 
output  [1,2,3,5]

input   [1,2,3,9]  
output  [1,2,4,0]

[9]
[1,0]

Explanation:
Array of [1,2,3,4] represents integer 1234, last element is 4. 
After last element is incremented the new represenation integer value is 1235 so the ouput is [1,2,3,5]

Note: you can assume that input is not null or empty
[0;9]
*/

void addValue(int[] array, List result, int currIndex, int carry) {
       if(array[currIndex] < 9) {
          int val = array[currIndex] + carry;
          result.add(val);
          return;
       } else {
          result.add
       }
}

int[] lastEmelementIncremented(int[] array) {
}
