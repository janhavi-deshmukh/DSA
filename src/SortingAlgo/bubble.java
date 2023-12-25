package SortingAlgo;

import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] nums={3,1,-4,2,5,8,-7,9,10,6};
         //bubbleSort(nums);
         // selectionSort(nums);
         //cyclicSort(nums);
        //insertionSort(nums);
        //recursiveInsertionSort(nums,0,10);
        //recursivebubble2(nums,nums.length-1,0);
        //recursiveselection(nums,nums.length,0,0);

        //int[] ans=mergeSort(nums);
        //System.out.print(Arrays.toString(ans));

        //mergeSortinplace(nums,0,nums.length);

//        quicksort(nums,0,nums.length-1);
//        System.out.print(Arrays.toString(nums));


    }

    static void selectionSort(int[] nums){
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i;j<n;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            swap(nums,minIndex,i);

        }
    }

    static void recursiveselection(int[] nums,int r,int c,int maxIndex){

        if(r==0) return;

        if(c<r){
            if(nums[c]>nums[maxIndex]){
                recursiveselection(nums,r,c+1,c);
            }else{
                recursiveselection(nums,r,c+1,maxIndex);
            }

        }else{

            //after searching max number swap it with end of array
            int temp=nums[r-1];
            nums[r-1]=nums[maxIndex];
            nums[maxIndex]=temp;

            //now we got largest element swapped at the end , so check the same by reducing row length
            recursiveselection(nums,r-1,0,0);

        }
    }

    static void cyclicSort(int[] nums){
         int i=0;
         while( i<nums.length-1){
             if(i!=nums[i]-1){
                 swap(nums,i,nums[i]-1);
             }
             else{
                 i++;
             }

         }

    }

    static void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

    static void bubbleSort(int[] nums){

        //start outer loop for each pass less than (n-1)
        for(int i=0;i<nums.length-1;i++){
            boolean isSwapped=false;
            //compare for each pass till (n-i)
            for(int j=1;j<nums.length-i;j++){
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                    isSwapped=true;
                }
            }
            //if no swapping for any pass means already sorted so stop
            if(!isSwapped){
                break;
            }
        }
    }
    static boolean isrecursiveSwapped=false;
    static void recursiveBubbleSort(int[] nums,int n){

        if(n==1) return;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]<nums[i]){
                int temp=nums[i+1];
                nums[i+1]=nums[i];
                nums[i]=temp;
                isrecursiveSwapped=true;
            }
        }
        if(isrecursiveSwapped==false) return;
        recursiveBubbleSort(nums,n-1);

    }

    static void recursivebubble2(int[]nums,int r,int c){
        if(r==0){
            return;
        }

        if(c<r){
            if(nums[c]>nums[c+1]){
                int temp=nums[c];
                nums[c]=nums[c+1];
                nums[c+1]=temp;
            }
            recursivebubble2(nums,r,c+1);

        }else{
            recursivebubble2(nums,r-1,0);

        }
    }

    static void insertionSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }

    static void recursiveInsertionSort(int[] nums,int i,int n){
        if(i==n) return;
        int j=i+1;
        while(j>0 && j<nums.length && nums[j]<nums[j-1]){
            int temp=nums[j];
            nums[j]=nums[j-1];
            nums[j-1]=temp;
            j--;
        }

        recursiveInsertionSort(nums,i+1,n);
    }

    public static int[] mergeSort(int[] nums){

        if(nums.length==1) {
            return nums;
        }

        int mid=nums.length/2;

        //orignal array is not get modified ans so it is not inplace and with every function call it is creting left and rigth array

        int[] left=mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(nums,mid,nums.length));

        return merge(left,right);
    }

    public static int[] merge(int[] first,int[] second){

        int i=0;
        int j=0;
        int k=0;
        int[] mergedarray=new int[first.length+second.length];

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mergedarray[k]=first[i];
                i++;
            }else{
                mergedarray[k]=second[j];
                j++;
            }
            k++;
        }

        while(i<first.length){
            mergedarray[k]=first[i++];
            k++;
        }
        while(j<second.length){
            mergedarray[k]=second[j++];
            k++;
        }

        return mergedarray;

    }


    public static void mergeSortinplace(int[] nums,int start,int end){

        if(end-start==1){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSortinplace(nums,start,mid);
        mergeSortinplace(nums,mid,end);

        mergeInplace(nums,start,mid,end);
    }

    public static void  mergeInplace(int[] nums,int start,int mid,int end){

        int[] mix=new int[end-start];
        int i=start;
        int j=mid;
        int k=0;

        while(i<mid && j<end){
            if(nums[i]<nums[j]){
                mix[k]=nums[i];
                i++;
            }else{
                mix[k]=nums[j];
                j++;
            }
            k++;
        }

        while(i<mid){
            mix[k]=nums[i++];
            k++;
        }
        while(j<end){
            mix[k]=nums[j++];
            k++;
        }

        System.arraycopy(mix, 0, nums, start, mix.length);



    }

    public static void quicksort(int[] nums,int low,int high){

        if(low>=high){
            return;
        }

        int s=low;
        int e=high;
        int m=s+(e-s)/2;

        //middle element as pivot leads to best case giving NlogN complexity

        int pivot=nums[m];

        while(s<=e){

            while(nums[s]<pivot){
                s++;
            }

            while(nums[e]>pivot){
                e--;
            }

            if(s<=e){

                int temp=nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }


        }

        //pivot is at coorect index,sort the two halves
        quicksort(nums,low,e);
        quicksort(nums,s,high);


    }




}
