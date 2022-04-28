// https://leetcode.com/problems/reverse-pairs/
// TC: O(nlogn)
// SC: O(n)

class Solution {
    int result = 0;
    
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return result;
    }
    
    private void mergeSort(int[] nums, int l, int r) {
        if(l>=r) {
            return;
        }
        
        int m = (l+r)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        count(nums, l, m, r);
        merge(nums, l, m, r);
    }
    
    private void count(int[] nums, int l, int m, int r) {
        int i=l,j=m+1;
        while(i<m+1 && j<r+1) {
            while(i<m+1 && j<r+1 && (long)nums[j]*2 >= (long)nums[i]) {
                i++;
            }
            result+=m+1-i;
            j++;
        }
    }
    
    private void merge(int[] nums, int l, int m, int r) {
        int arr1[] = new int[m-l+1];
        int arr2[] = new int[r-m];
        
        for(int i=l;i<m+1;i++) {
            arr1[i-l] = nums[i];
        }
        
        for(int i=m+1;i<=r;i++) {
            arr2[i-m-1] = nums[i];
        }
        
        int ptr1=0,ptr2=0;
        while(ptr1<arr1.length && ptr2<arr2.length) {
            if(arr1[ptr1] < arr2[ptr2]) {
                nums[l++] = arr1[ptr1];
                ptr1++;
            }
            else {
                nums[l++] = arr2[ptr2];
                ptr2++;
            }
        }
        
        while(ptr1<arr1.length) {
            nums[l++] = arr1[ptr1];
            ptr1++;
        }
        
        while(ptr2<arr2.length) {
            nums[l++] = arr2[ptr2];
            ptr2++;
        }
    }
}