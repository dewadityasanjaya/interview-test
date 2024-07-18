function findCommonElements(arr1, arr2) {
    // Convert input strings to arrays of numbers
    let array1 = arr1.split(', ').map(Number);
    let array2 = arr2.split(', ').map(Number);
    
    // Find common elements
    let commonElements = array1.filter(value => array2.includes(value));
    
    // Join the common elements array with commas
    return commonElements.join(',');
}

// Input strings
let input1 = "1, 3, 4, 7, 13";
let input2 = "1, 2, 4, 13, 15";

// Find common elements and generate final output
let result = findCommonElements(input1, input2);

console.log(result); // Output: "1, 4, 13"
