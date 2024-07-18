function searchingFirstNonRepeatingCharacter(str) {
	const charCount = {};
  
	// Step 1: Count the occurrences of each character
	for (const char of str) {
	  if (char !== ' ') { // Ignore spaces
		charCount[char] = (charCount[char] || 0) + 1;
	  }
	}
  
	// Step 2: Find the first non-repeating character
	for (const char of str) {
	  if (char !== ' ' && charCount[char] === 1) {
		return char;
	  }
	}
  
	// Return null if no non-repeating character is found
	return null;
  }
  
// Test examples
console.log(searchingFirstNonRepeatingCharacter("abcdef")); // Output: "a"
console.log(searchingFirstNonRepeatingCharacter("hello world hi hey")); // Output: "w"  