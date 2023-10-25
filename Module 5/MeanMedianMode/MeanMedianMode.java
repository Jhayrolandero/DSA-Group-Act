import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianMode {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Given array: " + Arrays.toString(arr));
        System.out.println("Mean: " + calculateMean(arr));
        System.out.println("Median: " + calculateMedian(arr));
        System.out.println("Mode: " + calculateMode(arr));
        System.out.println("Range: " + calculateRange(arr));
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

    public static int calculateMode(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        int mode = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (freq > maxFreq) {
                maxFreq = freq;
                mode = entry.getKey();
            }
        }
        return mode;
    }

    public static int calculateRange(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }
}
