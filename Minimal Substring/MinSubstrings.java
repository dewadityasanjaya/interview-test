import java.util.HashSet;

public class MinSubstrings {

    public static int minSubstrings(String s) {
        HashSet<Character> seenChars = new HashSet<>();
        int substringCount = 1;

        for (char c : s.toCharArray()) {
            if (seenChars.contains(c)) {
                // Start a new substring
                substringCount++;
                seenChars.clear();
            }
            seenChars.add(c);
        }

        return substringCount;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "world";
        String s2 = "cycle";
        String s3 = "abacaba";
        String s4 = "abcdefgh";

        System.out.println(minSubstrings(s1)); // Expected output: 1
        System.out.println(minSubstrings(s2)); // Expected output: 2
        System.out.println(minSubstrings(s3)); // Expected output: 4
        System.out.println(minSubstrings(s4)); // Expected output: 1
    }
}
