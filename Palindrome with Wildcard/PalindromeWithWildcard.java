public class PalindromeWithWildcard {
    public static String checkPalindromeWithWildcard(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < (n + 1) / 2; i++) {
            int j = n - i - 1;

            if (charArray[i] == '?' && charArray[j] == '?') {
                // If both characters are '?', replace them with 'a'
                charArray[i] = charArray[j] = 'a';
            } else if (charArray[i] == '?') {
                // If the current character is '?', replace it with the corresponding character from the other end
                charArray[i] = charArray[j];
            } else if (charArray[j] == '?') {
                // If the corresponding character is '?', replace it with the current character
                charArray[j] = charArray[i];
            } else if (charArray[i] != charArray[j]) {
                // If the characters are different and neither is '?', it's not a palindrome
                return "NO";
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(checkPalindromeWithWildcard("?ab??aa"));  // Expected output: "aabbaa"
        System.out.println(checkPalindromeWithWildcard("bab??a"));   // Expected output: "NO"
        System.out.println(checkPalindromeWithWildcard("?a?"));      // Expected output: "aaa"
    }
}
