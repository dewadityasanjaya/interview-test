function maxProfit(jobs) {
    // Check if the input jobs array is empty
    if (jobs.length === 0) {
        return 0;
    }

    // Sort jobs by their end time
    jobs.sort((a, b) => a[1] - b[1]);

    // Function to find the last non-conflicting job
    function findLastNonConflictingJob(jobs, i) {
        for (let j = i - 1; j >= 0; j--) {
            if (jobs[j][1] <= jobs[i][0]) {
                return j;
            }
        }
        return -1;
    }

    // Initialize a DP array to store the maximum profit up to each job
    let n = jobs.length;
    let dp = Array(n).fill(0);

    // Base case: the profit of the first job is its own profit
    dp[0] = jobs[0][2];

    for (let i = 1; i < n; i++) {
        // Profit including the current job
        let includeProfit = jobs[i][2];
        let lastNonConflictingIndex = findLastNonConflictingJob(jobs, i);
        if (lastNonConflictingIndex != -1) {
            includeProfit += dp[lastNonConflictingIndex];
        }

        // Maximum profit up to the current job
        dp[i] = Math.max(includeProfit, dp[i - 1]);
    }

    // The maximum profit is the last value in the dp array
    return dp[n - 1];
}

// Example usage
const jobs1 = [
    [1, 3, 50],
    [3, 5, 20],
    [4, 6, 70],
    [6, 9, 60]
];

const jobs2 = [];

console.log(maxProfit(jobs1)); // Output: 120
console.log(maxProfit(jobs2)); // Output: 0
