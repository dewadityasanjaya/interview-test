function zigzagPattern(strArr) {
    const [str, rows] = strArr;
    const numRows = parseInt(rows, 10);
    
    if (numRows <= 1) {
        return str; // No zigzag pattern needed if rows are 1 or less
    }

    const len = str.length;
    const grid = Array.from({ length: numRows }, () => []);
    let row = 0;
    let down = false;

    for (let i = 0; i < len; i++) {
        grid[row].push(str[i]);
        if (row === 0 || row === numRows - 1) {
            down = !down;
        }
        row += down ? 1 : -1;
    }

    return grid.flat().join('');
}

// Example usage:
const strArr = ["coderbyte", "3"];
console.log(zigzagPattern(strArr)); // Output: "creoebtdy"
