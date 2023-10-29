import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianMode {
    public static void main(String[] args) {
        int[] arr1 = { 4, 9, 1, 0, 4 };
        int[] arr2 = { 1, 7, 3, 9, 1, 2, 7 };
        int[] arr3 = { 9, 2, 2, 4, 6, 6, 8, 8 };
        int[] arr4 = { 3, 3, 2, 2, 1, 1, 6, 6 };
        int[] arr5 = { 3, 3, 3, 3, 3, 3 };
        int[] arr6 = { 1, 8, 0, 7, 1, 2, 11 };
        int[] arr7 = { 2, 5, 1, 5, 7, 2, 1, 3 };

        System.out.println("Given array: " + Arrays.toString(arr1));
        System.out.println("Mean: " + calculateMean(arr1));
        System.out.println("Median: " + calculateMedian(arr1));
        System.out.println("Mode: " + calculateMode(arr1));
        System.out.println("Range: " + calculateRange(arr1));
        System.out.println();

        System.out.println("Given array: " + Arrays.toString(arr2));
        System.out.println("Mean: " + calculateMean(arr2));
        System.out.println("Median: " + calculateMedian(arr2));
        System.out.println("Mode: " + calculateMode(arr2));
        System.out.println("Range: " + calculateRange(arr2));
        System.out.println();

        System.out.println("Given array: " + Arrays.toString(arr3));
        System.out.println("Mean: " + calculateMean(arr3));
        System.out.println("Median: " + calculateMedian(arr3));
        System.out.println("Mode: " + calculateMode(arr3));
        System.out.println("Range: " + calculateRange(arr3));
        System.out.println();

        System.out.println("Given array: " + Arrays.toString(arr4));
        System.out.println("Mean: " + calculateMean(arr4));
        System.out.println("Median: " + calculateMedian(arr4));
        System.out.println("Mode: " + calculateMode(arr4));
        System.out.println("Range: " + calculateRange(arr4));
        System.out.println();

        System.out.println("Given array: " + Arrays.toString(arr5));
        System.out.println("Mean: " + calculateMean(arr5));
        System.out.println("Median: " + calculateMedian(arr5));
        System.out.println("Mode: " + calculateMode(arr5));
        System.out.println("Range: " + calculateRange(arr5));
        System.out.println();

        System.out.println("Given array: " + Arrays.toString(arr6));
        System.out.println("Mean: " + calculateMean(arr6));
        System.out.println("Median: " + calculateMedian(arr6));
        System.out.println("Mode: " + calculateMode(arr6));
        System.out.println("Range: " + calculateRange(arr6));
        System.out.println();

        System.out.println("Given array: " + Arrays.toString(arr7));
        System.out.println("Mean: " + calculateMean(arr7));
        System.out.println("Median: " + calculateMedian(arr7));
        System.out.println("Mode: " + calculateMode(arr7));
        System.out.println("Range: " + calculateRange(arr7));
        System.out.println();
    }

    public static double calculateMean(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public static double calculateMedian(int[] arr) {
        Arrays.sort(arr);
        int mid = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (double) (arr[mid - 1] + arr[mid]) / 2;
        } else {
            return arr[mid];
        }
    }

    public static ArrayList<Integer> calculateMode(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        ArrayList<Integer> mode = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (freq == maxFreq) {
                mode.add(entry.getKey());
            }
        }

        if (mode.size() == arr.length) {
            mode.clear();
        }

        return mode;
    }

    public static int calculateRange(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }
}
