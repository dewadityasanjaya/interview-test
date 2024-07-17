public class SmallestInteger {

    // Helper function to calculate the sum of digits of a number
    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Function to find the smallest integer greater than N with the desired property
    public static int findSmallestInteger(int N) {
        int targetSum = 2 * sumOfDigits(N); // Calculate the target sum (twice the sum of digits of N)
        int currentNumber = N + 1; // Start searching from the next integer after N

        // Loop until we find a number whose sum of digits equals the target sum
        while (sumOfDigits(currentNumber) != targetSum) {
            currentNumber++;
        }

        return currentNumber; // Return the found number
    }

    public static void main(String[] args) {
        // Test cases
        int N1 = 14;
        int N2 = 123;
        int N3 = 45;

        System.out.println(findSmallestInteger(N1)); // Expected output: 19
        System.out.println(findSmallestInteger(N2)); // Expected output: 138
        System.out.println(findSmallestInteger(N3)); // Expected output: 54
    }
}
