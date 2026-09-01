class Solution {
    public int heightChecker(int[] arr) {
        int n= arr.length;
        int arr1[]=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=arr[i];
        }
        // boolean hasSwapped = true;
        // while (hasSwapped) {
        //     hasSwapped = false;
        //     for (int i = 0; i < arr.length - 1; i++) {
        //         if (arr[i] > arr[i + 1]) {
        //             // Swap adjacent elements
        //             int temp = arr[i];
        //             arr[i] = arr[i + 1];
        //             arr[i + 1] = temp;
        //             hasSwapped = true;
        //         }
        //     }
        // }
        Arrays.sort(arr1);
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=arr1[i]){
                count++;
            }
        }
        return count;
    }
}