package org.example;

import java.util.List;


public class Code {
    // leetcode 120 https://leetcode.cn/problems/triangle/
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[] = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    //leetcode 215 https://leetcode.cn/problems/kth-largest-element-in-an-array/

    //    https://www.acwing.com/problem/content/787/
    public int[] quickSort(int[] arr, int l, int r) {
        int pivot = arr[(l + r) / 2];
        int t = qSort(arr, l, r, pivot);
        quickSort(arr, 0, t);
        quickSort(arr, t, arr.length);
        return arr;
    }

    public int qSort(int[] arr, int l, int r, int pivot) {
        while (l < r) {
            if (arr[l] <= pivot) {
                l++;
            }
            if (arr[r] >= pivot) {
                r--;
            }
            if (l >= r) break;
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return l;
    }

//    https://leetcode.cn/problems/distribute-elements-into-two-arrays-i/description/
    public int[] resultArray_100243(int[] nums) {
        int n = nums.length;
        if (nums.length <= 2) return nums;
        int[] res = new int[n];
        int[] temp = new int[n];
        res[0] = nums[0];
        temp[0] = nums[1];
        int i = 1, j = 1;
        for (int k = 2; k < n; k++) {
            if (res[i - 1] > temp[j - 1]) {
                res[i++] = nums[k];
            } else {
                temp[j++] = nums[k];
            }
        }
        for (int k = 0; k < j; k++) {
            res[i++] = temp[k];
        }
        return res;
    }

//    https://leetcode.cn/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + grid[i][j];
                if (sum[i + 1][j + 1] <= k) {
                    res++;
                }
            }
        }
        return res;
    }
//    https://leetcode.cn/problems/minimum-operations-to-write-the-letter-y-on-a-grid/description/
    public static int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int central = n / 2;
        int temp1[] = new int[3];
        int temp2[] = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= central & (i == j || i + j == n - 1)) {
                    temp1[grid[i][j]]++;
                } else if (i > central && j == central) {
                    temp1[grid[i][j]]++;
                } else {
                    temp2[grid[i][j]]++;
                }
            }
        }
        int maxNotChange = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    maxNotChange = Math.max(maxNotChange, temp1[i] + temp2[j]);
                }
            }
        }
        return n ^ 2 - maxNotChange;
    }



}
