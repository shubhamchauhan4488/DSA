public class CheckSorted {
    public static int isSorted(int n, int []a) {
        // Write your code here.
        for(int i = 0; i < n-1; i++){
            int min = a[i];
            if(a[i+1] < min){
                return 0;
            }
        }
        return 1;
    }
}