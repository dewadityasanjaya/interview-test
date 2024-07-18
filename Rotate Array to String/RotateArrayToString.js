function rotateArrayToString(arr) {
    // Extract the first element which is the rotation index
    const rotationIndex = arr[0];
    
    // Rotate the array starting from the `rotationIndex`
    const rotatedArray = arr.slice(rotationIndex).concat(arr.slice(0, rotationIndex));
    
    // Convert the rotated array into a string
    const resultString = rotatedArray.join('');
    
    return resultString;
}

// Example usage:
const array = [2, 3, 4, 1, 6, 10];
console.log(rotateArrayToString(array)); // Output: "4161023"
