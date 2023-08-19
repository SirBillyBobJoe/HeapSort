package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int[] bin = new int[10];
        int max = findMax(arr);
        String maxString = Integer.toString(max);
        int loop = maxString.length();
        int factor = 1;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < arr.length; j++) {
                int val = (arr[j] / factor) % 10;
                list.get(val).add(arr[j]);
            }
            order.clear();
            for (List<Integer> temp : list) {
                for (Integer temp1 : temp) {
                    order.add(temp1);
                }
                temp.clear();
            }

            factor *= 10;
            for (int k = 0; k < arr.length; k++) {
                arr[k] = order.get(k);
            }
        }

    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 7, 100, 52, 4, 7, 1, 3 };
        printArray(arr);
        radixSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    // A utility function to print array of size n
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}