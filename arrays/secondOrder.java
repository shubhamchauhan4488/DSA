import java.util.Arrays;

public class Solution {
   int getSecondLargestElement(int n, int []a){
        int max = a[0];
        int secondLargest = -1;
        for(int i = 1; i< n; i++){
            if(a[i] > max){
                secondLargest = max; // transfer the value from min to the secondSmallest as now we found even higher number
                max = a[i]; // new maximum
            }else if(a[i] < max && a[i] > secondLargest){
                secondLargest = a[i]; // when a[i] is lesser than max, then we need to check if it is greater than the existing secondLargest
            }
        }
        return secondLargest;
    }
    
   int getSecondSmallestElement(int n, int []a){
        int min = a[0];
        int secondSmallest = Integer.MAX_VALUE; // take INT.MIN if all negative numbers are allowed in the array
        for(int i =1;i<n;i++){
            // System.out.println("secondSmallest" + secondSmallest);
            // System.out.println("a[i]" + a[i]);
            // System.out.println("min" + min);
            if(a[i]<min){
                secondSmallest = min; // transfer the value from min to the secondSmallest as now we found even lower number
                min = a[i]; // new minimum;
            }else if(a[i] > min && a[i] < secondSmallest){
                secondSmallest = a[i]; // when a[i] is greater than min, then we need to check if it is less than the existing secondsmallest
            }
        }
     return secondSmallest;

    }
    public static int[] getSecondOrderElements(int n, int []a) {
        Solution solution = new Solution();
        // Write your code here.
        int[] arr = new int[2];
        arr[0] = solution.getSecondLargestElement(n,a);
        arr[1] = solution.getSecondSmallestElement(n,a);
        // System.out.println(arr);
        return arr;
    }
}