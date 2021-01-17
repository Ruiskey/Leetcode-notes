/**
 * 设置两个index，前一个去寻找偶数，找到后与后面的那个进行置换，直到前面的到达endcnm
 */

public class update_04 {
    public int[] sortArrayByParity(int[] A) {
        if(A == null && A.length==0) {
            return A;
        }
        int i=0;
        int j=0;
        while(j<A.length) {
            if(A[j]%2 != 0) {
                j++;
            }else{
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                i++;
                j++;
            }
        }
        return A;
    }
}
