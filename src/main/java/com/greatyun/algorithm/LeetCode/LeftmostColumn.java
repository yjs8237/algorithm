package com.greatyun.algorithm.LeetCode;

public class LeftmostColumn {


    public static void main(String [] args) {
        int [][] arr = {{0,0} , {0,1}};

        int row = 2;
        int col = 2;

        int index = -1;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            int subSum = 0;
            for (int j = 0; j < row; j++) {
                subSum += arr[j][i];
                System.out.println(arr[j][i]);
            }
            if(subSum < sum && subSum > 0) {
                index = i;
                sum = subSum;
                break;
            }
        }
        System.out.println("index : " + index);
        check();
    }

    static void check() {
        int [][] arr = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1}
                        };

//        int [][] arr = {{0,0},
//                {1,1}
//        };

//        int [][] arr = {{0,0},
//                {0,0}
//        };

        int row = arr.length;
        int col = arr[0].length;
        System.out.println("row : " + row);


        int mid = (0 + arr[0].length) / 2;
        System.out.println("mid : " + mid);
        while(true) {

            int subSum = 0;
            for (int i = 0; i < row; i++) {
                int tempNum = arr[i][mid];
                subSum += tempNum;
                if(tempNum == 1) {
                    break;
                }
            }

            if(subSum == 0) {
                break;
            }
            if(mid == 0) break;
            mid = mid / 2;
        }

        while(true) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += arr[i][mid];
            }
            if(sum > 0) {
                // 찾았다.
                System.out.println("찾았다 " + mid);
                break;
            } else {
                mid++;
                if(mid >= col) {
                    System.out.println("없네 " + "-1");
                    break;
                }
            }
        }

    }


}
