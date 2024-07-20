import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeArraySum {
    
    public static int minimizeSum(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all elements into the max-heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll();
            int newElement = (int) Math.ceil(largest / 2.0);
            maxHeap.add(newElement);
        }

        // Calculate the sum of the final array
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 8};
        int k = 4;
        System.out.println(minimizeSum(nums, k));  // Output: 14
    }
}
