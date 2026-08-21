class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]merge=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                merge[k++]=nums1[i];
                i++;
            }else{
                merge[k++]=nums2[j];
                j++;
            }
        }
        while(i<nums1.length){
            merge[k++]=nums1[i];
            i++;
        }
        while(j<nums2.length){
            merge[k++]=nums2[j];
            j++;
        }
        int len = merge.length;
        if (len % 2 == 0) {
            int left = len / 2 - 1;
            int right = len / 2;
            return (merge[left] + merge[right]) / 2.0;
        } else {
            return merge[len / 2];
        }
    }
}