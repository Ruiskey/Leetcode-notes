public class update_01 {
    public int[] replaceElements(int[] arr) {
        if(arr==null) {
            return arr;
        }
        int i=0;
        while(i<arr.length-1) {
            int max=arr[i+1];
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j]>max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
            i++;
        }
        arr[i] = -1;
        return arr;
    }
}
