/**
 * java
 * 将数组中含有0的元素向后一格复制一个，后面元素依次后移
 * 我的解题思路：for遍历数组，从左至右 如果遇到0 就让后面依次后移一位
 */

public class Duplicate_Zeros {
    public void duplicateZeros(int[] arr) {

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                for(int j=arr.length-2; j>i; j--) {
                    arr[j+1] = arr[j];  
                }
                if(i+1<arr.length) {
                    arr[i+1] = arr[i];
                    i++;
              }
            }
        }
    }
}