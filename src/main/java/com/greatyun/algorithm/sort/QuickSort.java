package com.greatyun.algorithm.sort;

public class QuickSort {

    public void quickSort(int [] arr) {

        int pivot = (0 + arr.length) / 2;

    }

    public void quickSort(int [] arr , int left , int right) {
        int pl = left;
        int pr = right;
        // Pivot 기준 데이터 정함
        int pivot = arr[(pl + pr)  / 2];
        do {

            while(arr[pl] < pivot) pl++;    // 기준 데이터 기준으로 값을 비교해서 기준데이터 보다 큰 값을 발견할 경우 stop
            while(arr[pr] > pivot) pr--;    // 기준 데이터 기준으로 값을 비교해서 기준데이터 보다 작은 값을 발견할 경우 stop
            if(pl <= pr) {
                // 움직이는 index 가 서로 지나치지 않았다면 데이터를 체인지
                swap(arr , pl++ , pr--);
            }
        } while (pl <= pr);

        if(left < pr) quickSort(arr , left , pr);
        if(pl > right) quickSort(arr , pl , right);
    }

    private void swap(int[] arr, int i, int i1) {
        int t = arr[i];
        arr[i] = arr[i1];
        arr[i1] = t;
    }


    /**
     * 정렬되어 있는 array 에서 찾고자 하는 데이터의 index 를 리턴하시오
     *
     */
    public int searchValue(int [] arr , int targetValue) {
        return search(arr , 0 , arr.length-1 ,  targetValue);
    }

    public int search(int [] arr , int start , int end , int targetValue) {
        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(arr[mid] > targetValue) {
            return search(arr , start , mid-1 , targetValue);
        } else if(arr[mid] < targetValue) {
            return search(arr , mid+1 , end , targetValue);
        } else {
            int rememberIndex = mid;
            for (int i = mid; i >= 0; i--) {
                if(arr[i] != targetValue) {
                    break;
                } else {
                    rememberIndex = i;
                }
            }
            return rememberIndex;
        }
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int [] arr = {1,2,2,2,3,3,3,4,5};
        System.out.println(obj.searchValue(arr , 3));
    }
}
