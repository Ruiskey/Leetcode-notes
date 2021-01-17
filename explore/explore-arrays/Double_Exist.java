public class Double_Exist {
    public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        int i,j=0;
        while(j < arr.length) {
            for(i=0; i<arr.length; i++) {
                if(arr[j] == 2*arr[i] && i != j) {
                    System.out.println(arr[j]+ "="+"2 * " + arr[i]);
                    return true;
                }
            }
            j++;
        }
        return false;       
    }
}
